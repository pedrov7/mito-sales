package com.killer.service.impl;

import org.springframework.stereotype.Service;

import com.killer.entity.Client;
import com.killer.repository.IClientRepository;
import com.killer.repository.IGenericRepository;
import com.killer.service.IClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDImpl<Client, Integer> implements IClientService{
	
	//en el servicio inyectamos las funciones del reposittory
	
	private final IClientRepository repo; //<- siempre debe ser final y usar @RequiredArgsConstructor

	@Override
	protected IGenericRepository<Client, Integer> getRepository() {
		return repo;
	}
	
	

//	@Override
//	public Client save(Client client) throws Exception {
//		return repo.save(client);
//	}
//
//	@Override
//	public Client update(Client client) throws Exception {
//		return repo.save(client);
//	}
//
//	@Override
//	public List<Client> readAll() throws Exception {
//		return repo.findAll();
//	}
//
//	@Override
//	public Client readById(Integer id) throws Exception {
//		return repo.findById(id).orElse(new Client());
//	}
//
//	@Override
//	public void delete(Integer id) throws Exception {
//		repo.deleteById(id);
//	}

}
