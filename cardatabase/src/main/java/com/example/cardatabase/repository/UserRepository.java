package com.example.cardatabase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cardatabase.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserName(String username);
}
