package com.hexad.parkinglot;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexad.parkinglot.entity.ResultPark;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.ipark.ITicket;
import com.hexad.parkinglot.ipark.LeaveCarFromSlot;
import com.hexad.parkinglot.ipark.ParkCarFinder;
import com.hexad.parkinglot.ipark.ParkCarToSlot;
import com.hexad.parkinglot.ipark.StatusPark;
import com.hexad.parkinglot.parking.MultiStoreyParking;

public class LeaveCarSlotTest {

	MultiStoreyParking multiStoreyParking;
	ITicket iTicket;
	ITicket iTicketStatus;
	ITicket iTicketLeave;
	ITicket iTicketFinderRegistrationNumbersForCarsWithColour;
	ITicket iTicketFinderSlotNumbersForCarsWithColour;
	ITicket iTicketFinderSlotNumberForRegistrationNumber;
	
	@Before
	public void setUp() {
		
		iTicket=new ParkCarToSlot();
		iTicketStatus=new StatusPark();
		iTicketLeave=new LeaveCarFromSlot();
		iTicketFinderRegistrationNumbersForCarsWithColour=new ParkCarFinder(1);
		iTicketFinderSlotNumbersForCarsWithColour=new ParkCarFinder(2);
		iTicketFinderSlotNumberForRegistrationNumber=new ParkCarFinder(3);
		
		multiStoreyParking=MultiStoreyParking.getInstance();
		multiStoreyParking.setParkingSlotMap(new TreeSet<>());
		multiStoreyParking.setMaxParkingSlot(BigDecimal.valueOf(50));
		String[] color= {"Red","Blue","White","Black","Green","Gray"};
		for (int i = 0; i < 50; i++) {
			try {
				iTicket.execute(new String[]{"KA-01-HH-"+Math.round(Math.random()*1000),color[Integer.parseInt(""+Math.round((Math.random()*5)))]});
			} catch (SlotIsNotEmpty e) {
				
			}
		}
		
	}

	@Test
	public void leaveToCar()  {
		
		try {
			ResultPark rp=iTicketLeave.execute(new String[]{"4"});
			assertTrue(rp.getCar().getSlotNumber()==BigDecimal.valueOf(4));
			
			rp=iTicketLeave.execute(new String[]{"5"});
			assertTrue(rp.getStatus().equals("Leaved"));
			
			rp=iTicketLeave.execute(new String[]{"25"});
			assertTrue(rp.getStatus().equals("Leaved"));
			
			rp=iTicketStatus.execute();
		} catch (SlotIsNotEmpty e) {
			
		}
		
		
		
	}
	
	@After
	public void statusToPark() throws SlotIsNotEmpty {
		//iTicketStatus.execute();
	}
}
