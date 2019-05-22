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
<h3>Awards the dogs by</h3>
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
	<table>
<tr>
<td>Number</td>
<td>Name</td>
<td>DAY</td>
<td>AWARDS</td>

</tr>
<c:forEach items="${dogs}" var="play">
<tr>
<td>${play.number}</td>
<td>${play.name}</td>
<td>${play.day}</td>
<td>${play.awards}</td>

</tr>
</c:forEach>
</table>
</body>
</html>