package com.app.tester;

import static com.app.utils.BookValidations.loginValidation;
import static com.app.utils.CollectionUtils.populateBooks;
import static com.app.utils.CollectionUtils.populateUsers;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.Exception.BookException;
import com.app.core.Book;
import com.app.users.User;

public class TestShop {
	static void customerMenu() throws InterruptedException {
		System.out.println("*******Menu*******");
		Thread.sleep(100);
		System.out.println(" 1. Add a book to Cart");
		Thread.sleep(100);
		System.out.println(" 2. Remove a book from Cart");
		Thread.sleep(100);
		System.out.println(" 3. Show all books in Cart");
		Thread.sleep(100);
		System.out.println(" 4. CheckOut");
	}

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in);) {
			ArrayList<Book> books = populateBooks();
			ArrayList<User> users = populateUsers();
			

			boolean flag = true;
			try {
				System.out.println("\nPress Enter to start");

				while (flag) {

					scan.nextLine();
					System.out.println("*******Welcome to our Virtual BookStore*******");
					Thread.sleep(100);
					System.out.println(" 1. Admin Login");
					Thread.sleep(100);
					System.out.println(" 2. Customer Login");
					Thread.sleep(100);
					System.out.println(" 3. Exit");
					System.out.println("Enter you Choice");

					try {
						int choice = scan.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Email: ");
							String email = scan.next();
							System.out.println("Password");
							String password = scan.next();
							loginValidation(email, password, users);
							System.out.println("Admin functionalities are not added yet....\n Try Cutomer login");
							break;
						case 2:
							System.out.println("Email: ");
							email = scan.next();
							System.out.println("Password");
							password = scan.next();
							loginValidation(email, password, users);
							ArrayList<Book> cart = new ArrayList<>();
							double totalBill = 0;
							try {
								while (flag) {
									System.out.println("*******Menu*******");
									
									System.out.println(" 1. Add a book to Cart");
									
									System.out.println(" 2. Remove a book from Cart");
									
									System.out.println(" 3. Show all books in Cart");
									
									System.out.println(" 4. CheckOut");
									System.out.println("Enter you Choice");
									choice = scan.nextInt();
									try {
										switch (choice) {
										case 1:
											sort(books);
											int serNo = 1;

											for (Book b : books) {
												System.out.println("BookNo:" + serNo+ b);
												serNo++;
											}
											System.out
													.println("Enter the Book No and quantity of books to add to Cart");
											System.out.println("BookNO : ");
											int bookNo = scan.nextInt();
											System.out.println("Quanity : ");
											int quantity = scan.nextInt();
											if (books.get(bookNo - 1).getQuantity() >= quantity) {
												cart.add(books.get(bookNo - 1));
												books.get(bookNo - 1)
														.setQuantity(books.get(bookNo - 1).getQuantity() - quantity);
												totalBill += (books.get(bookNo - 1).getPrice() * quantity);
											} else
												throw new BookException(
														"We dont have enough quantity of books.");
											break;

										case 2:
											serNo = 1;
											System.out.println("CART\n");
											for (Book c : cart) {
												System.out.println("BookNo: " + serNo + c);
												serNo++;
											}
											System.out
													.println("Enter the Book no of book you want to remove from cart");
											bookNo = scan.nextInt();
											if (bookNo <= cart.size()) {
												totalBill -= (cart.get(bookNo - 1).getPrice()
														* (cart.get(bookNo - 1).getQuantity()
																- books.get(bookNo - 1).getQuantity()));
												books.get(bookNo - 1).setQuantity(cart.get(bookNo - 1).getQuantity());
												cart.remove(bookNo - 1);

											} else
												throw new BookException("Enter a valid BookNo...");
											break;

										case 3:
											serNo = 1;
											System.out.println("CART\n");
								
											for (Book c : cart) {
												System.out.println("BookNo: " + serNo + "     Category : "+c.getCategory()+" "+ c+"\n");
												serNo++;
											}
											
											break;
										case 4:
											System.out.println("Your Bill\n");
											
												System.out.println("Your Cart contains:-\n");
											for (Book c : cart) {
												System.out.println("Book name : " + c.getTitle() + " Price : " + c.getPrice()+"\n");
											}
											System.out.println(
													"Total Bill Amount is " + (totalBill + (totalBill * 0.18)));
											System.exit(0);

										default:

											System.out.println("Enter the Correct choice");
											break;
										}
									} catch (Exception e) {
											System.out.println("Error Details:- " + e.getMessage());
									}
								}
							} catch (Exception e) {
									System.out.println("Error Details:- " + e.getMessage());
							}
							break;

						case 3:
							flag = false;
							
							break;

						default:
							System.out.println("Enter the Correct choice");
							break;
						}
					} catch (Exception e) {
							System.out.println(e.getMessage());
					}
				}
			} catch (Exception e) {
				System.out.println("Error Details:- " + e.getMessage());
			}

		} catch (Exception e) {
			System.out.println("Error Details:- " + e.getMessage());
		}

	}

}
