package com.jessica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "user_audit")
public class Audit {

    @Id
    @Column(name = "id_user_audit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_author")
    private Long author;
    @Column(name = "id_affected_user")
    private Long affectedUser;
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "id_operation")
    private Long operation;
    @Column(name = "date")
    private Date date;
    
    
	public Audit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Audit(Long author, Long affectedUser, String username, String name, String lastname, String password,
			String email, Long operation, Date date) {
		super();
		this.author = author;
		this.affectedUser = affectedUser;
		this.username = username;
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.operation = operation;
		this.date = date;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getAuthor() {
		return author;
	}


	public void setAuthor(Long author) {
		this.author = author;
	}


	public Long getAffectedUser() {
		return affectedUser;
	}


	public void setAffectedUser(Long affectedUser) {
		this.affectedUser = affectedUser;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getOperation() {
		return operation;
	}


	public void setOperation(Long operation) {
		this.operation = operation;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


    
}