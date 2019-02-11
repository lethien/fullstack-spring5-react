package com.example.cardatabase.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cardatabase.domain.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
