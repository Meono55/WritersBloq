package com.revature.utils;

import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.User;

public class UserValidation {

	/**
	 * This method makes sure the user fields are all valid
	 * @param user to be checked 
	 */
	public static void validateUser(User user) {
		if (!validateName(user.getFirstName().trim())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "First name should contain only letters");
		}
		if (!validateName(user.getLastName().trim())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Last name should contain only letters");
		}
		if (!validateEmail(user.getEmail().trim())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Please enter a valid email");
		}
		if (user.getPassword()==null || user.getPassword().trim().length() < 6) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Please enter a valid password");
		}
	}
	
	/**
	 * This method makes sure the email is valid or not
	 * @param email to be checked
	 * @return a boolean showing whether it's a valid email or not
	 */
	public static boolean validateEmail(String email) {
		if (email == null) return false;
		return EmailValidator.getInstance().isValid(email);
	}
	
	/**
	 * This method makes sure a name contains only letters
	 * @param name to be checked
	 * @return a boolean showing whether it's a valid name or not
	 */
	public static boolean validateName(String name) {
		if (name == null || name.length() < 2) return false;
		return Pattern.compile("a-zA-Z]+").matcher(name).matches();
	}
}
