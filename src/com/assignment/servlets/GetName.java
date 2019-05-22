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
 * Servlet implementation class GetName
 */
@WebServlet("/GetName")
public class GetName extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("searchName");
	//Contacts contact = new Contacts();
	ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
	dogs = DAO.getDogNames(name);
	request.setAttribute("dogs", dogs);
	request.getRequestDispatcher("view.jsp").forward(request, response);
	}
}
