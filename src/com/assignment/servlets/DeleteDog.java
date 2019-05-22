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
 * Servlet implementation class DeleteDog
 */
@WebServlet("/DeleteDog")
public class DeleteDog extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Contacts contact = new Contacts();
		String num = request.getParameter("number");
		int number = Integer.parseInt(num);
		
		 DAO.DeleteDog(number);
		
		request.getRequestDispatcher("view2.jsp").forward(request, response);

	}

}
