<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.assignment.bean.*" %>
            <%@ page import="com.assignment.servlets.*" %>
            <%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
 <%@ page import="com.assignment.bean.*" %>
            <%@ page import="com.assignment.servlets.*" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
</head>
<table>
<tr>
<td>Number</td>
<td>Breed</td>
<td>Male Class</td>
<td>Female Class</td>
<td>Male Speciality</td>
<td>Female Speciality</td>

</tr>
<c:forEach items="${dogs}" var="play">
<tr>
<td>${play.number}</td>
<td>${play.breeds}</td>
<td>${play.maleClass}</td>
<td>${play.femaleClass}</td>
<td>${play.maleSpecial}</td>
<td>${play.femaleSpecial}</td>

</tr>
</c:forEach>
</table>
</body>
</html>