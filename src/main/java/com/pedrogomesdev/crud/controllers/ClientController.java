package com.pedrogomesdev.crud.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedrogomesdev.crud.dto.ClientDTO;
import com.pedrogomesdev.crud.services.ClientService;

import jakarta.validation.Valid;

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
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
		Page<ClientDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO>  insert(@Valid @RequestBody ClientDTO dto) { 
			dto = service.insert(dto);	
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                .buildAndExpand(dto.getId()).toUri();
			 return ResponseEntity.created(uri).body(dto);
	}
}
