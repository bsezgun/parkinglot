package com.hexad.parkinglot;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		
		try {
			iTicket.execute(new String[]{"KA-01-HH-1234","Red"});
			iTicket.execute(new String[]{"KA-01-HH-9999","White"});
			iTicket.execute(new String[]{"KA-01-BB-0001","White"});
			iTicket.execute(new String[]{"KA-01-HH-7777","Black"});
			iTicket.execute(new String[]{"KA-01-HH-2701","White"});
			iTicket.execute(new String[]{"KA-01-HH-3141","Yellow"});
			iTicketLeave.execute(new String[]{"4"});
			iTicketStatus.execute();
			iTicket.execute(new String[]{"KA-01-P-333","White"});
			iTicket.execute(new String[]{"DL-12-AA-9999","White"});
		} catch (SlotIsNotEmpty e) {
			
		}
		
		try {
			iTicketFinderRegistrationNumbersForCarsWithColour.execute(new String[]{"White"});
		} catch (SlotIsNotEmpty e) {
			
		}
		
		try {
			iTicketFinderSlotNumbersForCarsWithColour.execute(new String[]{"White"});
		} catch (SlotIsNotEmpty e) {
			
		}
		
		try {
			iTicketFinderSlotNumberForRegistrationNumber.execute(new String[]{"KA-01-HH-3141"});
		} catch (SlotIsNotEmpty e) {
			
		}
		
		try {
			iTicketFinderSlotNumberForRegistrationNumber.execute(new String[]{"MH-04-AY-1111"});
		} catch (SlotIsNotEmpty e) {
			
		}
		
		assertEquals(BigDecimal.valueOf(6), multiStoreyParking.getMaxParkingSlot());
	}
	
	
}
