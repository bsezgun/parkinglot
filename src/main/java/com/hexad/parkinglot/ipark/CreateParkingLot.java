package com.hexad.parkinglot.ipark;

import java.math.BigDecimal;

import com.hexad.parkinglot.entity.ResultPark;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.parking.MultiStoreyParking;

public class CreateParkingLot implements ITicket {

	@Override
	public ResultPark execute(String... args) throws SlotIsNotEmpty {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		multiStoreyParking.setMaxParkingSlot(new BigDecimal(args[0]));
		System.out.println("Created a parking lot with "+args[0]+" slots");
		return new ResultPark("PARK CREATED");
	}
}