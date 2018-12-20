package com.hexad;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.hexad.parkinglot.exception.CommandNotFound;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.ipark.ITicket;
import com.hexad.parkinglot.util.Commands;

public class HexadMain {

	public static void main(String[] args) throws SlotIsNotEmpty {
		System.out.println("PARKING LOT STARTED");
		
		//MultiStoreyParking multiStoreyParking=MultiStoreyParking.getInstance(maxParkingSlot);
		
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String[] paramIn = scanner.nextLine().split(" ");
			
			
			Commands cmds=new Commands();
			try {
				ITicket iTicket=cmds.getCommandsToExecute(paramIn[0]);
				
				String[] params=new String[paramIn.length-1];
				for(int i=0;i<params.length;i++)
					params[i]=paramIn[i+1];
				
				iTicket.execute(params);
				
				
			} catch (CommandNotFound e) {
				scanner.close();
			} catch (NoSuchElementException e) {
				
			}
		}
	}
}
