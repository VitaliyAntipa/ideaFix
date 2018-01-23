package com.ideafix.controller;

import com.ideafix.exception.ExceptionHandlerController;
import com.ideafix.exception.RestException;
import com.ideafix.model.dto.IdeaDTO;
import com.ideafix.model.pojo.Idea;
import com.ideafix.service.IdeaService;
import com.ideafix.service.util.JwtTokenUtil;
import com.ideafix.service.util.ValidationUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.ideafix.constants.SecurityConstants.HEADER_STRING;
import static com.ideafix.model.response.ControllerResponseEntity.*;

@RestController
@RequestMapping("/idea")
public class IdeaController extends ExceptionHandlerController {
    private IdeaService ideaService;
    private JwtTokenUtil jwtTokenUtil;

    public IdeaController(IdeaService ideaService, JwtTokenUtil jwtTokenUtil) {
        this.ideaService = ideaService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public Map<String, Object> findAll() {
        return successResponse("data", ideaService.getAll());
    }

    @RequestMapping(value = "/idea", method = RequestMethod.GET)
    public Map<String, Object> findIdeaById(@RequestParam("id") long ideaId) throws RestException {
        try {
            Idea idea = ideaService.getIdeaById(ideaId);

            if (idea == null)
                return errorResponse("No idea by such id");

            return successResponse("data", idea);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Map<String, Object> findIdeaByUserId(
            @RequestParam(value = "id") long userId) throws RestException {
        try {
            List<Idea> ideas = ideaService.getIdeasByUserId(userId);

            if (ideas.size() == 0)
                return errorResponse("This User has no ideas");

            return successResponse("data", ideas);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, Object> createIdea(@RequestBody IdeaDTO ideaDTO,
                                          @RequestParam("nickname")
                                                  String authorNickname)
            throws RestException {
        try {
            Idea idea = ideaService.createIdea(ideaDTO, authorNickname);

            return successResponse("data", idea);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, Object> editIdea(@RequestBody IdeaDTO ideaDTO,
                                        @RequestParam("id") long ideaId)
            throws RestException {
        try {
            Idea idea = ideaService.edit(ideaDTO, ideaId);

            return successResponse("data", idea);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Map<String, Object> deleteIdea(@RequestParam("id") long ideaId)
            throws RestException {
        try {
            ideaService.delete(ideaId);

            return emptyResponse();
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/ban/", method = RequestMethod.GET)
    public Map<String, Object> ban(@RequestParam("id") long ideaId, HttpServletRequest request)
            throws RestException {
        try {
            String authToken = request.getHeader(HEADER_STRING);
            ValidationUtil.assertNotBlank(authToken, "Authentication token");

            if (jwtTokenUtil.checkTocken(authToken)) {
                String Role = jwtTokenUtil.getRoleFromUser(authToken);
                ValidationUtil.assertEquals(Role, "ADMIN", "Wrong Role!");
                ideaService.setBan(ideaId);

                return emptyResponse();
            }

            return errorResponse("Wrong Token!");
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/unban/", method = RequestMethod.GET)
    public Map<String, Object> unban(@RequestParam("id") long ideaId, HttpServletRequest request)
            throws RestException {
        try {
            String authToken = request.getHeader(HEADER_STRING);
            ValidationUtil.assertNotBlank(authToken, "Authentication header");

            if (jwtTokenUtil.checkTocken(authToken)) {
                String Role = jwtTokenUtil.getRoleFromUser(authToken);
                ValidationUtil.assertEquals(Role, "ADMIN", "Wrong Role!");
                ideaService.unban(ideaId);

                return emptyResponse();
            }

            return errorResponse("Wrong Token!");
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }


}
