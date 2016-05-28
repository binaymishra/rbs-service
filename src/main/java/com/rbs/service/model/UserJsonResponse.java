package com.rbs.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rbs.domain.User;

@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
public class UserJsonResponse extends Response {

	private User user;

	public UserJsonResponse() {
		// Default constructor.
	}

	public UserJsonResponse(User user) {
		super();
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


}
