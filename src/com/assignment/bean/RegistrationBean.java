package com.assignment.bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationBean
 */
@WebServlet("/RegistrationBean")
public class RegistrationBean extends HttpServlet {
	private int number;
	private String name;
	private String owner;
	private String gender;
	private String type;
	private String breed;
	private String group;
	private String day;
	private String mail;
	public RegistrationBean(int number, String name, String owner, String gender, String type, String breed, String group, String day, String mail) {
		super();
		this.number = number;
		this.name = name;
		this.owner = owner;
		this.gender = gender;
		this.type = type;
		this.breed = breed;
		this.group = group;
		this.day = day;
		this.mail = mail;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	
    
    public RegistrationBean() {
        super();
    }


	
}
