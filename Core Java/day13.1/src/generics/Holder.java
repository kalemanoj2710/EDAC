package generics;

public class Holder<T> {
	//T : type 
	private T ref;//HAS-A 

	public Holder(T ref) {
		super();
		this.ref = ref;
	}

	public  T getRef() {
		return ref;
	}
	

}
