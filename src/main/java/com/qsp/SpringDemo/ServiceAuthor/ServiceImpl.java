package com.qsp.SpringDemo.ServiceAuthor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.SpringDemo.ExceptionHandling.IdAlreadyPresentException;
import com.qsp.SpringDemo.ExceptionHandling.IdNotFoundException;
import com.qsp.SpringDemo.ResponseStructure.ResponseStructure;
import com.qsp.SpringDemo.dao.AuthorDao;
import com.qsp.SpringDemo.dto.Author;

@Service
public class ServiceImpl implements AuthorService {

	@Autowired
	AuthorDao authorDao;

	
	public ResponseStructure<Author> save(Author author) throws IdAlreadyPresentException {

		
		Author save = authorDao.save(author);
		ResponseStructure<Author> responseStructure=new ResponseStructure<>();
		responseStructure.setDataT(save);
		responseStructure.setHttpMessage("Employee data saved");
		responseStructure.setStatus(HttpStatus.OK);
		responseStructure.setHttpStatusCode(200);
		responseStructure.setDateTime(LocalDateTime.now());
		return responseStructure;
	}

	
	public ResponseStructure<List<Author>> fetchAll() {

	 List<Author> fetchAll = authorDao.fetchAll();
		ResponseStructure<List<Author>> structure=new ResponseStructure<>();
		structure.setDataT(fetchAll);
		structure.setDateTime(LocalDateTime.now());
		structure.setHttpMessage("All data are fetched");
		structure.setHttpStatusCode(200);
		structure.setStatus(HttpStatus.ACCEPTED);
		return structure;
	}


	public ResponseStructure<Author> fetchOne(int id) throws IdNotFoundException {

		Author author = authorDao.fetchOne(id);
		ResponseStructure<Author> responseStructure=new ResponseStructure<>();
		responseStructure.setDataT(author);
		responseStructure.setHttpMessage("Data fetched");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		responseStructure.setHttpStatusCode(200);
		return responseStructure;
	}

	@Override
	public ResponseStructure<Author> delete(int id) throws IdNotFoundException {
		Author author = authorDao.delete(id);
		ResponseStructure<Author> responseStructure=new ResponseStructure<>();
		responseStructure.setDataT(author);
		responseStructure.setHttpMessage("Deleted Successufully");
		responseStructure.setHttpStatusCode(200);
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		responseStructure.setDateTime(LocalDateTime.now());
		return responseStructure;
	}

	
	public ResponseStructure<Author> update(Author author, int id) throws IdNotFoundException {
		Author update = authorDao.update(author, id);
		ResponseStructure<Author> s=new ResponseStructure<>();
		s.setDataT(update);
		s.setDateTime(LocalDateTime.now());
		s.setHttpMessage("Updated successfull");
		s.setHttpStatusCode(200);
		s.setStatus(HttpStatus.ACCEPTED);
		return s;
	}

	
	public String loginByEmail(String email, String password) {
		String s = authorDao.loginByEmail(email, password);
		return s;
	}


	@Override
	public ResponseStructure<String> deleteAll() {
		String s=authorDao.deleteAll();
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setDataT(s);
		responseStructure.setHttpMessage("Data deleted");
		responseStructure.setHttpStatusCode(200);
		responseStructure.setStatus(HttpStatus.ACCEPTED);
		
		return responseStructure;
	}

}
