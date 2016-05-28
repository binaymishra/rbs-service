package com.rbs.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbs.exceptions.RbsException;
import com.rbs.service.model.ErrorResponse;

@ControllerAdvice
public class RbsExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(RbsExceptionHandler.class);

	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = NotImplementedException.class)
	public @ResponseBody ErrorResponse handleNotImplementedException(NotImplementedException exception){
		ErrorResponse response = new ErrorResponse();
		response.setCode(1000);
		response.setMessage(exception.getMessage());
		if(LOGGER.isDebugEnabled()){
			response.setTrace(getStackTrace(exception, false));
			response.setFullStackTrace(getStackTrace(exception, true));
			LOGGER.debug(getStackTrace(exception, true));
		}if(LOGGER.isInfoEnabled()){
			response.setTrace(getStackTrace(exception, false));
			LOGGER.info(getStackTrace(exception, false));
		}
		return response;

	}

	/**
	 * @param rbsException
	 * @return
	 */
	@ExceptionHandler(value = RbsException.class)
	public @ResponseBody ErrorResponse handleRbsException(RbsException exception){
		ErrorResponse response = new ErrorResponse();
		response.setCode(1001);
		response.setMessage(exception.getMessage());
		if(LOGGER.isDebugEnabled()){
			response.setTrace(getStackTrace(exception, false));
			response.setFullStackTrace(getStackTrace(exception, true));
			LOGGER.debug(getStackTrace(exception, true));
		}if(LOGGER.isInfoEnabled()){
			response.setTrace(getStackTrace(exception, false));
			LOGGER.info(getStackTrace(exception, false));
		}
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


