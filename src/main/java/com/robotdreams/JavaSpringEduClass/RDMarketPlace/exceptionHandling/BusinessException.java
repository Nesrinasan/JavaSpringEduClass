package com.robotdreams.JavaSpringEduClass.RDMarketPlace.exceptionHandling;

public class BusinessException extends RuntimeException{

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}


}
