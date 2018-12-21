package com.hexad.parkinglot.entity;

import java.util.List;

public class ResultPark {

	private String status;
	private Car car;
	private List<String> carAttributes;
	
	public ResultPark(String status) {
		this.status = status;
	}
	
	public ResultPark(String status, Car car) {
		this.status = status;
		this.car = car;
	}

	
	public ResultPark(String status, List<String> carAttributes) {
		this.status = status;
		this.carAttributes=carAttributes;
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

	public List<String> getCarAttributes() {
		return carAttributes;
	}

	public void setCarAttributes(List<String> carAttributes) {
		this.carAttributes = carAttributes;
	}
	
	
	
}
