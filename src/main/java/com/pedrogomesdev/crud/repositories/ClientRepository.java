package com.pedrogomesdev.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrogomesdev.crud.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
