package com.hexad.parkinglot.ipark;

import com.hexad.parkinglot.entity.ResultPark;
import com.hexad.parkinglot.exception.SlotIsNotEmpty;

public interface ITicket {

	public ResultPark execute(String... args) throws SlotIsNotEmpty;
	
	
}
