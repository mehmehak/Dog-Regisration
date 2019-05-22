package com.assignment.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.bean.RegistrationBean;
import com.assignment.dao.DAO;

/**
 * Servlet implementation class EditDoggy
 */
@WebServlet("/EditDoggy")
public class EditDoggy extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String owner = request.getParameter("owner");
		String gender = request.getParameter("gen");
		String group = request.getParameter("group");
		String breed = request.getParameter("breed");
		String type = request.getParameter("type");
		String day = request.getParameter("day");
		String to = request.getParameter("to");
		String num = request.getParameter("number");
		int number = Integer.parseInt(num);
		
		System.out.println(group);
		RegistrationBean dog = new RegistrationBean();		
		dog.setBreed(breed);
		dog.setGroup(group);
		dog.setName(name);
		dog.setOwner(owner);
		dog.setGender(gender);
		dog.setType(type);
		dog.setDay(day);
		dog.setMail(to);
		
		
		
		DAO.EditDog(number,dog);
		//RequestDispatcher view = request.getRequestDispatcher("gameboard.jsp");
		//view.forward(request, response);
		request.setAttribute("dog", dog);
		request.getRequestDispatcher("view.jsp").forward(request, response);

	}	
		
		
		
}
