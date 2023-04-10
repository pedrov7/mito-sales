package com.killer.service.impl;

import org.springframework.stereotype.Service;

import com.killer.entity.Category;
import com.killer.repository.ICategoryRepository;
import com.killer.repository.IGenericRepository;
import com.killer.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService{
	
	//en el servicio inyectamos las funciones del reposittory
	
	private final ICategoryRepository repo; //<- siempre debe ser final y usar @RequiredArgsConstructor

	@Override
	protected IGenericRepository<Category, Integer> getRepository() {
		return repo;
	}

//	@Override
//	public Category save(Category category) throws Exception {
//		return repo.save(category);
//	}
//
//	@Override
//	public Category update(Category category) throws Exception {
//		return repo.save(category);
//	}
//
//	@Override
//	public List<Category> readAll() throws Exception {
//		return repo.findAll();
//	}
//
//	@Override
//	public Category readById(Integer id) throws Exception {
//		return repo.findById(id).orElse(new Category());
//	}
//
//	@Override
//	public void delete(Integer id) throws Exception {
//		repo.deleteById(id);
//	}

}
