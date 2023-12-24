package com.qsp.SpringDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.SpringDemo.dto.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer>{

	Author findByAuthorEmail(String email);

}
