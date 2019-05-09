package com.claro.rpa.app.restcontroller;
import com.claro.rpa.app.model.RpaRobot;
import com.claro.rpa.app.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/service/robot")
public class RobotRestController {
    
    @Autowired
    RobotService robotService;
    
    @GetMapping("/all")
    public List<RpaRobot> allUsers(){
        return (List<RpaRobot>) robotService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RpaRobot> user(@PathVariable("id") int id){
        RpaRobot found = robotService.findById(id).get();
        if (found == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(found);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<RpaRobot> save(RpaRobot rpaRobot){
        RpaRobot created = robotService.save(rpaRobot);
        if (created == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(created.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(created);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        RpaRobot rpaRobot = robotService.findById(id).get();
        if(rpaRobot != null){
            robotService.delete(rpaRobot);
        }
        return ResponseEntity.noContent().build();
    }
}
