package com.pinet.app;

import com.pinet.app.model.UserServicesResponse;
import com.pinet.app.service.UserServicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableScheduling
public class PokharaInternetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokharaInternetApplication.class, args);


    }
}
