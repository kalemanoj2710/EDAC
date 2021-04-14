package dao;

import java.util.List;

import pojos.User;

public interface IUserDao {
//add a method for user registration : open session
	String registerUser(User user);
	//add a method for user registration : get curnt session
		String registerUserWithGetCurntSession(User user);
		//add a method to fetch user details by user id
		User getUserDetails(int userId);
		//add a method to fetch all user details
		List<User> fetchAllUserDetails();
}
