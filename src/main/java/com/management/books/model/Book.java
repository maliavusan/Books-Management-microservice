package com.management.books.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "book")
public class Book {
	
	public enum BookType {
		HARDCOVER, SOFTCOVER, EBOOK
	}
	
	private long id;
	private String name;
	private String isbnNumber;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date publishDate;
	private Double price;
	private BookType bookType;
	
	public Book(){}

	public Book(long id, String name, String isbnNumber, Date publishDate, Double price, BookType bookType) {
		super();
		this.id = id;
		this.name = name;
		this.isbnNumber = isbnNumber;
		this.publishDate = publishDate;
		this.price = price;
		this.bookType = bookType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isbn_number", nullable = false, unique = true)
	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	@Column(name = "publish_date", nullable = false)
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name = "price", nullable = false)
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "book_type", nullable = false)
	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	
}
