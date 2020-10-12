package com.trg.boot.db.book;

public class Book {
	int id;
	String bname, author;
	double price;

	//appropriate cons, getter, setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String bname, String author, double price) {
		super();
		this.id = id;
		this.bname = bname;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bname=" + bname + ", author=" + author + ", price=" + price + "]";
	}

}
