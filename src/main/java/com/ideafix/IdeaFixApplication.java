package com.ideafix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class IdeaFixApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdeaFixApplication.class, args);
    }

}



