package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Book;

import static utils.DBUtils.fetchDBConnection;

public class BookDaoImpl implements IBookDao {
	private Connection cn;
	private PreparedStatement pst1, pst2;

	public BookDaoImpl() throws ClassNotFoundException, SQLException {
		// get fixed cn from DBUtils
		cn = fetchDBConnection();
		pst1 = cn.prepareStatement("select distinct category from dac_books");
		pst2 = cn.prepareStatement("select * from dac_books where category=?");
		System.out.println("book dao created....");
	}

	@Override
	public List<String> getAllCategories() throws SQLException {
		List<String> categoryNames = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				categoryNames.add(rst.getString(1));
		}
		return categoryNames;
	}

	@Override
	public List<Book> getBooksByCategory(String categoryName) throws SQLException {
		List<Book> books = new ArrayList<>();
		// set IN param : category name
		pst2.setString(1, categoryName);
		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next())
				books.add(new Book(rst.getInt(1), rst.getString(2), 
						rst.getString(3), categoryName, rst.getDouble(5)));
		}
		return books;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		System.out.println("book dao closed");
	}

}
