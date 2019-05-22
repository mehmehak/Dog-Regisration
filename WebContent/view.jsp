<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.assignment.bean.*" %>
            <%@ page import="com.assignment.servlets.*" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            
            
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Search the dogs by</h3>
<style>
h3{
text-align: center;
font-size: 35px
}
body{

 background-image: url("dog.jpeg");
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    background: papayawhip;
}
form {
   
     background-color: saddlebrown;
    color: white;
    font-size: 20px;
   
    font-style: oblique;
    font-family: "Times New Roman", Times, serif;
}
input[type=submit] {
    background-color: navajowhite;
    color: black;
    border: 2px solid sienna; 
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 12px;
    display: inline-block;
}
</style>
<form action="GetName" method="get">
Name: <input type="search" name="searchName">
<input type ="submit" value="submit">
</form>
<form action="GetOwner" method="get">
Owner Name: <input type="search" name="searchOwner">
<input type ="submit" value="submit">
</form>
<form action="GetNumber" method="get">
Number: <input type="search" name="searchNumber">
<input type ="submit" value="submit">
</form>
<form action="GetGroup" method="get">
Group Name: <input type="search" name="group">
<input type ="submit" value="submit">
</form>
<form action="GetShow" method="get">
<select name="day">
  <option value="Friday">Friday</option>
  <option value="Saturday">Saturday</option>
  <option value="Sunday">Sunday</option>
</select>
<input type ="submit" value="submit">
</form>
<form action="GetBreed" method="get">
Breed Name: <input type="search" name="breed">
<input type ="submit" value="submit">
</form><br>
	<table>
<tr>
<td>Number</td>
<td>Name</td>
<td>OWNER NAME</td>
<td>BREED</td>
<td>GROUP</td>
<td>GENDER</td>
<td>TYPE</td>
</tr>
<c:forEach items="${dogs}" var="play">
<tr>
<td>${play.number}</td>
<td>${play.name}</td>
<td>${play.owner}</td>
<td>${play.breed}</td>
<td>${play.group}</td>
<td>${play.gender}</td>
<td>${play.type}</td>
</tr>
</c:forEach>
</table>
</body>
</html>