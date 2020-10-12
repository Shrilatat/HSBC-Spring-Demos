package com.trg.boot;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trg.boot.db.book.Book;
import com.trg.boot.db.dao.BookDao;


@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	DataSource dataSource;

	@Autowired
	BookDao bookDao;
	
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("DATASOURCE = " + dataSource);
		System.out.println("Display all books...");
		List<Book> list = bookDao.getBooks();
		list.forEach(x -> System.out.println(x));

		System.out.println("Display book with id 102");
		Book b = bookDao.getBookById(102);
		System.out.println(b);
	}
}
