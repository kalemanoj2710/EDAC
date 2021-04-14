package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;

import runnable_tasks.DobSorterTask;
import runnable_tasks.GPASorterTask;

public class TestCollectionIOThreads {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in))
		{
			Map<String, Student> map = populateMap(populateList());
			System.out.println("Enter 2 file names : for gpa based n dob based sorting");
			//create runnable task instance , attach it to thread n strt thrds
			Thread t1=new Thread(new GPASorterTask(map,sc.next()), "gpa");
			Thread t2=new Thread(new DobSorterTask(map,sc.next()), "dob");
			t1.start();
			t2.start();
			System.out.println("waiting for child thrds to complete exec");
			t1.join();
			t2.join();
			System.out.println("main over.....");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
