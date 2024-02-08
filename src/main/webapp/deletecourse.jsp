<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
 <!DOCTYPE html>

<html>

<head>

 <title>Table layout</title>

 <link rel="stylesheet" href="style/main.css">
 
<style>
@import url('https://fonts.googleapis.com/css?family=Montserrat|Open+Sans|Roboto');
*{
 margin:0;
 padding: 0;
 outline: 0;
}
.filter{
 position: absolute;
 left: 20;
 top: 20;
 bottom: 0;
 right: 0;
 z-index: 1;



}
table{
 position: absolute;
 z-index: 2;
 left: 50%;
 top: 50%;
 transform: translate(-50%,-50%);
 width: 60%; 
 border-collapse: collapse;
 border-spacing: 0;
 box-shadow: 0 2px 15px rgba(64,64,64,.7);
 border-radius: 12px 12px 0 0;
 overflow: hidden;

}
td , th{
 padding: 15px 20px;
 text-align: center;
 

}
th{
 background-color: #ba68c8;
 color: #fafafa;
 font-family: 'Open Sans',Sans-serif;
 font-weight: 200;
 text-transform: uppercase;

}
tr{
 width: 100%;
 background-color: #fafafa;
 font-family: 'Montserrat', sans-serif;
}
tr:nth-child(even){
 background-color: #eeeeee;
}
body {font-family: Arial, Helvetica, sans-serif;}

.navbar {
  width: 100%;
  background-color: #555;
  overflow: auto;
}

.navbar a {
  float: left;
  padding: 12px;
  color: white;
  text-decoration: none;
  font-size: 17px;
}

.navbar a:hover {
  background-color: #000;
}

.active {
  background-color: #04AA6D;
}

@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
  }
}
</style>
</head>

<body>
 

  <div class="filter">

 </div>

 <table >

 




  <tr>

 <td>ID</td>

 <td>COURSE NAME</td>

 <td>COURSE CODE</td>

 <td>FACULTY NAME</td>

 
 <td>ACTION</td>
 

 <c:forEach items="${empdata}"  var="course"> 
<tr> 
<td><c:out value="${course.id}" /></td> 
<td><c:out value="${course.coursename}" /></td> 
<td><c:out value="${course.coursecode}" /></td> 
<td><c:out value="${course.facultyename}" /></td> 

<td>
<a href='<c:url value="deletecourse/${course.id}"></c:url>'>Delete</a>
</td>
 
</tr> 
</c:forEach> 

 </table>
<div class="navbar">
  <a class="active" href="adminhome"><i class="fa fa-fw fa-home"></i> Home</a> &nbsp; 
  <a  href="viewallemps"><i class="fa fa-fw fa-home"></i> View All Students</a>&nbsp;
    <a href="empreg"><i class="fa fa-fw fa-envelope"></i>Add Student</a> 
    <a href="addcourse.jsp"><i class="fa fa-fw fa-envelope"></i>Add Course</a> 
  <a href="deleteemp"><i class="fa fa-fw fa-envelope"></i>Delete Students</a> 
  <a href="deletecourse"><i class="fa fa-fw fa-envelope"></i>Delete Course</a> 
  <a href="emplogin.jsp"><i class="fa fa-fw fa-user"></i> Logout</a>
</div>

 </body>

</html>