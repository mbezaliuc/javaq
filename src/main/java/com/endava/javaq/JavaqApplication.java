package com.endava.javaq;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@RequiredArgsConstructor
@PropertySource(value = "classpath:config.properties", ignoreResourceNotFound = true)
@PropertySource(value = "${config.path}/config.properties", ignoreResourceNotFound = true)
public class JavaqApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JavaqApplication.class, args);
    }

}
