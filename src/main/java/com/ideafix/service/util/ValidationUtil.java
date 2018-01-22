package com.ideafix.service.util;

import com.ideafix.model.dto.UserDTO;
import com.ideafix.service.UserService;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidationUtil {

    @Autowired
    UserService userService;

    private ValidationUtil() {
        throw new NotImplementedException("Utility classes cannot be instantiated");
    }

    public static void assertNotBlank(String fieldValue, String message) {
        if (StringUtils.isBlank(fieldValue)) {
            throw new IllegalArgumentException(message + " cannot be empty");
        }
    }

    public static void assertPasswordsEqualls(String loginUserPassword,
                                             String originalPassword) {
        if (!loginUserPassword.equals(originalPassword)) {
            throw new IllegalArgumentException("Wrong password!");
        }
    }

    public static void assertNotBlank(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message + " cannot be empty");
        }
    }
}
