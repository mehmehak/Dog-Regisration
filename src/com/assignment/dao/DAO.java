package com.assignment.dao;

import java.util.*;

import javax.activation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.bean.*;

/**
 * Servlet implementation class DAO
 */
@WebServlet("/DAO")
public class DAO  {
	public static void addDogs(RegistrationBean c) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            int i=0;
            String q = " Insert Into myDogs Values( '"+i +"', '"+ c.getName() 
            	+"', '"+ c.getOwner() +"', '"+ c.getBreed() +"', '"+ c.getGroup() +"', '"+ c.getGender() +"', '" +c.getType()
            	+ "', '"+ c.getDay() +"', '"+ c.getMail() +"')";
            
            Statement st = conn.createStatement();

            st.executeUpdate(q);
            
            System.out.println("Connection Success");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
            System.out.println("addDogs");
        }
	}
	public static void addAwards(Awards c) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            
            String q = " Insert Into myAwards Values( '"+c.getNumber() +"', '"+ c.getName() 
            	+"', '"+ c.getDay() +"', '"+ c.getAwards() +"')";
            
            Statement st = conn.createStatement();

            st.executeUpdate(q);
            
            System.out.println("Connection Success");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
            System.out.println("addAwards");
        }
	}
	public static ArrayList<Bean2>  viewDogs(String day) {
		ArrayList<Bean2> dogs = new ArrayList<Bean2>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
           // String q1 = "select breed, COUNT(*)as total, COUNT(case when (myDogs.gender='male' AND myDogs.groupType='class') then 1 end) as maleClass, COUNT(case when (myDogs.gender='male' AND myDogs.groupType='speciality') then 1 end) as maleSpeciality, COUNT(case when (myDogs.gender='female' AND myDogs.groupType='class') then 1 end) as femaleClass, COUNT(case when (myDogs.gender='female' AND myDogs.groupType='speciality') then 1 end) as femaleSpeciality, from myDogsgroup by breed";
           String q1 = "select COUNT(*)as total, breed,\r\n" + 
           		" COUNT(case when (myDogs.gender='male' AND myDogs.groupType='class') then 1 end) as maleClass,\r\n" + 
           		" COUNT(case when (myDogs.gender='male' AND myDogs.groupType='speciality') then 1 end) as maleSpeciality,\r\n" + 
           		" COUNT(case when (myDogs.gender='female' AND myDogs.groupType='class') then 1 end) as femaleClass,\r\n" + 
           		" COUNT(case when (myDogs.gender='female' AND myDogs.groupType='speciality') then 1 end) as femaleSpeciality\r\n" + 
           		" from myDogs\r\n" + 
           		" where day ='"+day+"'" +
           		"group by breed"; 
           		
            
            Statement st = conn.createStatement();

            
           
            ResultSet rs1 = st.executeQuery(q1);
            ResultSetMetaData rsmd1 = rs1.getMetaData();
            
            int numColumns1 = rsmd1.getColumnCount();
            
            while(rs1.next()) {
            	Bean2 c = new Bean2();
            	c.setNumber(rs1.getInt(1));
            	c.setBreeds(rs1.getString(2));
            	c.setMaleClass(rs1.getInt(3));
            	c.setFemaleClass(rs1.getInt(4));
            	c.setMaleSpecial(rs1.getInt(5));
            	c.setFemaleSpecial(rs1.getInt(6));
            	
            	
            		dogs.add(c);
            
            
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("viewDogs");
        }
		
		return dogs;
	}
	
	
	
	public static void addDummyDogs() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            int i=1;
            String q1 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
            	+"', '"+ "Jennifer" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
            	+ "', '"+ "Friday" +"', '"+ " " +"')";
            String q2 = " Insert Into myDogs Values( '"+i +"', '"+ "cimba" 
                	+"', '"+ "jon" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "sporting" 
                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
            String q3 = " Insert Into myDogs Values( '"+i +"', '"+ "luke" 
                	+"', '"+ "jaz" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                	+ "', '"+ "Sunday" +"', '"+ " " +"')";
            String q4 = " Insert Into myDogs Values( '"+i +"', '"+ "kitty" 
                	+"', '"+ "kiran" +"', '"+ "labrador" +"', '"+ "speciality" +"', '"+ "male" +"', '" + "Working" 
                	+ "', '"+ "Friday" +"', '"+ " " +"')";
            String q5 = " Insert Into myDogs Values( '"+i +"', '"+ "shadow" 
                	+"', '"+ "george" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
            String q6 = " Insert Into myDogs Values( '"+i +"', '"+ "tommy" 
                	+"', '"+ "virat" +"', '"+ "shepherd" +"', '"+ "speciality" +"', '"+ "male" +"', '" + "sporting" 
                	+ "', '"+ "Friday" +"', '"+ " " +"')";
            String q7 = " Insert Into myDogs Values( '"+i +"', '"+ "bo" 
                	+"', '"+ "Jennifer" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                	+ "', '"+ "Friday" +"', '"+ " " +"')";
            String q8 = " Insert Into myDogs Values( '"+i +"', '"+ "simba" 
                	+"', '"+ "zaffar" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
            String q9 = " Insert Into myDogs Values( '"+i +"', '"+ "lureous" 
                	+"', '"+ "Jennifer" +"', '"+ "french" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                	+ "', '"+ "Friday" +"', '"+ " " +"')";
            String q10 = " Insert Into myDogs Values( '"+i +"', '"+ "powery" 
                	+"', '"+ "varun" +"', '"+ "shepherd" +"', '"+ "speciality" +"', '"+ "male" +"', '" + "toys" 
                	+ "', '"+ "Friday" +"', '"+ " " +"')";
            String q11 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                	+"', '"+ "john" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                String q12 = " Insert Into myDogs Values( '"+i +"', '"+ "simba" 
                    	+"', '"+ "tom" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "sporting" 
                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                String q13 = " Insert Into myDogs Values( '"+i +"', '"+ "bob" 
                    	+"', '"+ "jack" +"', '"+ "french" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                    	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                String q14 = " Insert Into myDogs Values( '"+i +"', '"+ "boby" 
                    	+"', '"+ "daffoe" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                    	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                String q15 = " Insert Into myDogs Values( '"+i +"', '"+ "bello" 
                    	+"', '"+ "arun" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                String q16 = " Insert Into myDogs Values( '"+i +"', '"+ "lurie" 
                    	+"', '"+ "chung" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                String q17 = " Insert Into myDogs Values( '"+i +"', '"+ "shon" 
                    	+"', '"+ "nicole" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                    	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                String q18 = " Insert Into myDogs Values( '"+i +"', '"+ "kristi" 
                    	+"', '"+ "ida" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                String q19 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                    	+"', '"+ "leung" +"', '"+ "french" +"', '"+ "class" +"', '"+ "male" +"', '" + "sporting" 
                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                String q20 = " Insert Into myDogs Values( '"+i +"', '"+ "simba" 
                    	+"', '"+ "jass" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "toys" 
                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                String q21 = " Insert Into myDogs Values( '"+i +"', '"+ "bo" 
                    	+"', '"+ "jack" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "sporting" 
                    	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                    String q22 = " Insert Into myDogs Values( '"+i +"', '"+ "tiger" 
                        	+"', '"+ "Jennifer" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                    String q23 = " Insert Into myDogs Values( '"+i +"', '"+ "tetra" 
                        	+"', '"+ "jaz" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "sporting" 
                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                    String q24 = " Insert Into myDogs Values( '"+i +"', '"+ "tommy" 
                        	+"', '"+ "varun" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                        	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                    String q25 = " Insert Into myDogs Values( '"+i +"', '"+ "tarzan" 
                        	+"', '"+ "mirry" +"', '"+ "rottweilers" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                        	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                    String q26 = " Insert Into myDogs Values( '"+i +"', '"+ "simba" 
                        	+"', '"+ "Jennifer" +"', '"+ "rottweilers" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                    String q27 = " Insert Into myDogs Values( '"+i +"', '"+ "cimba" 
                        	+"', '"+ "jacklene" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                    String q28 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                        	+"', '"+ "jonny" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                    String q29 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                        	+"', '"+ "tom" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                        	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                    String q30 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                        	+"', '"+ "ida" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "toys" 
                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                    String q31 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                        	+"', '"+ "jon" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                        String q32 = " Insert Into myDogs Values( '"+i +"', '"+ "bo" 
                            	+"', '"+ "justin" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "toys" 
                            	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                        String q33 = " Insert Into myDogs Values( '"+i +"', '"+ "bo" 
                            	+"', '"+ "araya" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                        String q34 = " Insert Into myDogs Values( '"+i +"', '"+ "bhalo" 
                            	+"', '"+ "avani" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "sporting" 
                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                        String q35 = " Insert Into myDogs Values( '"+i +"', '"+ "bhaoji" 
                            	+"', '"+ "zeena" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "sporting" 
                            	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                        String q36 = " Insert Into myDogs Values( '"+i +"', '"+ "tiger" 
                            	+"', '"+ "jass" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                        String q37 = " Insert Into myDogs Values( '"+i +"', '"+ "tera" 
                            	+"', '"+ "Jennifer" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                            	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                        String q38 = " Insert Into myDogs Values( '"+i +"', '"+ "speciality" 
                            	+"', '"+ "Jennifer" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                        String q39 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                            	+"', '"+ "Jennifer" +"', '"+ "shepherd" +"', '"+ "speciality" +"', '"+ "male" +"', '" + "Working" 
                            	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                        String q40 = " Insert Into myDogs Values( '"+i +"', '"+ "cimba" 
                            	+"', '"+ "Jennifer" +"', '"+ "labrador" +"', '"+ "speciality" +"', '"+ "male" +"', '" + "terriers" 
                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                        String q41 = " Insert Into myDogs Values( '"+i +"', '"+ "cimba" 
                            	+"', '"+ "Jennifer" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "toys" 
                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                            String q42 = " Insert Into myDogs Values( '"+i +"', '"+ "cimba" 
                                	+"', '"+ "Jennifer" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                            String q43 = " Insert Into myDogs Values( '"+i +"', '"+ "tiger" 
                                	+"', '"+ "tomm" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "sporting" 
                                	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                            String q44 = " Insert Into myDogs Values( '"+i +"', '"+ "tiger" 
                                	+"', '"+ "virat" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                            String q45 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                	+"', '"+ "vikram" +"', '"+ "Boxer" +"', '"+ "speciality" +"', '"+ "male" +"', '" + "sporting" 
                                	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                            String q46 = " Insert Into myDogs Values( '"+i +"', '"+ "tiger" 
                                	+"', '"+ "Jennifer" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                                	+ "', '"+ "Friday" +"', '"+ " " +"')";
                            String q47 = " Insert Into myDogs Values( '"+i +"', '"+ "shadow" 
                                	+"', '"+ "varul" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                	+ "', '"+ "Friday" +"', '"+ " " +"')";
                            String q48 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                	+"', '"+ "varul" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                            String q49 = " Insert Into myDogs Values( '"+i +"', '"+ "shadow" 
                                	+"', '"+ "varul" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                            String q50 = " Insert Into myDogs Values( '"+i +"', '"+ "bla" 
                                	+"', '"+ "varul" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                            String q51 = " Insert Into myDogs Values( '"+i +"', '"+ "simba" 
                                	+"', '"+ "Jennifer" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "toys" 
                                	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                String q52 = " Insert Into myDogs Values( '"+i +"', '"+ "blu" 
                                    	+"', '"+ "zessy" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                    	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                String q53 = " Insert Into myDogs Values( '"+i +"', '"+ "berru" 
                                    	+"', '"+ "jeorge" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "nonsporting" 
                                    	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                String q54 = " Insert Into myDogs Values( '"+i +"', '"+ "bondi" 
                                    	+"', '"+ "shern" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                String q55 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                    	+"', '"+ "ida" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                String q56 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                    	+"', '"+ "leung" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "toys" 
                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                String q57 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                    	+"', '"+ "kiran" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                                    	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                String q58 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                    	+"', '"+ "justin" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "male" +"', '" + "hounds" 
                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                String q59 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                    	+"', '"+ "monik" +"', '"+ "bulldogs" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                String q60 = " Insert Into myDogs Values( '"+i +"', '"+ "sherru" 
                                    	+"', '"+ "krish" +"', '"+ "french" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                String q61 = " Insert Into myDogs Values( '"+i +"', '"+ "tommy" 
                                    	+"', '"+ "breti" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "nonsporting" 
                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                    String q62 = " Insert Into myDogs Values( '"+i +"', '"+ "cheeta" 
                                        	+"', '"+ "morela" +"', '"+ "bulldogs" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                        	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                    String q63 = " Insert Into myDogs Values( '"+i +"', '"+ "tig" 
                                        	+"', '"+ "simra" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "nonsporting" 
                                        	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                    String q64 = " Insert Into myDogs Values( '"+i +"', '"+ "tetra" 
                                        	+"', '"+ "Jennifer" +"', '"+ "french" +"', '"+ "class" +"', '"+ "male" +"', '" + "Working" 
                                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                    String q65 = " Insert Into myDogs Values( '"+i +"', '"+ "tozz" 
                                        	+"', '"+ "breti" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "terriers" 
                                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                    String q66 = " Insert Into myDogs Values( '"+i +"', '"+ "tera" 
                                        	+"', '"+ "breti" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "male" +"', '" + "nonsporting" 
                                        	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                    String q67 = " Insert Into myDogs Values( '"+i +"', '"+ "toggy" 
                                        	+"', '"+ "breti" +"', '"+ "rottweilers" +"', '"+ "class" +"', '"+ "male" +"', '" + "herding" 
                                        	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                    String q68 = " Insert Into myDogs Values( '"+i +"', '"+ "dore" 
                                        	+"', '"+ "breti" +"', '"+ "poodles" +"', '"+ "class" +"', '"+ "male" +"', '" + "herding" 
                                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                    String q69 = " Insert Into myDogs Values( '"+i +"', '"+ "cila" 
                                        	+"', '"+ "jon" +"', '"+ "beagles" +"', '"+ "class" +"', '"+ "male" +"', '" + "herding" 
                                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                    String q70 = " Insert Into myDogs Values( '"+i +"', '"+ "sheru" 
                                        	+"', '"+ "cristofo" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "male" +"', '" + "herding" 
                                        	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                    String q71 = " Insert Into myDogs Values( '"+i +"', '"+ "luki" 
                                        	+"', '"+ "jack" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "female" +"', '" + "sporting" 
                                        	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                        String q72 = " Insert Into myDogs Values( '"+i +"', '"+ "lure" 
                                            	+"', '"+ "justin" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                            	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                        String q73 = " Insert Into myDogs Values( '"+i +"', '"+ "tiger" 
                                            	+"', '"+ "Jennifer" +"', '"+ "poodles" +"', '"+ "class" +"', '"+ "female" +"', '" + "toys" 
                                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                        String q74 = " Insert Into myDogs Values( '"+i +"', '"+ "shadow" 
                                            	+"', '"+ "sehak" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                        String q75 = " Insert Into myDogs Values( '"+i +"', '"+ "strongy" 
                                            	+"', '"+ "saj" +"', '"+ "poodles" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                            	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                        String q76 = " Insert Into myDogs Values( '"+i +"', '"+ "cindy" 
                                            	+"', '"+ "cristofo" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "female" +"', '" + "toys" 
                                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                        String q77 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                            	+"', '"+ "mahal" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "female" +"', '" + "sporting" 
                                            	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                        String q78 = " Insert Into myDogs Values( '"+i +"', '"+ "harne" 
                                            	+"', '"+ "seerrat" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "female" +"', '" + "terriers" 
                                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                        String q79 = " Insert Into myDogs Values( '"+i +"', '"+ "hazal" 
                                            	+"', '"+ "deep" +"', '"+ "beagles" +"', '"+ "class" +"', '"+ "female" +"', '" + "sporting" 
                                            	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                        String q80 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                            	+"', '"+ "cristofo" +"', '"+ "poodles" +"', '"+ "class" +"', '"+ "female" +"', '" + "hounds" 
                                            	+ "', '"+ "Friday" +"', '"+ " " +"')";                           
                                        String q81 = " Insert Into myDogs Values( '"+i +"', '"+ "fanty" 
                                            	+"', '"+ "Jennifer" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "female" +"', '" + "herding" 
                                            	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                            String q82 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                                	+"', '"+ "cristofo" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "female" +"', '" + "herding" 
                                                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                            String q83 = " Insert Into myDogs Values( '"+i +"', '"+ "leera" 
                                                	+"', '"+ "Jennifer" +"', '"+ "bulldogs" +"', '"+ "class" +"', '"+ "female" +"', '" + "toys" 
                                                	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                            String q84 = " Insert Into myDogs Values( '"+i +"', '"+ "lizo" 
                                                	+"', '"+ "cristofo" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                                	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                            String q85 = " Insert Into myDogs Values( '"+i +"', '"+ "tiger" 
                                                	+"', '"+ "nikhil" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                                	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                            String q86 = " Insert Into myDogs Values( '"+i +"', '"+ "tommy" 
                                                	+"', '"+ "Jennifer" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                            String q87 = " Insert Into myDogs Values( '"+i +"', '"+ "tonz" 
                                                	+"', '"+ "sahil" +"', '"+ "bulldogs" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                                	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                            String q88 = " Insert Into myDogs Values( '"+i +"', '"+ "kutta" 
                                                	+"', '"+ "neeraj" +"', '"+ "retrivers" +"', '"+ "class" +"', '"+ "female" +"', '" + "terriers" 
                                                	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                            String q89 = " Insert Into myDogs Values( '"+i +"', '"+ "beer" 
                                                	+"', '"+ "Jennifer" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "female" +"', '" + "hounds" 
                                                	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                            String q90 = " Insert Into myDogs Values( '"+i +"', '"+ "bony" 
                                                	+"', '"+ "Jennifer" +"', '"+ "shepherd" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                                	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                            String q91 = " Insert Into myDogs Values( '"+i +"', '"+ "kitty" 
                                                	+"', '"+ "pranchal" +"', '"+ "beagles" +"', '"+ "class" +"', '"+ "female" +"', '" + "toys" 
                                                	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                                String q92 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                                    	+"', '"+ "jyoti" +"', '"+ "Boxer" +"', '"+ "speciality" +"', '"+ "female" +"', '" + "Working" 
                                                    	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                                String q93 = " Insert Into myDogs Values( '"+i +"', '"+ "kiratu" 
                                                    	+"', '"+ "pranchal" +"', '"+ "Boxer" +"', '"+ "class" +"', '"+ "female" +"', '" + "Working" 
                                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                                String q94 = " Insert Into myDogs Values( '"+i +"', '"+ "exo" 
                                                    	+"', '"+ "Jennifer" +"', '"+ "poodles" +"', '"+ "speciality" +"', '"+ "female" +"', '" + "terriers" 
                                                    	+ "', '"+ "Sunday" +"')";
                                                String q95 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                                    	+"', '"+ "malik" +"', '"+ "labrador" +"', '"+ "class" +"', '"+ "female" +"', '" + "nonsporting" 
                                                    	+ "', '"+ "Saturday" +"', '"+ " " +"')";
                                                String q96 = " Insert Into myDogs Values( '"+i +"', '"+ "pony" 
                                                    	+"', '"+ "zaffar" +"', '"+ "beagles" +"', '"+ "speciality" +"', '"+ "female" +"', '" + "hounds" 
                                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                                String q97 = " Insert Into myDogs Values( '"+i +"', '"+ "vorn" 
                                                    	+"', '"+ "jera" +"', '"+ "bulldogs" +"', '"+ "speciality" +"', '"+ "female" +"', '" + "sporting" 
                                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                                String q98 = " Insert Into myDogs Values( '"+i +"', '"+ "corny" 
                                                    	+"', '"+ "neerat" +"', '"+ "retrivers" +"', '"+ "speciality" +"', '"+ "female" +"', '" + "sporting" 
                                                    	+ "', '"+ "Sunday" +"', '"+ " " +"')";
                                                String q99 = " Insert Into myDogs Values( '"+i +"', '"+ "cello" 
                                                    	+"', '"+ "nav" +"', '"+ "Boxer" +"', '"+ "speciality" +"', '"+ "female" +"', '" + "Working" 
                                                    	+ "', '"+ "Friday" +"', '"+ " " +"')";
                                                String q100 = " Insert Into myDogs Values( '"+i +"', '"+ "furry" 
                                                    	+"', '"+ "zaffar" +"', '"+ "shepherd" +"', '"+ "speciality" +"', '"+ "female" +"', '" + "Working" 
                                                    	+ "', '"+ "Saturday" +"', '"+ " " +"')";                               
            Statement st = conn.createStatement();

            st.executeUpdate(q1);
            st.executeUpdate(q2);
            st.executeUpdate(q3);
            st.executeUpdate(q4);
            st.executeUpdate(q5);
            st.executeUpdate(q6);
            st.executeUpdate(q7);
            st.executeUpdate(q8);
            st.executeUpdate(q9);
            st.executeUpdate(q10);
            st.executeUpdate(q11);
            st.executeUpdate(q12);
            st.executeUpdate(q13);
            st.executeUpdate(q14);
            st.executeUpdate(q15);
            st.executeUpdate(q16);
            st.executeUpdate(q17);
            st.executeUpdate(q18);
            st.executeUpdate(q19);
            st.executeUpdate(q20);
            st.executeUpdate(q21);
            st.executeUpdate(q22);
            st.executeUpdate(q23);
            st.executeUpdate(q24);
            st.executeUpdate(q25);
            st.executeUpdate(q26);
            st.executeUpdate(q27);
            st.executeUpdate(q28);
            st.executeUpdate(q29);
            st.executeUpdate(q30);
            st.executeUpdate(q31);
            st.executeUpdate(q32);
            st.executeUpdate(q33);
            st.executeUpdate(q34);
            st.executeUpdate(q35);
            st.executeUpdate(q36);
            st.executeUpdate(q37);
            st.executeUpdate(q38);
            st.executeUpdate(q39);
            st.executeUpdate(q40);
            st.executeUpdate(q41);
            st.executeUpdate(q42);
            st.executeUpdate(q43);
            st.executeUpdate(q44);
            st.executeUpdate(q45);
            st.executeUpdate(q46);
            st.executeUpdate(q47);
            st.executeUpdate(q48);
            st.executeUpdate(q49);
            st.executeUpdate(q50);
            st.executeUpdate(q51);
            st.executeUpdate(q52);
            st.executeUpdate(q53);
            st.executeUpdate(q54);
            st.executeUpdate(q55);
            st.executeUpdate(q56);
            st.executeUpdate(q57);
            st.executeUpdate(q58);
            st.executeUpdate(q59);
            st.executeUpdate(q60);
            st.executeUpdate(q61);
            st.executeUpdate(q62);
            st.executeUpdate(q63);
            st.executeUpdate(q64);
            st.executeUpdate(q65);
            st.executeUpdate(q66);
            st.executeUpdate(q67);
            st.executeUpdate(q68);
            st.executeUpdate(q69);
            st.executeUpdate(q70);
            st.executeUpdate(q71);
            st.executeUpdate(q72);
            st.executeUpdate(q73);
            st.executeUpdate(q74);
            st.executeUpdate(q75);
            st.executeUpdate(q76);
            st.executeUpdate(q77);
            st.executeUpdate(q78);
            st.executeUpdate(q79);
            st.executeUpdate(q80);
            st.executeUpdate(q81);
            st.executeUpdate(q82);
            st.executeUpdate(q83);
            st.executeUpdate(q84);
            st.executeUpdate(q85);
            st.executeUpdate(q86);
            st.executeUpdate(q87);
            st.executeUpdate(q88);
            st.executeUpdate(q89);
            st.executeUpdate(q90);
            st.executeUpdate(q91);
            st.executeUpdate(q92);
            st.executeUpdate(q93);
            st.executeUpdate(q94);
            st.executeUpdate(q95);
            st.executeUpdate(q96);
            st.executeUpdate(q97);
            st.executeUpdate(q98);
            st.executeUpdate(q99);
            st.executeUpdate(q100);
            
            System.out.println("Connection Success");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
            System.out.println("addDummyDogs");
        }
	}
	
	public static ArrayList<RegistrationBean>  getDogs() {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            String q = "Select * from myDogs";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numColumns = rsmd.getColumnCount();
            
            while(rs.next()) {
            	RegistrationBean c = new RegistrationBean();
            	c.setNumber(rs.getInt(1));
            	c.setName(rs.getString(2));
            	c.setOwner(rs.getString(3));
            	c.setBreed(rs.getString(4));
            	c.setGroup(rs.getString(5));
            	c.setGender(rs.getString(6));
            	c.setType(rs.getString(7));
            	c.setDay(rs.getString(8));
            	c.setMail(rs.getString(9));
            	
            		dogs.add(c);
            	
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("getDogs");
        }
		
		return dogs;
	}
	
	
	public static ArrayList<RegistrationBean>  getDogNames(String name) {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            String q="Select * from myDogs where name='"+name+"'";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numColumns = rsmd.getColumnCount();
            
            while(rs.next()) {
            	RegistrationBean c = new RegistrationBean();
            	c.setNumber(rs.getInt(1));
            	c.setName(rs.getString(2));
            	c.setOwner(rs.getString(3));
            	c.setBreed(rs.getString(4));
            	c.setGroup(rs.getString(5));
            	c.setType(rs.getString(7));
            	c.setGender(rs.getString(6));
            	c.setDay(rs.getString(8));
            	c.setMail(rs.getString(9));
            		dogs.add(c);
            	
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("getDogsName");
        }
		
		return dogs;
	}    
	
	public static ArrayList<RegistrationBean>  getNumberNames(int number) {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            String q="Select * from myDogs where id='"+number+"'";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numColumns = rsmd.getColumnCount();
            
            while(rs.next()) {
            	RegistrationBean c = new RegistrationBean();
            	c.setNumber(rs.getInt(1));
            	c.setName(rs.getString(2));
            	c.setOwner(rs.getString(3));
            	c.setBreed(rs.getString(4));
            	c.setGroup(rs.getString(5));
            	c.setType(rs.getString(7));
            	c.setGender(rs.getString(6));
            	c.setDay(rs.getString(8));
            	c.setMail(rs.getString(9));
            		dogs.add(c);
            	
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("getDogsNumber");
        }
		
		return dogs;
	}    
	public static ArrayList<RegistrationBean>  getGroupNames(String group) {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            String q="Select * from myDogs where groupType='"+group+"'";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numColumns = rsmd.getColumnCount();
            
            while(rs.next()) {
            	RegistrationBean c = new RegistrationBean();
            	c.setNumber(rs.getInt(1));
            	c.setName(rs.getString(2));
            	c.setOwner(rs.getString(3));
            	c.setBreed(rs.getString(4));
            	c.setGroup(rs.getString(5));
            	c.setType(rs.getString(7));
            	c.setGender(rs.getString(6));
            	c.setDay(rs.getNString(8));
            	c.setMail(rs.getString(9));
            		dogs.add(c);
            	
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("getDogsGroup");
        }
		
		return dogs;
	}    
	
	public static ArrayList<RegistrationBean>  getOwnerNames(String owner) {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            String q="Select * from myDogs where owner='"+owner+"'";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numColumns = rsmd.getColumnCount();
            
            while(rs.next()) {
            	RegistrationBean c = new RegistrationBean();
            	c.setNumber(rs.getInt(1));
            	c.setName(rs.getString(2));
            	c.setOwner(rs.getString(3));
            	c.setBreed(rs.getString(4));
            	c.setGroup(rs.getString(5));
            	c.setGender(rs.getString(6));
            	c.setType(rs.getString(7));
            	c.setDay(rs.getNString(8));
            	c.setMail(rs.getString(9));
            	
            		dogs.add(c);
            	
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("getDogsOwner");
        }
		
		return dogs;
	}    
	
	public static ArrayList<RegistrationBean>  getBreedNames(String breed) {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            String q="Select * from myDogs where breed='"+breed+"'";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numColumns = rsmd.getColumnCount();
            
            while(rs.next()) {
            	RegistrationBean c = new RegistrationBean();
            	c.setNumber(rs.getInt(1));
            	c.setName(rs.getString(2));
            	c.setOwner(rs.getString(3));
            	c.setBreed(rs.getString(4));
            	c.setGroup(rs.getString(5));
            	c.setType(rs.getString(7));
            	c.setGender(rs.getString(6));
            	c.setDay(rs.getString(8));
            	c.setMail(rs.getString(9));
            		dogs.add(c);
            	
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("getDogsBreed");
        }
		
		return dogs;
	}    
	public static ArrayList<Awards>  getAwards(String prize) {
		ArrayList<Awards> dogs = new ArrayList<Awards>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            String q="Select * from myAwards where awards ='"+prize+"'";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numColumns = rsmd.getColumnCount();
            
            while(rs.next()) {
            	Awards c = new Awards();
            	c.setNumber(rs.getInt(1));
            	c.setName(rs.getString(2));
            	c.setDay(rs.getString(3));
            	c.setAwards(rs.getString(4));
            		dogs.add(c);
            	
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("getDogsBreed");
        }
		
		return dogs;
	}    
	
	
	public static ArrayList<RegistrationBean>  getDogsShow(String day) {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
            
            String q="Select * from myDogs where day='"+day+"'";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numColumns = rsmd.getColumnCount();
            
            while(rs.next()) {
            	RegistrationBean c = new RegistrationBean();
            	c.setNumber(rs.getInt(1));
            	c.setName(rs.getString(2));
            	c.setOwner(rs.getString(3));
            	c.setBreed(rs.getString(4));
            	c.setGroup(rs.getString(5));
            	c.setType(rs.getString(7));
            	c.setGender(rs.getString(6));
            	c.setDay(rs.getString(8));
            	c.setMail(rs.getString(9));
            		dogs.add(c);
            	
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("getDogsShows");
        }
		
		return dogs;
	}    
	
	
	/*public static void SendMail() {
		// Recipient's email ID needs to be mentioned.
	      String to = "abcd@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "web@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         
	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText("This is actual message");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   
	}*/
	public static void  DeleteDog(int number) {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		
		try 
	     {  
			Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
             String q="delete from myDogs where id='"+number+"'";
	           Statement st = conn.createStatement();
	           st.executeUpdate(q);

	            
	     }
	     catch(Exception e)
	     {
	         System.out.println(e);
	     }
	          System.out.println("Records Delete Successfully....");
	}
	public static void  EditDog(int number, RegistrationBean c ) {
		ArrayList<RegistrationBean> dogs = new ArrayList<RegistrationBean>();
		
		
		try 
	     {  
			Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/assignment", "root", "123456");
             String q= " update  myDogs set name = ?, owner = ?, breed = ?, groupType = ?, gender = ?, type = ?, day = ?, mail = ? where id = ?";
             		
             		PreparedStatement preparedStmt = conn.prepareStatement(q);
    
             	      preparedStmt.setString(1, c.getName());
             	      preparedStmt.setString(2, c.getOwner());
             	     preparedStmt.setString(3, c.getBreed());
            	      preparedStmt.setString(4, c.getGroup());
            	      preparedStmt.setString(5, c.getGender());
            	      preparedStmt.setString(6, c.getType());
            	      preparedStmt.setString(7, c.getDay());
            	      preparedStmt.setInt(9, number);
            	      preparedStmt.setString(8, c.getMail());
             	     preparedStmt.executeUpdate();

	            
	     }
	     catch(Exception e)
	     {
	         System.out.println(e);
	     }
	          System.out.println("Records Delete Successfully....");
	}
}
	          
	          

