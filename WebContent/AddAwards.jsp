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

Number: <input type="text" name="id"><br>
Name: <input type="text" name="name"><br>

  Select the awards for dog<br>
 <input type="checkbox" name="awards" value="bestOfBreed">  Best Of Breed<br>
 <input type="checkbox" name="awards" value="reserveWinner"> Reserve Winner <br>
 <input type="checkbox" name="awards" value="bestOfOppositeSex">Best Of Opposite Sex<br>
 <input type="checkbox" name="awards" value="firstInGroup"> First In Group <br>
 <input type="checkbox" name="awards" value="secondInGroup"> Second In Group <br>
 <input type="checkbox" name="awards" value="thirdInGroup"> Third In Group <br>
  <input type="checkbox" name="awards" value="fourthInGroup"> Fourth In Group <br>
  <input type="checkbox" name="awards" value="bestInShow"> Best In Show <br>
  

 Select the show day for your dog<br>
 Friday:<input type="radio" name="day" value="Friday"><br>
 Saturday:<input type="radio" name="day" value="Saturday"><br>
  Sunday:<input type="radio" name="day" value="Sunday"><br>
 
<input type="submit" value="Add Winners">
</form>

<form action="DisplayAward" method="get">
<select name="prize">
  <option value="bestOfBreed"> Best Of Breed</option>
  <option value="reserveWinner">Reserve Winner </option>
  <option value="bestOfOppositeSex">Best Of Opposite Sex</option>
  <option value="firstInGroup"> First In Group</option>
  <option value="secondInGroup">Second In Group </option>
  <option value="thirdInGroup">Third In Group</option>
  <option value="fourthInGroup">Fourth In Group </option>
  <option value="bestInShow">Best In Show</option>
  
 </select>
<input type="submit" value="Display Winners">
</form>
</body>
</html>