package com.example.redistutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisTutorialApplication.class, args);
    }

}
