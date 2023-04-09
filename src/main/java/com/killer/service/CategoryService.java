package com.killer.service;

import org.springframework.stereotype.Service;
import com.killer.repository.CategoryRepo;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoryService {

//	@Autowired
	private final CategoryRepo repository;   //nueva forma de inyectar dependecias
	
}
