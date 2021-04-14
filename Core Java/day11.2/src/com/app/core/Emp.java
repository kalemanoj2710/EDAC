package com.app.core;

import java.util.Date;
import static dates.Test2.sdf;

public class Emp {
	private int id;
	private String name;
	private double salary;
	private Date joinDate;
	// + dept : enum
	private Department dept;

	public Emp(int id, String name, double salary, Date joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.joinDate = joinDate;
	}
	//ovrloaded constr
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + " joining on " + sdf.format(joinDate);
	}

	


	@Override
	public boolean equals(Object o) {
		System.out.println("in emp equals");
		if (o instanceof Emp) {
			Emp e=(Emp) o;
			return id == e.id && this.name.equals(e.name);
		}
		return false;
	}

}
