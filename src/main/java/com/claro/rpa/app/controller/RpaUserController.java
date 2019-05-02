package com.claro.rpa.app.controller;

import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.service.RpaUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RpaUserController {

    @Autowired
    RpaUserServiceImpl userService;

    @GetMapping("/all")
    public List<RpaUser> allUsers(){
        return (List<RpaUser>) userService.findAll();
    }

    @GetMapping("/{id}")
    public RpaUser allUsers(@PathVariable int id){
        return userService.findById(id).get();
    }

    @PostMapping("/save")
    public String save(@RequestBody RpaUser rpaUser){
        return "";
    }

    @PostMapping("/delete")
    public String delete(){
        return "";
    }

}
