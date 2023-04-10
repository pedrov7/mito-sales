package com.killer.service;

import com.killer.entity.Client;

public interface IClientService extends ICRUD<Client, Integer> {

	// ↓↓↓↓↓ ya no se usan por que vamos a heredar de la interfaz ICRUD generica

//	Client save(Client client) throws Exception;
//
//	Client update(Client client) throws Exception;
//
//	List<Client> readAll() throws Exception;
//
//	Client readById(Integer id) throws Exception;
//
//	void delete(Integer id) throws Exception;

}
