package com.hexad.parkinglot.ipark;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.hexad.parkinglot.entity.Car;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.parking.MultiStoreyParking;

public class ParkCarFinder implements ITicket {

	private int finderMethod;
	
	public ParkCarFinder(int finderMethod) {
		this.finderMethod=finderMethod;	
	}

	@Override
	public void execute(String... args) throws SlotIsNotEmpty {
		
		switch (finderMethod) {
		case 1:
			findRegistrationNumbersForCarsWithByColour(args[0]);
			break;
		case 2:
			findSlotNumbersForCarsWithByColour(args[0]);
			break;
		case 3:
			findSlotNumberByRegistrationNumber(args[0]);
			break;
		
		default:
			break;
		}
		
		
		
	}

	private void findRegistrationNumbersForCarsWithByColour(String colour) {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		
		List<String> reg= multiStoreyParking.getParkingSlotMap()
							.stream()
							.filter(c->colour.toUpperCase().equals(c.getColour().toUpperCase()))
							.map(Car::getRegistrationNumber).collect(Collectors.toList());
		
		System.out.println(String.join(", ", reg));
		
		
	}
	
	private void findSlotNumbersForCarsWithByColour(String colour) {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		
		List<String> reg= multiStoreyParking.getParkingSlotMap()
				.stream()
				.filter(c->colour.toUpperCase().equals(c.getColour().toUpperCase()))
				.map(Car::getSlotNumber).sorted().map(BigDecimal::toString).collect(Collectors.toList());
		if(reg.size()>0)
			System.out.println(String.join(", ", reg));
		else
			System.out.println("Not found");
	}
	
	
	private void findSlotNumberByRegistrationNumber(String registrationNumber) {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		
		List<String> reg= multiStoreyParking.getParkingSlotMap()
				.stream()
				.filter(c->registrationNumber.toUpperCase().equals(c.getRegistrationNumber().toUpperCase()))
				.map(Car::getSlotNumber).sorted().map(BigDecimal::toString).collect(Collectors.toList());
		
		
		if(reg.size()>0)
			System.out.println(String.join(", ", reg));
		else
			System.out.println("Not found");
	}
	
	
	
	
	public int getFinderMethod() {
		return finderMethod;
	}

	
	
	
}
