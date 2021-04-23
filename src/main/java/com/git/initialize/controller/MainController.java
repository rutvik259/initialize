package com.git.initialize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.git.initialize.dao.BookRepository;
import com.git.initialize.dao.LibraryRepository;
import com.git.initialize.entity.Library;

@Controller
@RequestMapping("/client/libraries")
public class MainController {
	
	private BookRepository bookRepo;
	private LibraryRepository libraryRepo;

	@Autowired
	public MainController(BookRepository bookRepo, LibraryRepository libraryRepo) {
		super();
		this.bookRepo = bookRepo;
		this.libraryRepo = libraryRepo;
	}	
	
	
	@GetMapping("/")
	public String getIndex(Model theModel) {
		List<Library> libraries = libraryRepo.findAll();
		theModel.addAttribute("libraries", libraries);
		return "index";
	}
	
	@GetMapping("/{libraryId}/books")
	public String addBookToLibrary() {
		return "add-book";
	}

	@GetMapping("/git")
	public String returnGitTemp() {
		return "This is a git temp request";
	}

}
