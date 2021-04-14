package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import dependency.Transport;
//singleton n eager , dependency : Http Transport layer
@Component("my_atm")
@Scope(value = "prototype")
public class ATMImpl implements ATM {
	//field level D.I 
	@Autowired//(required = false) //autowire=byType(w/o explicit setter)
	@Qualifier("httpTransport123")//byName
	//Meaning => SC will try to search for the bean id = "httpTransport"
	private Transport myTransport;

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	

	// init style method
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + myTransport);
	}

	// destroy style method
	@PreDestroy
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);
	}

}
