package com.hexad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

import com.hexad.parkinglot.exception.CommandNotFound;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;
import com.hexad.parkinglot.ipark.ITicket;
import com.hexad.parkinglot.util.Commands;

public class HexadMain {

	public static void main(String[] args) throws SlotIsNotEmpty {
		System.out.println("PARKING LOT STARTED");
		Commands cmds=new Commands();
		
		if(args.length>0) {
			try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {

				stream.forEach(cmd->{
					String[] paramIn =cmd.split(" ");
					try {
						ITicket iTicket=cmds.getCommandsToExecute(paramIn[0]);
						
						String[] params=new String[paramIn.length-1];
						for(int i=0;i<params.length;i++)
							params[i]=paramIn[i+1];
						
						iTicket.execute(params);
					} catch (CommandNotFound e) {
					} catch (SlotIsNotEmpty e) {
					}
				});

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String[] paramIn = scanner.nextLine().split(" ");
			
			
			
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
