package beans;

import java.sql.SQLException;

import dao.VoterDaoImpl;
import pojos.Voter;

public class VoterBean {
	private String email, password;// clnt's conversational state(req params coming from clnt)
//manages Voter Dao
	private VoterDaoImpl voterDao;
//to store authenticated user details : Voter POJO
	private Voter userDetails;
	//add a message property
	private String message;
	//add a def arg-less constr
	public VoterBean() throws ClassNotFoundException,SQLException{
		// create voter dao instance
		voterDao=new VoterDaoImpl();
		System.out.println("voter bean created");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public VoterDaoImpl getVoterDao() {
		return voterDao;
	}
	public void setVoterDao(VoterDaoImpl voterDao) {
		this.voterDao = voterDao;
	}
	public Voter getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Voter userDetails) {
		this.userDetails = userDetails;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//add B.L method for user validation
	public String validateUser() throws SQLException
	{
		System.out.println("in JB : validate "+email+" "+password);
		//JB --> DAO's method for user  authentication
		userDetails=voterDao.authenticateVoter(email, password);
		if(userDetails == null) {
			message="Invalid Login , Please Retry....";
			return "login";//name of JSP for login form
		}
		//login success
		if(userDetails.getRole().equals("admin")) {
			message="Admin Login successful";
			return "admin_status";
		}
		message="Voter Login successful";
		//voter : role
		if(userDetails.isStatus()) //alrdy voted
			return "voter_status";
		//voter , not yet voted 
		return "candidate_list";
		
	}
	

}
