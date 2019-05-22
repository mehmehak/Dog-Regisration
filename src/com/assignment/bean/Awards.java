package com.assignment.bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Awards
 */
@WebServlet("/Awards")
public class Awards extends HttpServlet {
	private int number;
	private String name;
	
	private String day;
	private String awards;
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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public Awards(int number, String name, String day, String awards) {
		super();
		this.number = number;
		this.name = name;
		this.day = day;
		this.awards = awards;
	}
	public Awards() {
		super();
	}
	@Override
	public String toString() {
		return "Awards [number=" + number + ", name=" + name + ", day=" + day + ", awards=" + awards + "]";
	}
	
	

}
