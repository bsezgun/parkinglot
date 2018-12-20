package com.hexad.parkinglot.util;

import com.hexad.parkinglot.exception.CommandNotFound;
import com.hexad.parkinglot.ipark.CreateParkingLot;
import com.hexad.parkinglot.ipark.ITicket;
import com.hexad.parkinglot.ipark.LeaveCarFromSlot;
import com.hexad.parkinglot.ipark.ParkCarFinder;
import com.hexad.parkinglot.ipark.ParkCarToSlot;
import com.hexad.parkinglot.ipark.StatusPark;

public class Commands {

	
	
	public ITicket getCommandsToExecute(String command) throws CommandNotFound {
		if(command.equals("create_parking_lot"))
			return new CreateParkingLot();
		else if(command.equals("park"))
			return new ParkCarToSlot();
		else if(command.equals("leave"))
			return new LeaveCarFromSlot();
		else if(command.equals("status"))
			return new StatusPark();
		else if(command.equals("registration_numbers_for_cars_with_colour"))
			return new ParkCarFinder(1);
		else if(command.equals("slot_numbers_for_cars_with_colour"))
			return new ParkCarFinder(2);
		else if(command.equals("slot_number_for_registration_number"))
			return new ParkCarFinder(3);
		
		
		else
			throw new CommandNotFound();
	
		
		
		
		
		
		
	}
}
