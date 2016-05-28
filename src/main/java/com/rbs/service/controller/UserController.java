package com.rbs.service.controller;

import com.rbs.exceptions.RbsException;
import com.rbs.service.model.UserJsonRequest;
import com.rbs.service.model.UserJsonResponse;

/**
 * @author Binay Mishra
 *
 */
public interface UserController {

	/**
	 * @param userRequest
	 * @return
	 * @throws RbsException
	 */
	public UserJsonResponse authenticate(UserJsonRequest userRequest) throws RbsException;

}
