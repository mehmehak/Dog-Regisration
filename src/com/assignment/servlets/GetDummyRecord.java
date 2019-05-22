package com.assignment.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.bean.RegistrationBean;
import com.assignment.dao.DAO;

/**
 * Servlet implementation class GetDummyRecord
 */
@WebServlet("/GetDummyRecord")
public class GetDummyRecord extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//RegistrationBean dog = new RegistrationBean();
		DAO.addDummyDogs();
		//RequestDispatcher view = request.getRequestDispatcher("gameboard.jsp");
		//view.forward(request, response);
		//request.setAttribute("dog", dog);
		request.getRequestDispatcher("Register.jsp").forward(request, response);

	}
}
