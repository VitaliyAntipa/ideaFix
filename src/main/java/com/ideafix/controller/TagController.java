/*
 * Created by Antipa Vitaly (meloman@gmail.com) © All Rights Reserved.
 */

package com.ideafix.controller;

import com.ideafix.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.ideafix.model.response.ControllerResponseEntity.successResponse;

@RestController
@RequestMapping("/tags")
public class TagController {
    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        return successResponse("data", tagService.findAll());
    }

}
