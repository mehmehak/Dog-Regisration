package com.assignment.servlets;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.bean.Awards;
import com.assignment.dao.DAO;

/**
 * Servlet implementation class GetAwards
 */
@WebServlet("/GetAwards")
public class GetAwards extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String numb = request.getParameter("id");
		int id = Integer.parseInt(numb);
		String day = request.getParameter("day");
		String awards = request.getParameter("awards");
		
		
		Awards dog = new Awards();		
		
		dog.setName(name);
		dog.setNumber(id);
		dog.setDay(day);
		dog.setAwards(awards);
		//HttpSession session = request.getSession();
		//session.setAttribute("Drink", drink);
		
		DAO.addAwards(dog);
			request.setAttribute("dog", dog);
		request.getRequestDispatcher("Register.jsp").forward(request, response);

	}
}
