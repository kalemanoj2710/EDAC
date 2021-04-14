package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {
//add a method for user registration : open session
	String registerUser(User user);

	// add a method for user registration : get curnt session
	String registerUserWithGetCurntSession(User user);

	// add a method to fetch user details by user id
	User getUserDetails(int userId);

	// add a method to fetch all user details
	List<User> fetchAllUserDetails();

	// add a method for fetching selected user details
	List<User> fetchSelectedUserDetails(LocalDate start, LocalDate end, Role userRole);

	// add user validation method
	User authenticateUser(String email, String pwd);

	// add a method for fetching selected user names with some criteria
	List<String> fetchSelectedUserNames(LocalDate start, LocalDate end, Role userRole);
	//add a method for fetching selected user names,reg amt , reg date with some criteria
	List<User> fetchSelectedUserDetailsConstrExpr(LocalDate start, LocalDate end, Role userRole);
   //change password
	String changePassword(int userId,String newPwd);
	
}
