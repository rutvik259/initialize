package com.git.initialize.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="library")
public class Library {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="library_id")
	private int libraryId;
	@Column(name="library_name")
	private String libraryName;
	@Column(name="library_address")
	private String libraryAddress;
	@Column(name="book_capacity")
	private int bookCapacity;
	
	@OneToMany(mappedBy="library")
	//@JsonManagedReference
	private List<Book> books;
	
	public Library() {
		super();
	}
	public Library(int libraryId, String libraryName, String libraryAddress, int bookCapacity) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.bookCapacity = bookCapacity;
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getLibraryAddress() {
		return libraryAddress;
	}
	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}
	public int getBookCapacity() {
		return bookCapacity;
	}
	public void setBookCapacity(int bookCapacity) {
		this.bookCapacity = bookCapacity;
	}
	
	
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		if(books==null) {
			books = new ArrayList<>();
		}
		books.add(book);
		
	}
	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", libraryName=" + libraryName + ", libraryAddress=" + libraryAddress
				+ ", bookCapacity=" + bookCapacity + "]";
	}
	
	
	
}
