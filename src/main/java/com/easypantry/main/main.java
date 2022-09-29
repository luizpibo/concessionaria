package com.easypantry.main;

import com.easypantry.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class main extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
}