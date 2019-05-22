package com.assignment.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.assignment.bean.*;
import com.assignment.dao.DAO;

/**
 * Servlet implementation class DisplayAward
 */
@WebServlet("/DisplayAward")
public class DisplayAward extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prize = request.getParameter("prize");
		//Contacts contact = new Contacts();
		JFrame frame = new JFrame();
		if(prize.equals("bestOfBreed")) {
			 ImageIcon icon = new ImageIcon("dog.jpg");	
		}
		else if(prize.equals("bestOfOppositeSex")) {
			 ImageIcon icon = new ImageIcon("dog.jpg");	
		}
		else if(prize.equals("firstInGroup")) {
			 ImageIcon icon = new ImageIcon("group1.jpg");	
		}
		else if(prize.equals("secondInGroup")) {
			 ImageIcon icon = new ImageIcon("dog.jpg");	
		}
		else if(prize.equals("thirdInGroup")) {
			 ImageIcon icon = new ImageIcon("dog.jpg");	
		}
		else if(prize.equals("fourthInGroup")) {
			 ImageIcon icon = new ImageIcon("dog.jpg");	
		}
		else if(prize.equals("reserveWinner")) {
			 ImageIcon icon = new ImageIcon("dog.jpg");	
		}
		else {
			 ImageIcon icon = new ImageIcon("bestInShow.jpg");	
		}
		ImageIcon icon = new ImageIcon("dog.jpg");	
		  JLabel label = new JLabel(icon);
		  frame.add(label);
		  frame.setDefaultCloseOperation
		         (JFrame.EXIT_ON_CLOSE);
		  frame.pack();
		  frame.setVisible(true);
		ArrayList<Awards> dogs = new ArrayList<Awards>();
		dogs = DAO.getAwards(prize);
		request.setAttribute("dogs", dogs);
		request.getRequestDispatcher("view3.jsp").forward(request, response);
	}

}
