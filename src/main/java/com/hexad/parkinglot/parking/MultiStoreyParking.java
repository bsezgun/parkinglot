package com.hexad.parkinglot.parking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hexad.parkinglot.entity.Car;

public class MultiStoreyParking {

	private List<Car> 				parkingSlotMap;
	private BigDecimal 				maxParkingSlot;
	
	private MultiStoreyParking() {
		parkingSlotMap=new ArrayList<>();
	}
	
	private static MultiStoreyParking multiStoreyParking;
	
	public static MultiStoreyParking getInstance() {
		if(multiStoreyParking==null) {
			multiStoreyParking=new MultiStoreyParking();
		}
		return multiStoreyParking;
	}

	

	public List<Car> getParkingSlotMap() {
		return parkingSlotMap;
	}



	public BigDecimal getMaxParkingSlot() {
		return maxParkingSlot;
	}

	public void setMaxParkingSlot(BigDecimal maxParkingSlot) {
		this.maxParkingSlot = maxParkingSlot;
	}
}
