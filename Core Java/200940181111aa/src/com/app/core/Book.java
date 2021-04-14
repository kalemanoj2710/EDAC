package com.app.core;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book implements Comparable<Book> {
	private String title;
	private BookCategories category;
	private double price;
	private LocalDate publishedDate;
	private int quantity;
	private double rating;
	private ArrayList<Author> authors;

	public Book(String title, BookCategories category, double price, LocalDate publishedDate, int quantity,double rating) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.publishedDate = publishedDate;
		this.quantity = quantity;
		this.rating = rating;
		this.authors= new ArrayList<>();
	}

public void authorDetails(String name,String email) {
	this.authors.add(new Author(name, email));
	
}

public LocalDate getPublishedDate() {
	return publishedDate;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public BookCategories getCategory() {
	return category;
}

public double getPrice() {
	return price;
}

public String getTitle() {
	return title;
}

public void setRating(double rating) {
	this.rating = rating;
}

public double getRating() {
	return rating;
}

@Override
public int compareTo(Book other) {
	int index=this.category.compareTo(other.category);
	if(index==0)
		return this.title.compareTo(other.title);
	return index;
}
@Override
public String toString() {
	return "\n Book Title:- \n\t"+this.title+"\n Author:- \n\t"+authors+"\n"
			+ " Book Price:-\n\t"+this.price;
}

	// Nested inner Author Class
	public class Author {
		private String name;
		private String email;

		public Author(String name, String email) {
			this.email=email;
			this.name=name;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		@Override
		public String toString() {
			return "Author name=" + name + ", email=" + email+"\n\t";
		}
		
		
	}
	
}
