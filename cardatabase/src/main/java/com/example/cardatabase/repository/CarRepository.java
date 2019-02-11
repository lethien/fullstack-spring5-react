package com.example.cardatabase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.cardatabase.domain.Car;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

	List<Car> findByBrand(@Param("brand") String brand);
	
	List<Car> findByColor(@Param("color") String color);
}
