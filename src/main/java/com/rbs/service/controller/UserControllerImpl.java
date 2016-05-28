package com.rbs.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbs.domain.User;
import com.rbs.exceptions.RbsException;
import com.rbs.manager.UserManager;
import com.rbs.service.model.UserJsonRequest;
import com.rbs.service.model.UserJsonResponse;

/**
 * @author Binay Mishra
 *
 */
@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

	private UserManager userManager;

	@Autowired
	public UserControllerImpl(@Qualifier("userManager") UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public @ResponseBody UserJsonResponse authenticate(@RequestBody  UserJsonRequest userRequest) throws RbsException {
		User user = userRequest.getUser();
	  user = userManager.authenticate(user.getUsername(), user.getPassword());
		return new UserJsonResponse(user);
	}

}
