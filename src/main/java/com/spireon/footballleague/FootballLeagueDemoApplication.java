package com.spireon.footballleague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FootballLeagueDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballLeagueDemoApplication.class, args);
    }

}
