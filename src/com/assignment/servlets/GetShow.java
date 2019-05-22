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
 * Servlet implementation class GetShow
 */
@WebServlet("/GetShow")
public class GetShow extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String day = request.getParameter("day");
		//Contacts contact = new Contacts();
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		dogs = DAO.getDogsShow(day);
		request.setAttribute("dogs", dogs);
		request.getRequestDispatcher("view.jsp").forward(request, response);
		}

}
