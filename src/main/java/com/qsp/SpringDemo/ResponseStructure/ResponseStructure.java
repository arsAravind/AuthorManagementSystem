package com.qsp.SpringDemo.ResponseStructure;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.qsp.SpringDemo.dto.Author;

import lombok.Data;

@Data
public class ResponseStructure<T> { //T accept all class object

	private List<T> list;
	private T dataT;
	private String httpMessage;
	private int httpStatusCode;
	private LocalDateTime dateTime;
	private HttpStatus status;

}
