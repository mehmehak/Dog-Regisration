package com.assignment.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.bean.Bean2;
import com.assignment.dao.DAO;


@WebServlet("/ViewDogs")
public class ViewDogs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<Bean2> dogs = new ArrayList<Bean2>();
			String day = request.getParameter("day");
			dogs = DAO.viewDogs(day);
			request.setAttribute("dogs", dogs);
			request.getRequestDispatcher("view2.jsp").forward(request, response);

		}
		
	

	
	}


