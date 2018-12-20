package com.hexad.parkinglot.exception;

public class SlotIsNotEmpty extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SlotIsNotEmpty() {
		System.out.println("Sorry, parking lot is full");
	}

	
}
