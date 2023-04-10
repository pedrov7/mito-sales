package com.killer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.killer.entity.Category;
import com.killer.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

//	@Autowired
	private final ICategoryService service;

	@GetMapping
	public List<Category> readAll() throws Exception {
		return service.readAll();
	}

	@GetMapping("/{id}") // PathVariable
	public Category readById(@PathVariable("id") Integer id) throws Exception {
		return service.readById(id);
	}

	@PostMapping
	public Category create(@RequestBody Category category) throws Exception {
		return service.save(category);
	}

	@PutMapping("/{id}")
	public Category update(@PathVariable("id") Integer id, @RequestBody Category category) throws Exception{
		category.setIdCategory(id);
		return service.update(category);
	}
}