package com.hexad.parkinglot.ipark;

import com.hexad.parkinglot.exception.SlotIsNotEmpty;

public interface ITicket {

	public void execute(String... args) throws SlotIsNotEmpty;
	
	
}
