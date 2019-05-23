package com.claro.rpa.app;

import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


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
