package com.git.initialize.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.initialize.dao.BookRepository;
import com.git.initialize.dao.LibraryRepository;
import com.git.initialize.entity.Book;

@RestController
@RequestMapping("/api")
public class BookController {
	
	private BookRepository bookRepo;
	private LibraryRepository libraryRepo;

	@Autowired
	public BookController(BookRepository bookRepo, LibraryRepository libraryRepo) {
		super();
		this.bookRepo = bookRepo;
		this.libraryRepo = libraryRepo;
	}
	
	@PostMapping("/libraries/{libraryId}/books")
	public Book addBookToLibrary(@PathVariable int libraryId ,@RequestBody Book book) {
		return libraryRepo.findById(libraryId).map(library -> {
			book.setLibrary(library);
			return bookRepo.save(book);
		}).orElseThrow(() -> new ResourceNotFoundException("LibraryId " + libraryId + " not found"));
	}
	
}
