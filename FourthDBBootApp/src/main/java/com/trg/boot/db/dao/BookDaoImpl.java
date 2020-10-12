package com.trg.boot.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trg.boot.db.book.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Book getBookById(int id) {
		String sql = "select * from book where bookid=?";
		Book book = (Book) jdbcTemplate.queryForObject(sql, 
				        new Object[] { id }, new BookMapper());
		return book;
	}

	public List<Book> getBooks() {
		String SQL = "select * from book";
		List<Book> books = jdbcTemplate.query(SQL, new BookMapper());
		return books;
	}

	public void addBook(Book book) {
		//jdbcTemplate.update()

	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub

	}

	public List<Book> getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
