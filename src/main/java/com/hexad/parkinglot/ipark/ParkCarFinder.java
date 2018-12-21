package com.hexad.parkinglot.ipark;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hexad.parkinglot.entity.Car;
import com.hexad.parkinglot.entity.ResultPark;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.parking.MultiStoreyParking;

public class ParkCarFinder implements ITicket {

	private int finderMethod;
	
	public ParkCarFinder(int finderMethod) {
		this.finderMethod=finderMethod;	
	}

	@Override
	public ResultPark execute(String... args) throws SlotIsNotEmpty {
		List<String> carAttributes=new ArrayList<>();
		switch (finderMethod) {
		case 1:
			carAttributes=findRegistrationNumbersForCarsWithByColour(args[0]);
			break;
		case 2:
			carAttributes=findSlotNumbersForCarsWithByColour(args[0]);
			break;
		case 3:
			carAttributes=findSlotNumberByRegistrationNumber(args[0]);
			break;
		
		default:
			break;
		}
		
		return new ResultPark("FIND",carAttributes);
		
	}

	private List<String> findRegistrationNumbersForCarsWithByColour(String colour) {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		
		List<String> reg= multiStoreyParking.getParkingSlotMap()
											.stream()
											.filter(c->colour.toUpperCase().equals(c.getColour().toUpperCase()))
											.map(Car::getRegistrationNumber).collect(Collectors.toList());
		
		System.out.println(String.join(", ", reg));
		return reg;
	}
	
	private List<String> findSlotNumbersForCarsWithByColour(String colour) {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		
		List<String> reg= multiStoreyParking.getParkingSlotMap()
											.stream()
											.filter(c->colour.toUpperCase().equals(c.getColour().toUpperCase()))
											.map(Car::getSlotNumber)
											.map(BigDecimal::toString)
											.collect(Collectors.toList());
		if(reg.size()>0)
			System.out.println(String.join(", ", reg));
		else
			System.out.println("Not found");
		
		return reg;
	}
	
	
	private List<String> findSlotNumberByRegistrationNumber(String registrationNumber) {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		
		List<String> reg= multiStoreyParking.getParkingSlotMap()
											.stream()
											.filter(c->registrationNumber.toUpperCase().equals(c.getRegistrationNumber().toUpperCase()))
											.map(Car::getSlotNumber)
											.map(BigDecimal::toString)
											.collect(Collectors.toList());
		
		
		if(reg.size()>0)
			System.out.println(String.join(", ", reg));
		else
			System.out.println("Not found");
		
		return reg;
	}
	
	public int getFinderMethod() {
		return finderMethod;
	}
}