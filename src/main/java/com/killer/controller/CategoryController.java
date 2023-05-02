package com.killer.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.killer.dto.CategoryDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> readAll() throws Exception {
//        ModelMapper mapper = new ModelMapper(); //ya no usamos por que estamos inyectando la libreria mapper con un @Bean
        //Hace el uso de la libreria ModelMapper
        List<CategoryDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());

//        List<CategoryDTO> list = service.readAll().stream().map( e -> {
//            CategoryDTO dto = new CategoryDTO();
//            dto.setIdCategory(e.getIdCategory());
//            dto.setNameOfCategory(e.getName());
//            dto.setDescriptionCategory(e.getDescription());
//            dto.setEnableCategory(e.isEnabled());
//            return dto;
//        }).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}") // PathVariable
    public ResponseEntity<CategoryDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Category object = service.readById(id);
        CategoryDTO categoryDTO = this.convertToDto(object);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO dto) throws Exception {
        Category object = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoryDTO dto) throws Exception {
        dto.setIdCategory(id);
        Category object = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //convierte a DTO la entidad ↔ entidad a DTO
    private CategoryDTO convertToDto(Category obj) {
        return mapper.map(obj, CategoryDTO.class);
    }

    private Category convertToEntity(CategoryDTO objDto) {
        return mapper.map(objDto, Category.class);
    }

}
