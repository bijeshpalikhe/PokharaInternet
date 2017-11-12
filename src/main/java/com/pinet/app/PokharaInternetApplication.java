package com.pinet.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class PokharaInternetApplication {

    private static final Logger LOGGER= LoggerFactory.getLogger(PokharaInternetApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PokharaInternetApplication.class, args);

        LOGGER.error("Logger Error message");
        LOGGER.warn("Logger Warn message");
        LOGGER.info("Logger Info message");
        LOGGER.debug("Logger Debug message");

    }
}
