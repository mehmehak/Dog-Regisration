<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<style>
h1{
text-align: center;
font-size: 35px
}
body{
background: papayawhip;

}
form {
    width: 100%;
     background-color: saddlebrown;
    color: white;
    font-size: 20px;
    background-image: url("dog.jpeg");
    font-style: oblique;
    font-family: "Times New Roman", Times, serif;
}
input[type=submit] {
    background-color: navajowhite;
    color: black;
    border: 2px solid sienna; 
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 12px;
}
</style>
<h1>Dog Registration Form</h1>
<form action="GetAwards" method="get">

ID: <input type="text" name="name"><br>
Name: <input type="text" name="name"><br>
Select the Breed of the dog<br>
<select name="breed">
  <option value="labrador">Labrador Retrivers</option>
  <option value="shepherd">German Shepherd</option>
  <option value="retrivers">Golden Retrievers</option>
  <option value="french">French Bulldogs</option>
  <option value="bulldogs">Bulldogs</option>
  <option value="beagles">Beagles</option>
  <option value="poodles">Poodles</option>
  <option value="rottweilers">Rottweilers</option>
  <option value="boxer">Boxers</option>
</select>
  Select the group for your dog<br>
 Group1:<input type="radio" name="group" value="sporting"> Sporting Dogs<br>
 Group2:<input type="radio" name="group" value="hounds"> Hounds <br>
  Group3:<input type="radio" name="group" value="working"> Working Dogs<br>
 Group4: <input type="radio" name="group" value="terriers"> Terriers <br>
  Group5:<input type="radio" name="group" value="toys"> Toys <br>
 Group6: <input type="radio" name="group" value="nonsporting"> Non-Sporting <br>
  Group7:<input type="radio" name="group" value="herding"> Herding <br>
  Gender:
<select name="gen">
  <option value="male">Male</option>
  <option value="female">Female</option>
</select>
<br>
Class/Speciality Dog:
<input type="radio" name="type" value="class"> Class Dog <br>
<input type="radio" name="type" value="speciality"> Speciality Dog <br>
<br>
 Select the show day for your dog<br>
 Friday:<input type="radio" name="day" value="Friday"><br>
 Saturday:<input type="radio" name="day" value="Saturday"><br>
  Sunday:<input type="radio" name="day" value="Sunday"><br>
 
Select the awards for  dog<br>
 <input type="checkbox" name="award" value="Best of Breed"> Best of Breed<br>
 <input type="checkbox" name="award" value="Reserve Winners"> Reserve Winners <br>
 <input type="checkbox" name="award" value="Best of Opposite Sex"> Best of Opposite Sex<br>
 <input type="checkbox" name="award" value="First in Group"> First in Group <br>
 <input type="checkbox" name="award" value="Second in Group"> Second in Group <br>
 <input type="checkbox" name="award" value="Third in group"> Third in group <br>
 <input type="checkbox" name="award" value="Fourth in Group"> Fourth in Group <br>
 <input type="checkbox" name="award" value="Best in show"> Best in show <br>
 
<input type="submit" value="Submit">
</form>

</body>
</html>