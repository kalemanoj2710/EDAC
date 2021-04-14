package p3;

public class Tester {

	public static void main(String[] args) throws InterruptedException{
		//create a new thread imple Runnable , using lambda expression : name of thread "test_me"
		//exec logic : sleep : 5 sec
		Thread t1=new Thread(() -> {
				try {
					Thread.sleep(5000);//t1 : blocked on sleep
					System.out.println("sleep over.....");
				} catch (InterruptedException e) {
					System.out.println("err in "+Thread.currentThread().getName()+" "+e);
				}//t1 : dead
				
			
		},"test_me");//1 : main : runnable
		t1.start();//2 : runnable
	//	t1.start();//runnable  thrds can't be re started : IllegalThrdStateExc
		System.out.println("main before sleep");
		Thread.sleep(1000);//main : B.on sleep
		System.out.println("main after sleep, interrupting t1");
		//main ---> interrupt signal to t1
		t1.interrupt();
		t1.join();//main : Blocked on join
	//	t1.start();//dead thrds can't be re started : IllegalThrdStateExc
		System.out.println("main over....");
		
		

	}

}
