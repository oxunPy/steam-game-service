package org.example.steamgameservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class SteamGameServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SteamGameServiceApplication.class, args);
    }

}
