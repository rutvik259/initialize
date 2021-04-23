package com.git.initialize.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.initialize.dao.LibraryRepository;
import com.git.initialize.entity.Book;
import com.git.initialize.entity.Library;

@RestController
@RequestMapping("/api")
public class MainRESTController {
	private LibraryRepository libraryRepo;

	@Autowired
	public MainRESTController(LibraryRepository libraryRepo) {
		super();
		this.libraryRepo = libraryRepo;
	}
	@PostMapping("/libraries")
	public Library saveLibrary(@RequestBody Library library) {
		return libraryRepo.save(library);
	}

	@GetMapping("/libraries/{libraryId}")
	public Optional<Library> getAllBooksInLibrary(@PathVariable int libraryId) {
		return libraryRepo.findById(libraryId);
	}
	
}
