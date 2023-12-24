package com.qsp.SpringDemo.ServiceAuthor;

import java.util.List;

import com.qsp.SpringDemo.ExceptionHandling.IdAlreadyPresentException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ResponseStructure.ResponseStructure;
import com.qsp.SpringDemo.dto.Author;

public interface AuthorService {

	ResponseStructure<Author> save(Author author) throws IdAlreadyPresentException;

	ResponseStructure<List<Author>> fetchAll();

	ResponseStructure<Author> fetchOne(int id) throws IdNotFoundException;

	ResponseStructure<Author> delete(int id) throws IdNotFoundException;

	ResponseStructure<Author> update(Author author, int id) throws IdNotFoundException;

	String loginByEmail(String email, String password);

	ResponseStructure<String> deleteAll();

}
