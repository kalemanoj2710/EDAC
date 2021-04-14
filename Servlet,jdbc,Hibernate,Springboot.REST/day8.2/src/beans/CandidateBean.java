package beans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.CandidateDaoImpl;
import pojos.Candidate;

//public n packaged class
public class CandidateBean {
//Java bean can store clnt's info => registration details
	 private String name,party,dob;
	// Java Bean manages candidat dao : add a ref.
	private CandidateDaoImpl candidateDao;
	//add a property to store candidate reg status
	private String message;

	// arg-less defualt constructor
	public CandidateBean() throws ClassNotFoundException, SQLException {
		System.out.println("in candidate bean constr");
		candidateDao = new CandidateDaoImpl();
		System.out.println("candidate bean created...");
	}
	//getters n setters for the JB properties

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public CandidateDaoImpl getCandidateDao() {
		return candidateDao;
	}

	public void setCandidateDao(CandidateDaoImpl candidateDao) {
		this.candidateDao = candidateDao;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//add a business logic +validation method
	public String validateNRegisterUser() throws SQLException
	{
		System.out.println("Candidate bean reg customer : "+name+" "+party+" "+dob);
		//parse dob from string -->LocalDate
		LocalDate dateOfBirth=LocalDate.parse(dob);
		int age=Period.between(dateOfBirth, LocalDate.now()).getYears();
		if(age > 35)
		{
			//candidate validated --> invoke Dao's method . insert rec.
			message=candidateDao.registerCandidate(new Candidate(name,party));
			return "admin_status";
			
		}
		//age validation failed
		message="Candidate's age invalid !!!!!";
		return "candidate_register";
	}
	
}
