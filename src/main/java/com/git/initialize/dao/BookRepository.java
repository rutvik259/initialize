package com.git.initialize.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.git.initialize.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
