package com.hexad.parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.TreeSet;

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

public class ParkCarToSlotTest {

	MultiStoreyParking multiStoreyParking;
	ITicket iTicket;
	ITicket iTicketStatus;
	ITicket iTicketLeave;
	ITicket iTicketFinderRegistrationNumbersForCarsWithColour;
	ITicket iTicketFinderSlotNumbersForCarsWithColour;
	ITicket iTicketFinderSlotNumberForRegistrationNumber;
	
	
	@Before
	public void setUp() {
		multiStoreyParking=MultiStoreyParking.getInstance();
		multiStoreyParking.setParkingSlotMap(new TreeSet<>());
		multiStoreyParking.setMaxParkingSlot(BigDecimal.valueOf(6));
		iTicket=new ParkCarToSlot();
		iTicketStatus=new StatusPark();
		iTicketLeave=new LeaveCarFromSlot();
		iTicketFinderRegistrationNumbersForCarsWithColour=new ParkCarFinder(1);
		iTicketFinderSlotNumbersForCarsWithColour=new ParkCarFinder(2);
		iTicketFinderSlotNumberForRegistrationNumber=new ParkCarFinder(3);
		
	}

	@Test
	public void parkToCar()  {
		ResultPark rp=null;
		
		assertEquals(BigDecimal.valueOf(6), multiStoreyParking.getMaxParkingSlot());
		
		try {
			rp=iTicket.execute(new String[]{"KA-01-HH-1234","Red"});
			assertTrue(rp.getStatus().equals("Allocated"));
		} catch (SlotIsNotEmpty e) {
			
		}	
		
		try {
			rp=iTicket.execute(new String[]{"KA-01-HH-9999","White"});
			assertTrue(rp.getStatus().equals("Allocated"));
		} catch (SlotIsNotEmpty e) {
			
		}
		try {
			rp=iTicket.execute(new String[]{"KA-01-BB-0001","White"});
			assertTrue(rp.getStatus().equals("Allocated"));
		} catch (SlotIsNotEmpty e) {}
		
		try {
			rp=iTicket.execute(new String[]{"KA-01-HH-7777","Black"});
			assertTrue(rp.getStatus().equals("Allocated"));
		} catch (SlotIsNotEmpty e) {}	
		
		try {
			rp=iTicket.execute(new String[]{"KA-01-HH-2701","White"});
			assertTrue(rp.getStatus().equals("Allocated"));
		} catch (SlotIsNotEmpty e) {}	
		
		try {
			rp=iTicket.execute(new String[]{"KA-01-HH-3141","Yellow"});
			assertTrue(rp.getStatus().equals("Allocated"));
		} catch (SlotIsNotEmpty e) {}
		
		try {
			rp=iTicketLeave.execute(new String[]{"4"});
			assertTrue(rp.getStatus().equals("Leaved"));
		} catch (SlotIsNotEmpty e) {}	
		
		try {
			iTicketStatus.execute();
		} catch (SlotIsNotEmpty e) {}
		
		try {
			rp=iTicket.execute(new String[]{"KA-01-P-333","White"});
			assertTrue(rp.getStatus().equals("Allocated"));
		} catch (SlotIsNotEmpty e) {}	
		
		try {
			rp=iTicket.execute(new String[]{"DL-12-AA-9999","White"});
			
		} catch (SlotIsNotEmpty e) {
			assertTrue(e.getMessage().equals("Park is Full"));
		}
		
		
		
		try {
			rp=iTicketFinderRegistrationNumbersForCarsWithColour.execute(new String[]{"White"});
			assertTrue(rp.getCarAttributes().size()==4);
		} catch (SlotIsNotEmpty e) {}
		
		try {
			rp=iTicketFinderSlotNumbersForCarsWithColour.execute(new String[]{"White"});
			assertTrue(rp.getCarAttributes().size()==4);
		} catch (SlotIsNotEmpty e) {}
		
		try {
			rp=iTicketFinderSlotNumberForRegistrationNumber.execute(new String[]{"KA-01-HH-3141"});
			assertTrue(rp.getCarAttributes().get(0).equals("6"));
		} catch (SlotIsNotEmpty e) {}
		
		try {
			rp=iTicketFinderSlotNumberForRegistrationNumber.execute(new String[]{"MH-04-AY-1111"});
			assertTrue(rp.getCarAttributes().size()==0);
		} catch (SlotIsNotEmpty e) {}
		
		
	}
	
	
}
