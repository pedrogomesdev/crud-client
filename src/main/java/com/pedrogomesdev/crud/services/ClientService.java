package com.pedrogomesdev.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pedrogomesdev.crud.dto.ClientDTO;
import com.pedrogomesdev.crud.entities.Client;
import com.pedrogomesdev.crud.repositories.ClientRepository;
import com.pedrogomesdev.crud.services.expections.NotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findId(Long id) { 
		Client client = repository.findById(id).orElseThrow(() -> new NotFoundException("Recurso não encontrado")) ;
		return new ClientDTO(client);		
	}
	
}
