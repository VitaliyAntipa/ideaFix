package com.ideafix.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlerController {
    private static final Logger LOG =
            Logger.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RestException.class)
    public String handleException(RestException e) {
        LOG.error("Ошибка: " + e.getMessage(), e);
        return "Ошибка: " + e.getMessage();
    }
}