package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4,pst5;

	public CandidateDaoImpl() throws ClassNotFoundException,SQLException {
		cn = getDBConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		//pst3 : for top 2 candidates
		//pst4 : for party wise analysis
		//pst5 : registering new candidate
		pst5=cn.prepareStatement("insert into candidates (name,party,votes) values(?,?,?)");
		System.out.println("candidate dao created...");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();
		System.out.println("in candidate dao exec : list candidates query");
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (pst5 != null)
			pst5.close();
		if (cn != null)
			cn.close();
		System.out.println("candidate dao cleaned up...");
	}

	@Override
	public String incrementVotes(int candidateId) throws SQLException {
		//set IN param candidate id
		pst2.setInt(1, candidateId);
		int updateCount=pst2.executeUpdate();
		if(updateCount == 1)
			return "Votes incremented";
		return "Votes incr failed...";
	}

	@Override
	public String registerCandidate(Candidate c) throws SQLException {
		System.out.println("candidate dao : "+c);
		//set IN params
		pst5.setString(1, c.getName());
		pst5.setString(2, c.getParty());
		pst5.setInt(3, c.getVotes());
		System.out.println("inserting candidate details");
		int rowCount=pst5.executeUpdate();
		if(rowCount == 1)
			return "New Candidate registered!!!!!";
		return "Candidate registration failed!!!";
	}
	
	

}
