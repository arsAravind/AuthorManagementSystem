package com.qsp.SpringDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.SpringDemo.ExceptionHandling.IdAlreadyPresentException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ResponseStructure.ResponseStructure;
import com.qsp.SpringDemo.ServiceAuthor.AuthorService;
import com.qsp.SpringDemo.dto.Author;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody Author author) throws IdAlreadyPresentException {
		ResponseStructure<Author> s = authorService.save(author);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<?> authors() {
		ResponseStructure<List<Author>> authors = authorService.fetchAll();
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	@GetMapping("/fetchOne/{id}")
	public ResponseEntity<?> author(@PathVariable int id) throws IdNotFoundException {
		ResponseStructure<Author> author = authorService.fetchOne(id);
		return new ResponseEntity<>(author, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Author author, @PathVariable int id) throws IdNotFoundException {
		ResponseStructure<Author> s = authorService.update(author, id);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws IdNotFoundException {
		ResponseStructure<Author> s = authorService.delete(id);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@GetMapping("/loginByEmail")
	public String loginByEmail(@RequestParam String email, @RequestParam String password) {
		String s = authorService.loginByEmail(email, password);
		return s;
	}
	
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> entity()
	{
		ResponseStructure<String> s= authorService.deleteAll();
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}

}
