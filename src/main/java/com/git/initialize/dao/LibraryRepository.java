package com.git.initialize.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.git.initialize.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
