package com.trg.boot.db.dao;

import java.util.List;

import com.trg.boot.db.book.Book;

public interface BookDao {
  public Book getBookById(int id);
  public List<Book> getBooks();
  public void addBook(Book book);
  public void deleteBook(int id);
  public List<Book> getBooksByAuthor(String author);
}
