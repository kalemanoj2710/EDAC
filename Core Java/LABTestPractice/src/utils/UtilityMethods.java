package utils;

import java.time.LocalDate;
import static java.time.LocalDate.*;
import java.util.HashMap;

import com.app.core.Buddy;

import coustomExp.ValidateException;

public class UtilityMethods {
	public static void checkDups(HashMap<String,Buddy> bmap,String email)
			throws  ValidateException
	{
	if(bmap.containsKey(email))
		throw new ValidateException("The same email already exists ") ;
	}
	public static void checkDob(LocalDate date) throws  ValidateException
	{
//		if(date.isAfter(parse("2020-01-01")))
//			throw ValidateException()
		if(date.isAfter(LocalDate.now()))
			throw new ValidateException("Invalid Date of Birth");
	} 
	public static void checkPhoneNo(HashMap<String,Buddy> bmap,int no)throws  ValidateException
	{
		for(Buddy b : bmap.values())
		{
			if(b.getPhone()==no)
				throw new   ValidateException("Phone number already Exists");
		}
	}
}
