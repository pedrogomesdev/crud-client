package com.pedrogomesdev.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrogomesdev.crud.dto.ClientDTO;
import com.pedrogomesdev.crud.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	
	@Autowired
	private ClientService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findId(@PathVariable Long id){
		ClientDTO dto = service.findId(id);
		return ResponseEntity.ok(dto);
	}
	
}
