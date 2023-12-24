package com.qsp.SpringDemo.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.qsp.SpringDemo.ExceptionHandling.IdAlreadyPresentException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.Repo.AuthorRepo;
import com.qsp.SpringDemo.ResponseStructure.ResponseStructure;
import com.qsp.SpringDemo.dto.Author;

@Repository
public class AuthorDao {
	@Autowired
	AuthorRepo repo;

	public Author save(Author author) throws IdAlreadyPresentException {

		Author save = repo.save(author);
		return save;
	}
	public List<Author> fetchAll() {
		List<Author> findAll = repo.findAll();
	
		return findAll;
	}

	public Author fetchOne(int id) throws IdNotFoundException {
		Author author = repo.findById(id).orElseThrow(() -> new IdNotFoundException());
		return author;
	}

	public Author delete(int id) throws IdNotFoundException {
		Author a = repo.findById(id).orElseThrow(() -> new IdNotFoundException());
		repo.delete(a);
		return a;
	}

	public Author update(Author author, int id) throws IdNotFoundException {
		Author s = repo.findById(id).orElseThrow(() -> new IdNotFoundException());
		s.setAuthorId(author.getAuthorId());
		s.setAuthorName(author.getAuthorName());
		s.setAuthorEmail(author.getAuthorEmail());
		s.setAuthorPassword(author.getAuthorPassword());
		s.setAuthorPhNo(author.getAuthorPhNo());
		s.setAutorPlace(author.getAutorPlace());
		repo.save(s);
		return s;
	}

	public String loginByEmail(String email, String password) {
		Author a = repo.findByAuthorEmail(email);
		if (a != null) {
			if (a.getAuthorPassword().equals(password)) {
				return "Login successfull";
			} else {
				return "Invalid password";
			}
		} else {
			return "Invalid email";
		}
	}
	public String deleteAll() {
		repo.deleteAll();
		return "All data deleted";
	}
	
}
