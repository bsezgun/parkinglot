package com.hexad.parkinglot.ipark;

import java.math.BigDecimal;

import com.hexad.parkinglot.entity.Car;
import com.hexad.parkinglot.entity.ResultPark;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.parking.MultiStoreyParking;

public class ParkCarToSlot implements ITicket {



	@Override
	public ResultPark execute(String... params) throws SlotIsNotEmpty {
		MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance();
		
		if(multiStoreyParking.getParkingSlotMap().size()==multiStoreyParking.getMaxParkingSlot().intValue())
			throw new SlotIsNotEmpty();
		
		
		int[] slots=multiStoreyParking.getParkingSlotMap()
										.stream()
										.map(Car::getSlotNumber)
										.mapToInt(BigDecimal::intValue)
										.toArray();
		
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
		
		return new ResultPark("Allocated",car);
	}
	
	
}
