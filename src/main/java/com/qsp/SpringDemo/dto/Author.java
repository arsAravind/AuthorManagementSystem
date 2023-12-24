package com.qsp.SpringDemo.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Author_Id")
	//@NotBlank(message = "Id should not be blank")
	private int authorId;
	@NotBlank(message = "Name should not empty")
	@Column(name = "Author_Name")
	private String authorName;
	@Column(name = "Author_PhNo")
	private String authorPhNo;
	@Column(name = "Author_Email")
	@Email
	private String authorEmail;
	@Column(name = "Author_Password")
	private String authorPassword;
	@Column(name = "Author_Place")
	private String autorPlace;
	
	


}
