package com.assignment.bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bean2
 */
@WebServlet("/Bean2")
public class Bean2 extends HttpServlet {
	 private int number;
	 private String breeds;
	 private String day;
	 private int maleClass;
	 public Bean2() {
		super();
	}
	public Bean2(int number, String breeds, int maleClass, int femaleClass, int maleSpecial, int femaleSpecial, String day) {
		super();
		this.number = number;
		this.breeds = breeds;
		this.maleClass = maleClass;
		this.femaleClass = femaleClass;
		this.maleSpecial = maleSpecial;
		this.femaleSpecial = femaleSpecial;
		this.day = day;
	}
	private int femaleClass;
	 private int maleSpecial;
	 @Override
	public String toString() {
		return "Bean2 [number=" + number + ", breeds=" + breeds + ", maleClass=" + maleClass + ", femaleClass="
				+ femaleClass + ", maleSpecial=" + maleSpecial + ", femaleSpecial=" + femaleSpecial + "]";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getBreeds() {
		return breeds;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDay() {
		return day;
	}
	public void setBreeds(String breeds) {
		this.breeds = breeds;
	}
	public int getMaleClass() {
		return maleClass;
	}
	public void setMaleClass(int maleClass) {
		this.maleClass = maleClass;
	}
	public int getFemaleClass() {
		return femaleClass;
	}
	public void setFemaleClass(int femaleClass) {
		this.femaleClass = femaleClass;
	}
	public int getMaleSpecial() {
		return maleSpecial;
	}
	public void setMaleSpecial(int maleSpecial) {
		this.maleSpecial = maleSpecial;
	}
	public int getFemaleSpecial() {
		return femaleSpecial;
	}
	public void setFemaleSpecial(int femaleSpecial) {
		this.femaleSpecial = femaleSpecial;
	}
	private int femaleSpecial;
	 
}
