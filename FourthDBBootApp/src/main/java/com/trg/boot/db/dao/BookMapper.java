package com.trg.boot.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.trg.boot.db.book.Book;

public class BookMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int index) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt(1));
		book.setBname(rs.getString(2));
		book.setAuthor(rs.getString(3));
		book.setPrice(rs.getDouble(4));
		return book;
	}

	

}
