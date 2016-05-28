package com.rbs.service.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
public class ErrorResponse {

	private Integer code;

	private String message;

	private List<String> trace;

	private List<String> fullStackTrace;

	public ErrorResponse() {
		// Default Constructor.
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the trace
	 */
	public List<String> getTrace() {
		return trace;
	}

	/**
	 * @param trace the trace to set
	 */
	public void setTrace(List<String> trace) {
		this.trace = trace;
	}

	/**
	 * @return the fullStackTrace
	 */
	public List<String> getFullStackTrace() {
		return fullStackTrace;
	}

	/**
	 * @param fullStackTrace the fullStackTrace to set
	 */
	public void setFullStackTrace(List<String> fullStackTrace) {
		this.fullStackTrace = fullStackTrace;
	}
}
