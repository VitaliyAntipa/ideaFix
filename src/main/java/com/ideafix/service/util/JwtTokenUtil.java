package com.ideafix.service.util;

import com.ideafix.model.security.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.ideafix.constants.SecurityConstants.SECRET;
import static com.ideafix.constants.SecurityConstants.TOKEN_PREFIX;


@Component
public class JwtTokenUtil {
    private String secret = SECRET;

    private Claims parseToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.substring(13))
                .getBody();

        return body;
    }

    public String getUsernameFromToken(String token) {
        return parseToken(token).getSubject();
    }

    public String generateToken(JwtUser jwtUser) {
        final Date createdDate = new Date();

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername())
                .setIssuedAt(createdDate)
                .setId(String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getAuthorities().iterator().next().toString());
        claims.put("isBanned", !jwtUser.isEnabled());
        claims.put("email", jwtUser.getEmail());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()));
    }

    public Boolean checkTocken(String requestToken) {
        return requestToken.startsWith(TOKEN_PREFIX);
    }
}
