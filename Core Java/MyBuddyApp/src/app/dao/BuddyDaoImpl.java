package app.dao;

import static app.utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import app.pojos.Buddy;

public class BuddyDaoImpl implements IBuddyDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private Statement st4;
	private PreparedStatement pst5;
	
	
	public BuddyDaoImpl() throws Exception{
		cn=fetchDBConnection();
		pst1 = cn.prepareStatement("select * from buddies where Email_id=?");
		pst2 = cn.prepareStatement("insert into buddies values (?,?,?,?,?)");
		pst3 = cn.prepareStatement("delete from buddies where Email_id=?");
		st4=cn.createStatement();
		pst5 = cn.prepareStatement("select * from buddies where dob=?");
		
		System.out.println("Buddy Dao Created...");
	}
	
	@Override
	public Buddy searchBuddyByEmailId(String emailId) throws SQLException {
		Buddy b= new Buddy();
		pst1.setString(1,emailId);
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next()) {
				b=new Buddy(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDate(4), rst.getString(5));
				return b;
			}
		}
		return null;
	}

	@Override
	public String addNewBuddy(Buddy b) throws SQLException {
		pst2.setString(1, b.getEmailId());
		pst2.setString(2, b.getName());
		pst2.setLong(3, b.getPhoneNumber());
		pst2.setDate(4, b.getDob());
		pst2.setString(5, b.getCity());

		int insertResult = pst2.executeUpdate();
		if(insertResult == 1)
			return "Successfully added Buddy";
		else 
			return "Failed to add new Buddy try again...";
	}

	@Override
	public String deleteBuddyByEmailId(String emailId) throws SQLException {
		pst3.setString(1, emailId);
		int result = pst3.executeUpdate();
		if(result == 1) {
			return "Buddy Successfully Deleted ....";
		}
		return "Invalid Email Idtry agin...";
	}

	@Override
	public List<Buddy> displayAllBuddies() throws SQLException {
		List<Buddy> buddyList = new ArrayList<>();
		
		String sql="select * from buddies";
		ResultSet rst = st4.executeQuery(sql);
		while(rst.next()) {
			buddyList.add(new Buddy(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDate(4), rst.getString(5)));
		}
		return buddyList;
	}

	@Override
	public List<Buddy> displayBuddiesByDob(Date d) throws SQLException {
		List<Buddy> buddyList = new ArrayList<>();
		pst5.setDate(1, d);
		ResultSet rst = pst5.executeQuery();
		while(rst.next()) {
			buddyList.add(new Buddy(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDate(4), rst.getString(5)));
		}
		return buddyList;
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		if(pst3 != null)
			pst3.close();
		if(st4 != null)
			st4.close();
		if(pst5 != null)
			pst5.close();
		if(cn != null)
			cn.close();
		System.out.println("Buddy dao cleaned up...");			
	}
}
