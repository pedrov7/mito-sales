package com.killer.controller;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.killer.entity.Category;
import com.killer.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> readAll() throws Exception {
        List<Category> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}") // PathVariable
    public ResponseEntity<Category> readById(@PathVariable("id") Integer id) throws Exception {
        Category object = service.readById(id);
        return new ResponseEntity<>(object,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) throws Exception {
        Category object = service.save(category);
        return new ResponseEntity<>(object,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Integer id, @RequestBody Category category) throws Exception {
        category.setIdCategory(id);
        Category object = service.update(category,id);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
