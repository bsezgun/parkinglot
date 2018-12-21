package com.hexad.parkinglot.parking;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

import com.hexad.parkinglot.entity.Car;

public class MultiStoreyParking {

	private Set<Car> 				parkingSlotMap;
	private BigDecimal 				maxParkingSlot;
	
	private MultiStoreyParking() {
		parkingSlotMap=new TreeSet<>();
	}
	
	private static MultiStoreyParking multiStoreyParking;
	
	public static MultiStoreyParking getInstance() {
		if(multiStoreyParking==null) {
			multiStoreyParking=new MultiStoreyParking();
		}
		return multiStoreyParking;
	}

	public BigDecimal getMaxParkingSlot() {
		return maxParkingSlot;
	}

	public void setMaxParkingSlot(BigDecimal maxParkingSlot) {
		this.maxParkingSlot = maxParkingSlot;
	}

	public Set<Car> getParkingSlotMap() {
		return parkingSlotMap;
	}

	public void setParkingSlotMap(Set<Car> parkingSlotMap) {
		this.parkingSlotMap = parkingSlotMap;
	}
	
	
}
