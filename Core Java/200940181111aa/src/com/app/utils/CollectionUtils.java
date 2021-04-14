package com.app.utils;

import static com.app.core.BookCategories.FICTION;
import static com.app.core.BookCategories.FINANCE;
import static com.app.core.BookCategories.MEDITATION;
import static com.app.core.BookCategories.SCIENCE;
import static com.app.core.BookCategories.YOGA;
import static java.time.LocalDate.parse;

import java.util.ArrayList;

import com.app.core.Book;
import com.app.users.Admin;
import com.app.users.Customer;
import com.app.users.User;

public class CollectionUtils {
	public static ArrayList<User> populateUsers() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new Admin("Akshay", "am3648277@gmail.com", "123456"));
		users.add(new Customer("Ramesh", "ramesh1996@gmail.com", "123456"));
		users.add(new Customer("Suresh", "suresh48@gmail.com", "123456"));
		users.add(new Customer("rameez", "rameez69@gmail.com", "123456"));
		users.add(new Customer("Aatmaram", "aatmaram23@gmail.com", "123456"));
		users.add(new Customer("Yogesh", "yogesh12@gmail.com", "123456"));
		return users;
	}

	public static ArrayList<Book> populateBooks() {
		ArrayList<Book> books = new ArrayList<>(25);

		books.add(new Book("The World of Ice and Fire", FICTION, 1399, parse("2011-08-18"), 5, 4.7));

		books.add(new Book("The Two Towers", FICTION, 1799, parse("1954-09-11"), 3, 4.7));

		books.add(new Book("A Brief History of Time", SCIENCE, 599, parse("1988-09-30"), 2, 4.3));

		books.add(new Book("Cosmos", SCIENCE, 369, parse("1980-10-14"), 4, 4.7));

		books.add(new Book("The Intelligent Investor", FINANCE, 391, parse("1959-12-15"), 2, 4.0));

		books.add(new Book("Rich Dad Poor Dad", FINANCE, 399, parse("1997-08-28"), 4, 4.1));

		books.add(new Book("Yoga Anatomy", YOGA, 399, parse("2008-02-28"), 4, 4.2));

		books.add(new Book("Light on Life", YOGA, 599, parse("2014-08-24"), 5, 4.0));

		books.add(new Book("Wherever You Go, There You Are", MEDITATION, 1099, parse("1994-08-08"), 5, 3.8));

		books.add(new Book("The Miracle of Mindfulness", MEDITATION, 799, parse("1975-01-28"), 5, 3.3));

		books.add(new Book("Pride and Prejudice", FICTION, 499, parse("1812-08-18"), 3, 4.2));

		books.add(new Book("Harry Potter and Goblet of Fire", FICTION, 799, parse("2000-07-08"), 5, 4.7));

		books.add(new Book("It", FICTION, 399, parse("1986-09-15"), 5, 4.8));

		books.add(new Book("My Lady Jane", FICTION, 499, parse("2016-06-07"), 3, 4.5));

		// authors

		int counter = 0;

		books.get(counter++).authorDetails("George R. R. Martin", "grrmartin@gmail.com");
		books.get(counter++).authorDetails("J. R. R. Tolkien", "jrrtolkien@gmail.com");
		books.get(counter).authorDetails("Stephen Hawking", "shawking@gmail.com");
		books.get(counter++).authorDetails("Carl Sagan", "carlsagan@gmail.com");
		books.get(counter++).authorDetails("Carl Sagan", "grrmartin@gmail.com");
		books.get(counter++).authorDetails("Benjamin Graham", "bgraham@gmail.com");
		books.get(counter).authorDetails("Robert Kiyosaki", "robertk@gmail.com");
		books.get(counter++).authorDetails("Sharon Lechter", "authorsl@gmail.com");
		books.get(counter++).authorDetails("Leslie Kaminoff", "authorleslie@gmail.com");
		books.get(counter++).authorDetails("B. K. S. Iyengar", "bks@gmail.com");
		books.get(counter++).authorDetails("Jon Kabat-Zinn", "jonzinn@gmail.com");
		books.get(counter++).authorDetails("Thich Nhat Hanh", "grrmartin@gmail.com");
		books.get(counter++).authorDetails("Jane Auston", "authorjane@gmail.com");
		books.get(counter++).authorDetails("J.k.Rowling", "harrypotter@gmail.com");
		books.get(counter++).authorDetails("Stephen King", "sking@gmail.com");
		books.get(counter).authorDetails("Jodi Meadows", "jodiMeadows@gmail.com");
		books.get(counter).authorDetails("Brodi Ashton", "brodiashton@gmail.com");
		books.get(counter).authorDetails("Cynthia Hand", "cynthiah@gmail.com");
		return books;
	}

}
