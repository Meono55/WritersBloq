package com.revature.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.CredentialsDTO;
import com.revature.models.User;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
  
  // Get authService from Spring
  AuthService auth;
  @Autowired
	public AuthController(AuthService auth) {
    this.auth = auth;
  }

  
  /**
	 * Retrieve a user from the database based off the provided login credentials.
	 * 
	 * @param loginCredentials The data transfer object containing the login
	 *                         information.
	 * @return The user account associated with the provided credentials. Null is
	 *         returned if no account could be found.
	 */
	@PostMapping(produces="application/json")
	public User login(HttpServletResponse res, @RequestBody CredentialsDTO loginCredentials) {
	  
	  return null;
	}
	
	/**
	 * 
	 * @param idVal
	 * @return
	 */
	@GetMapping(path="/{userId}")
	public User getLoggedInUser(@PathVariable(name="userId") int idVal) {
		return null;
	}
}
