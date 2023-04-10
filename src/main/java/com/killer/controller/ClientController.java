package com.killer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		return service.update(client,id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
