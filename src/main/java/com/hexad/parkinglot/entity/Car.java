package com.hexad.parkinglot.entity;

import java.math.BigDecimal;

public class Car implements Comparable<Car>{

	private BigDecimal slotNumber;
	private String colour;
	private String registrationNumber;
	
	public Car(BigDecimal slotNumber,  String registrationNumber,String colour) {
		super();
		this.slotNumber = slotNumber;
		this.colour = colour;
		this.registrationNumber = registrationNumber;
	}
	
	public BigDecimal getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(BigDecimal slotNumber) {
		this.slotNumber = slotNumber;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Override
	public int compareTo(Car car) {
		return slotNumber.compareTo(car.getSlotNumber());
	}

	

	
	
	
	
}
