package com.app.foods;

public enum Menu {
	IDLI(50), DOSA(70), SANDWICH(100), SOUP(120), RICE(100);
	//state
	private int price;
	//constr
	Menu(int price)
	{
		this.price=price;
	}
	public  int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//toString
	@Override
	public String toString()
	{
		return name()+"@"+price;
	}
	

}
