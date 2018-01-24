package com.ideafix.controller;

import com.ideafix.exception.ExceptionHandlerController;
import com.ideafix.exception.RestException;
import com.ideafix.model.dto.IdeaDTO;
import com.ideafix.model.pojo.Idea;
import com.ideafix.model.security.JwtUser;
import com.ideafix.service.IdeaService;
import com.ideafix.service.util.JwtTokenUtil;
import com.ideafix.service.util.ValidationUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.ideafix.model.response.ControllerResponseEntity.*;

@RestController
@RequestMapping("/ideas")
public class IdeaController extends ExceptionHandlerController {
    private IdeaService ideaService;

    public IdeaController(IdeaService ideaService, JwtTokenUtil jwtTokenUtil) {
        this.ideaService = ideaService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public Map<String, Object> findAll() {
        return successResponse("data", ideaService.getAll());
    }

    @RequestMapping(value = "/idea", method = RequestMethod.GET)
    public Map<String, Object> findIdeaById(@RequestParam(value = "id") long id) throws RestException {
        try {
            Idea idea = ideaService.getIdeaById(id);

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
    public Map<String, Object> createIdea(@RequestBody IdeaDTO ideaDTO)
            throws RestException {
        try {
            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            ideaDTO.setAuthorId(user.getId());
            Idea idea = ideaService.createIdea(ideaDTO);

            return successResponse("data", idea);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, Object> editIdea(@RequestBody IdeaDTO ideaDTO)
            throws RestException {
        try {
            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            ValidationUtil.assertEquals(ideaDTO.getAuthorId(),
                    user.getId(),
                    "User's and Idea's user's id");
            Idea idea = ideaService.edit(ideaDTO);

            return successResponse("data", idea);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Map<String, Object> deleteIdea(@RequestParam(value = "id") long ideaId)
            throws RestException {
        try {
            ideaService.delete(ideaId);

            return emptyResponse();
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/ban", method = RequestMethod.GET)
    public Map<String, Object> banIdea(@RequestParam(value = "id") long ideaId,
                                       @RequestParam(value = "ban") boolean shouldBan)
            throws RestException {
        try {
            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            ValidationUtil.assertEquals(user
                            .getAuthorities()
                            .iterator()
                            .next().toString(),
                    "ADMIN",
                    "Wrong Role!");

            ideaService.setBan(ideaId, shouldBan);

            return emptyResponse();
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }


    }

}
