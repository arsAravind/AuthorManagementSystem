package com.qsp.SpringDemo.ExceptionHandling;

public class IdAlreadyPresentException extends Exception{
	
	@Override
	public String getMessage() {
		return "Id already present";
	}

}
