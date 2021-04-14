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
	//add B.L method for user validation
	public String validateUser() throws SQLException
	{
		System.out.println("in JB : validate "+email+" "+password);
		//JB --> DAO's method for user  authentication
		userDetails=voterDao.authenticateVoter(email, password);
		if(userDetails == null)
			return "login";//name of JSP for login form
		//login success
		if(userDetails.getRole().equals("admin"))
			return "admin_status";
		//voter : role
		if(userDetails.isStatus()) //alrdy voted
			return "voter_status";
		//voter , not yet voted 
		return "candidate_list";
		
	}
	

}
