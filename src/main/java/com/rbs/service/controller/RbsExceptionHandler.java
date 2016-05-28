package com.rbs.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbs.exceptions.RbsException;
import com.rbs.service.model.ErrorResponse;

@ControllerAdvice
public class RbsExceptionHandler {

	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = NotImplementedException.class)
	public @ResponseBody ErrorResponse handleNotImplementedException(NotImplementedException exception){
		ErrorResponse response = new ErrorResponse();
		response.setCode(1000);
		response.setMessage(exception.getMessage());
		response.setFullStackTrace(getStackTrace(exception, false));
		return response;

	}

	/**
	 * @param rbsException
	 * @return
	 */
	@ExceptionHandler(value = RbsException.class)
	public @ResponseBody ErrorResponse handleRbsException(RbsException rbsException){
		ErrorResponse response = new ErrorResponse();
		response.setCode(1001);
		response.setMessage(rbsException.getMessage());
		response.setTrace(getStackTrace(rbsException, false));
		return response;

	}

	/**
	 * @param throwable
	 * @param fullTrace
	 * @return List<String> stackTraceElement.
	 */
	public static  List<String> getStackTrace(Throwable throwable, boolean fullTrace) {
		List<String> stackTrace = new ArrayList<>();
		for (StackTraceElement element : throwable.getStackTrace())
			if(fullTrace)
				stackTrace.add(element.toString());
			else if(element.getClassName().contains("com.rbs"))
				stackTrace.add(element.toString());

		return stackTrace;
	}
}


