package com.example.cardatabase.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String brand, model, color, registrationNumber;
	
	private Integer year, price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	private Owner owner;
	
	public Car() {
		brand = ""; 
		model = ""; 
		color =""; 
		registrationNumber = "";
		year = 0;
		price = 0;
	}

	public Car(String brand, String model, String color, String registrationNumber, Integer year, Integer price,
			Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registrationNumber = registrationNumber;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}
}
