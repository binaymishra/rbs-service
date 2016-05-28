package com.rbs.service.model;

import com.rbs.domain.User;

/**
 * @author Binay Mishra
 *
 */
public class UserJsonRequest extends Request {

	private User user;

	public UserJsonRequest() {
	// Default constructor.
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
