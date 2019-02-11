package com.example.cardatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.repository.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarRepository carRepo;
	
	@GetMapping
	public Iterable<Car> getCars() {
		return carRepo.findAll();
	}
}
