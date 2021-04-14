package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.app.core.Student;

public interface IOUtils {
//store sorted student details in a text file : buiffering
	//i/p s : list , file
	 static void writeData(List<Student> list,String fileName) throws IOException
	 {
		 //chain of strms 
		 //Java app ---->PW ---->FW --->Text file
		 try(PrintWriter pw=new PrintWriter(new FileWriter(fileName)))
		 {
			 //write data
		//	 list.forEach(s->pw.println(s));
			 list.forEach(pw::println);
		 }
	 }
}
