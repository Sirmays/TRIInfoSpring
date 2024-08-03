package com.tri.trispring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TriSpringApplication {

    public static void main(String[] args) {

        //  SpringApplication.run(TriSpringApplication.class, args);

        SpringApplicationBuilder builder = new SpringApplicationBuilder(TriSpringApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

}
