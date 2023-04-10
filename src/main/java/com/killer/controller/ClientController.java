package com.killer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.killer.entity.Client;
import com.killer.service.IClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

//	@Autowired
	private final IClientService service;

	@GetMapping
	public List<Client> readAll() throws Exception {
		return service.readAll();
	}

	@GetMapping("/{id}") // PathVariable
	public Client readById(@PathVariable("id") Integer id) throws Exception {
		return service.readById(id);
	}

	@PostMapping
	public Client create(@RequestBody Client client) throws Exception {
		return service.save(client);
	}

	@PutMapping("/{id}")
	public Client update(@PathVariable("id") Integer id, @RequestBody Client client) throws Exception{
		client.setIdClient(id);
		return service.update(client);
	}
}
