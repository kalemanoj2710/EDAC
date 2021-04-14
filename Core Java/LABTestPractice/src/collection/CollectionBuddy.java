package collection;

import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.core.Buddy;

public class CollectionBuddy {
	//Array Collection
	public static ArrayList<Buddy> populateData() {
	
		ArrayList<Buddy> arr=new ArrayList<Buddy>();
	//Evi@gmail nik 420420 2010-01-01 Delhi
	Buddy  b1=new Buddy("nikhil@gmail", "Nikhil", 9370, parse("1999-01-01"), "Nagpur");
    Buddy  b2=new Buddy("manthan@gmail", "Manthan", 80074, parse("2000-01-01"), "Nagpur");
    Buddy  b3=new Buddy("anmol@gmail", "Anmol", 904999, parse("1995-01-01"), "Nagpur");
    Buddy  b4=new Buddy("pratiksha@gmail", "Pratiksha", 696969, parse("1999-01-01"), "Nagpur");
	arr.add(b1);arr.add(b2);arr.add(b3);arr.add(b4);
    return arr;
	}
	//Map Collection
	public static HashMap<String,Buddy> populateMapData(ArrayList<Buddy> arr){
		HashMap<String,Buddy> map=new HashMap<>(); 
		for(Buddy b: arr)
		map.put(b.getEmail(), b);
		return map;
		
	}
}
