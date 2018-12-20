package com.hexad.parkinglot.ipark;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.hexad.parkinglot.entity.Car;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.parking.MultiStoreyParking;

public class ParkCarToSlot implements ITicket {



	@Override
	public void execute(String... params) throws SlotIsNotEmpty {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		
		if(multiStoreyParking.getParkingSlotMap().size()==multiStoreyParking.getMaxParkingSlot().intValue())
			throw new SlotIsNotEmpty();
		
		/*
		int slotId=multiStoreyParking.getParkingSlotMap().stream()
					.map(Car::getSlotNumber)
					.sorted()
					.reduce((p1, p2) -> 
					 p2.subtract(p1).intValue() > 0 ? p2.add(BigDecimal.valueOf(1)) : p1.add(BigDecimal.valueOf(1))).orElse(BigDecimal.valueOf(1)).intValue();
		
		*/
	
		
		
		int[] slots=multiStoreyParking.getParkingSlotMap()
		.stream().map(Car::getSlotNumber).sorted().mapToInt(BigDecimal::intValue).toArray();
		
		int slotId=1;
		for (int i : slots) {
			if(slotId==i) {
				slotId++;
			}else {
				break;
			}
		}
		
		Car car=new Car(BigDecimal.valueOf(slotId), params[0], params[1]);
		multiStoreyParking.getParkingSlotMap().add(car);
		System.out.println("Allocated slot number: "+slotId);
		
	}
	
	
}
