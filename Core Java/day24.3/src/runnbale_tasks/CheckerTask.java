package runnbale_tasks;

import static java.lang.Thread.currentThread;

import com.app.core.JointAccount;

public class CheckerTask implements Runnable{
	private JointAccount jointAccount;

	public CheckerTask(JointAccount jointAccount) {
		super();
		this.jointAccount = jointAccount;
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName()+" strted");
		try {
			//B.L  : update a/c balance continuoulsy in a loop : with a small delay
			boolean exit=false;
			while(!exit)
			{
				double balance = jointAccount.checkBalance();
				if(balance != 5000)
				{
					System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					//in case of err : terminate
					System.exit(-1);
				}
	
				Thread.sleep(345);
			}
			
		}catch (Exception e) {
			System.out.println(currentThread().getName()+" got error "+e);
		}
		System.out.println(currentThread().getName()+" over");
		
	}
	

}
