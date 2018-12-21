package com.hexad.parkinglot.ipark;

import com.hexad.parkinglot.entity.ResultPark;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.parking.MultiStoreyParking;

public class StatusPark implements ITicket {


	@Override
	public ResultPark execute(String... args) throws SlotIsNotEmpty {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		System.out.printf("%-10s%-20s%-20s\n","Slot No.","Registration No","Colour");
		
		multiStoreyParking.getParkingSlotMap()
							.stream()
							.forEach(System.out::println);
		
		return null;
	}
}
