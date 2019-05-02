package com.claro.rpa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppApplication {

    /*
        server = "192.168.56.101"
        port = "22"
        user = "ieuser"
        password = "Passw0rd!"
        compartida = 'c:/Users/IEUser/Desktop/share'
     */

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
