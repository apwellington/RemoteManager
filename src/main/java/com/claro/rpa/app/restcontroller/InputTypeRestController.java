package com.claro.rpa.app.restcontroller;


import com.claro.rpa.app.model.RpaInputType;
import com.claro.rpa.app.service.InputTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/inputtype")
public class InputTypeRestController {

    @Autowired
    InputTypeService inputTypeService;

    @GetMapping("/all")
    public List<RpaInputType> allUsers(){
        return (List<RpaInputType>) inputTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RpaInputType> user(@PathVariable("id") int id){
        RpaInputType found = inputTypeService.findById(id).get();
        if (found == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(found);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<RpaInputType> save(RpaInputType rpaInputType){
        RpaInputType created = inputTypeService.save(rpaInputType);
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
        RpaInputType rpaInputType = inputTypeService.findById(id).get();
        if(rpaInputType != null){
            inputTypeService.delete(rpaInputType);
        }
        return ResponseEntity.noContent().build();
    }


}
