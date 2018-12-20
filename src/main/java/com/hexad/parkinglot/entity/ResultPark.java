package com.hexad.parkinglot.entity;

import java.util.Optional;

public class ResultPark {

	private String status;
	private Car car;
	
	
	
	public ResultPark(String status, Optional<Car> car) {
		this.status = status;
		this.car = car.orElse(null);
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	
}
