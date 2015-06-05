package org.shahbaz.springaop.application.exception.message;

import org.shahbaz.springaop.application.exception.exceptiontypes.ExceptionType;

public class ApplicationRuntimeException extends RuntimeException {

	public ApplicationRuntimeException(ExceptionType excpetion) {
		super(excpetion.name());
	}
}
