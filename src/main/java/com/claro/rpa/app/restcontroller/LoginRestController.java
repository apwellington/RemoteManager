package com.claro.rpa.app.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginRestController {

    @GetMapping("/login")
    public String getLogin(){
        return "Is Workin";
    }

}
