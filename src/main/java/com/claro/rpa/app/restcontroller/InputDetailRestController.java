package com.claro.rpa.app.restcontroller;


import com.claro.rpa.app.model.RpaInputDetail;
import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.service.InputDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/inputdetail")
public class InputDetailRestController {


    @Autowired
    InputDetailService inputDetailService;

    @GetMapping("/all")
    public List<RpaInputDetail> allUsers(){
        return (List<RpaInputDetail>) inputDetailService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RpaInputDetail> user(@PathVariable("id") int id){
        RpaInputDetail found = inputDetailService.findById(id).get();
        if (found == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(found);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<RpaInputDetail> save(RpaInputDetail rpaInputDetail){
        RpaInputDetail created = inputDetailService.save(rpaInputDetail);
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
        RpaInputDetail rpaInputDetail = inputDetailService.findById(id).get();
        if(rpaInputDetail != null){
            inputDetailService.delete(rpaInputDetail);
        }
        return ResponseEntity.noContent().build();
    }


}
