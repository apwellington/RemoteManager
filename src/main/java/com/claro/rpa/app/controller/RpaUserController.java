package com.claro.rpa.app.controller;

import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.service.RpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RpaUserController {

    @Autowired
    RpaUserService userService;

    @GetMapping("/all")
    public List<RpaUser> allUsers(){
        return (List<RpaUser>) userService.findAll();
    }

    @GetMapping("/{id}")
    public RpaUser allUsers(@PathVariable int id){
        return userService.findById(id).get();
    }

}
