package tester;

import com.app.core.JointAccount;

import runnbale_tasks.CheckerTask;
import runnbale_tasks.UpdaterTask;

public class TestSharedResources {

	public static void main(String[] args) throws InterruptedException{
		//create SINGLE instnace of a join a/c
		JointAccount acct=new JointAccount(5000);
		//create the tasks , by sharing SAME resource , attach them to thrds n start
		Thread t1=new Thread(new UpdaterTask(acct), "c1");
		Thread t2=new Thread(new CheckerTask(acct),"c2");
		t1.start();
		t2.start();
		System.out.println("main waiting for child threads to complete exec");
		t1.join();
		t2.join();
		System.out.println("main over....");	

	}

}
