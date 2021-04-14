package dao;

import pojo.Voter;

public interface IVotersDao {
	Voter validateUser(String email,String pwd) throws Exception;
}
