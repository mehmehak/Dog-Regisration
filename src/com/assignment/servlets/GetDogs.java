package com.assignment.servlets;

import com.assignment.bean.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.assignment.dao.*;
/**
 * Servlet implementation class GetContacts
 */
import com.assignment.bean.*;
@WebServlet("/GetDogs")
public class GetDogs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Contacts contact = new Contacts();
	ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
	dogs = DAO.getDogs();
	request.setAttribute("dogs", dogs);
	request.getRequestDispatcher("view.jsp").forward(request, response);

}
}
