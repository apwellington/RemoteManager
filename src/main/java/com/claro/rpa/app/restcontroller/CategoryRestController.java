package com.claro.rpa.app.restcontroller;

import com.claro.rpa.app.model.RpaCategory;
import com.claro.rpa.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {


    @Autowired
    CategoryService categoryService;


    @GetMapping("/all")
    public List<RpaCategory> allUsers(){
        return (List<RpaCategory>)  categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RpaCategory> user(@PathVariable("id") int id){
        RpaCategory found = categoryService.findById(id).get();
        if (found == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(found);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<RpaCategory> save(RpaCategory rpaCategory){
        RpaCategory created = categoryService.save(rpaCategory);
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
        RpaCategory rpaCategory = categoryService.findById(id).get();
        if(rpaCategory != null){
            categoryService.delete(rpaCategory);
        }
        return ResponseEntity.noContent().build();
    }





}
