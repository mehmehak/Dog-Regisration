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

import com.assignment.dao.DAO;
import com.assignment.bean.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String owner = request.getParameter("owner");
		String gender = request.getParameter("gen");
		String group = request.getParameter("group");
		String breed = request.getParameter("breed");
		String type = request.getParameter("type");
		String day = request.getParameter("day");
		String to = request.getParameter("to");
		
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
		//HttpSession session = request.getSession();
		//session.setAttribute("Drink", drink);
		
		DAO.addDogs(dog);
		//send email
		try {
			
			String subject = "Dog Registration Successful";
		    String body = "Hello " + owner + '\n' +"Your " + name + "has been registered for show on " + day+ '\n'  + "your dog information is as follow"+ '\n'  + "Breed: " + breed+ '\n'  + "Gender: " + gender+ '\n'  + "Group: "+ '\n'  + group+ '\n'  + "Type: " + type;
			String from = "inasharma001@gmail.com";
		    
		    String password = "donotmove1";
		    
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", "465");
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtps.quitwait", "false");
		Session session = Session.getDefaultInstance(props);
		System.out.println("mailPart");
		Message message = new MimeMessage(session);
		message.setSubject(subject);
		message.setText(body);
		
		Address fromAddress = new InternetAddress(from);
		Address toAddress = new InternetAddress(to);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);
		
		Transport transport = session.getTransport();
		transport.connect(from, password);
		transport.sendMessage(message, message.getAllRecipients());
		
		
	}
catch (MessagingException e)
		{
	System.out.println(e);
		}
	
		//RequestDispatcher view = request.getRequestDispatcher("gameboard.jsp");
		//view.forward(request, response);
		request.setAttribute("dog", dog);
		request.getRequestDispatcher("Register.jsp").forward(request, response);

	}	
	}

	


