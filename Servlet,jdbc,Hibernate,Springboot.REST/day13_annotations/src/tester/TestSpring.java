package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml")) {
			System.out.println("SC strted.....");
			// invoke B.L : deposit / withdraw
			// 1 . get dependent bean : alrdy located --loaded--inst (def constr) --D.I --inited
			ATMImpl bean = ctx.getBean("my_atm", ATMImpl.class);// tester is requesting SC to get this rdymade bean
			bean.deposit(1234);
			ATMImpl bean2 = ctx.getBean("my_atm", ATMImpl.class);// tester is requesting SC to get this rdymade bean
			System.out.println(bean==bean2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
