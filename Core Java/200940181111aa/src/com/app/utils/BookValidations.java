package com.app.utils;

import java.util.ArrayList;

import com.app.Exception.BookException;
import com.app.users.User;

public class BookValidations {

	public static void loginValidation(String email, String password, ArrayList<User> users) throws BookException {
		int count = 0;
		for (User u : users) {
			if ((u.getEmail().equalsIgnoreCase(email)) && (u.getPassword().equals(password))) {
				System.out.println("User Logined Successfully");
				count++;
				break;
			}
		}

		if (count == 0) {
			throw new BookException("Invalid user");
		}
	}
}