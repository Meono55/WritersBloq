package com.revature.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;

@CrossOrigin(methods= {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("user")
public class UserController {

	/**
	 * Retrieve a user from the database based off the provided login credentials.
	 * 
	 * @param email    The email of the user account to log into.
	 * @param password The password of the user account to log into.
	 * @return The user account associated with the provided credentials. Null is
	 *         returned if no account could be found.
	 */
	@GetMapping(path = "/login", produces="application/json")
	public User login(@RequestParam String email, @RequestParam String password) {
		return null;
	}

	/**
	 * Adds a new user to the database.
	 * 
	 * @param newUser The information of the user to add to the database.
	 * @return The user that was added to the database. Null is returned if the user
	 *         was not added to the database.
	 */
	@PostMapping(path = "/sign-up")
	public User signUp(@RequestBody User newUser) {
		return null;
	}

	/**
	 * Retrieves a user from the database.
	 * 
	 * @param userId The id of the user to retrieve from the database.
	 * @return The user associated with the provided id number. Null is returned if
	 *         the user could not be found or not be retrieved in the database.
	 */
	@GetMapping(path = "/{idValue}", produces="application/json")
	public User getUser(@PathVariable(name="idValue") int userId) {
		return null;
	}
}
