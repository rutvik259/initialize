package com.git.initialize.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="isbn")
	private String isbn;
	@Column(name="author")
	private String author;
	@Column(name="price")
	private int price;
	@ManyToOne
	@JoinColumn(name="library_id")
	@JsonBackReference
	private Library library;
	
	public Book() {
		super();
	}


	public Book(int id, String name, String isbn, String author, int price) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	


	public Library getLibrary() {
		return library;
	}


	public void setLibrary(Library library) {
		this.library = library;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", isbn=" + isbn + ", author=" + author + ", price=" + price + "]";
	}
	
	
}
