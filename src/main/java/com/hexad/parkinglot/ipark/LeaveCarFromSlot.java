package com.hexad.parkinglot.ipark;

import java.util.Optional;

import com.hexad.parkinglot.entity.Car;
import com.hexad.parkinglot.entity.ResultPark;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.parking.MultiStoreyParking;

public class LeaveCarFromSlot implements ITicket {

	@Override
	public ResultPark execute(String... params) throws SlotIsNotEmpty {
	     Optional<Car> car=MultiStoreyParking.getInstance()
	     		.getParkingSlotMap()
	     		.stream().filter(c->c.getSlotNumber().intValue()==Integer.parseInt(params[0]))
	     		.findFirst();
		
	     if(car.isPresent()) {
	    	 MultiStoreyParking.getInstance()
	     		.getParkingSlotMap().remove(car.get());
	     
	     	System.out.println("Slot number "+params[0]+" is free");
	     	return new ResultPark("Leaved",car.get());
	     }else {
	    	 System.out.println("NO CARS FOUND AT THIS SLOT");
	    	 return new ResultPark("NOT FOUND");
	     }
	 }
}