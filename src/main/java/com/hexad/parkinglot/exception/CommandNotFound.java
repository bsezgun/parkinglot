package com.hexad.parkinglot.exception;

public class CommandNotFound  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandNotFound() {
		System.out.println("Sorry, command not found. System will close");
	}


}
