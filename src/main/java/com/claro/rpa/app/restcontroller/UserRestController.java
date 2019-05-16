package com.claro.rpa.app.restcontroller;

import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/all")
    public List<RpaUser> allUsers(){
        return (List<RpaUser>) userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RpaUser> user(@PathVariable("id") int id){
        RpaUser foundStudent = userService.findById(id).get();
        if (foundStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundStudent);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<RpaUser> save(RpaUser rpaUser){
        RpaUser createdStudent = userService.save(rpaUser);
        if (createdStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdStudent.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdStudent);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        RpaUser rpaUser = userService.findById(id).get();
        if(rpaUser != null){
            userService.delete(rpaUser);
        }
        return ResponseEntity.noContent().build();
    }


}
