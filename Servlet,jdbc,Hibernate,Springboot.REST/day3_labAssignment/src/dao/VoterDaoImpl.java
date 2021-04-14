package dao;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Voter;

public class VoterDaoImpl implements IVotersDao {

	// state
	private Connection cn;
	private PreparedStatement pst1;

	public VoterDaoImpl() throws ClassNotFoundException, SQLException {
		String sql1 = "select * from voters where email=? and password=?";
		// get db cn
		cn = fetchDBConnection();
		// pst
		pst1 = cn.prepareStatement(sql1);
		System.out.println("Coustomer dao created...");
	}
	@Override
	public Voter validateUser(String email, String pwd) throws Exception {
		// set IN params
				pst1.setString(1, email);
				pst1.setString(2, pwd);
				
				try (ResultSet rst = pst1.executeQuery()) {
					if (rst.next())
						return  new Voter(rst.getInt(1),rst.getString(2),email,pwd,rst.getBoolean(5),rst.getNString(6) );

				}
				return null;
		
	}

	public void cleanup() throws SQLException {
		if (pst1 == null) {
			pst1.close();
		}
		if (cn == null)
			cn.close();
	}

}
