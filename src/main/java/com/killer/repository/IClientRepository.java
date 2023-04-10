package com.killer.repository;

import com.killer.entity.Client;

//no es necesario acotar con @Repository

public interface IClientRepository extends IGenericRepository<Client, Integer> { // una interfaz hereda, no puede
																	   			// implementar

}
