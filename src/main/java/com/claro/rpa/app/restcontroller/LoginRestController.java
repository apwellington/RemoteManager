package com.claro.rpa.app.restcontroller;

import com.claro.rpa.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginRestController {

    @Autowired
    UserService userService;

}
