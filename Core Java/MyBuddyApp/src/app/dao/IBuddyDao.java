package app.dao;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import app.pojos.Buddy;

public interface IBuddyDao {
	
	Buddy searchBuddyByEmailId(String emailId) throws SQLException;
	
	String addNewBuddy(Buddy b) throws SQLException;
	
	String deleteBuddyByEmailId(String emailId) throws SQLException;
	
	List<Buddy> displayAllBuddies() throws SQLException;
	
	List<Buddy> displayBuddiesByDob(Date d) throws SQLException;
}
