package com.killer.repository;

import com.killer.entity.Category;

//no es necesario acotar con @Repository

public interface ICategoryRepository extends IGenericRepository<Category, Integer> { // una interfaz hereda, no puede
																	   			// implementar

}
