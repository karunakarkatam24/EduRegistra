<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
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




<div class="navbar">
  <a class="active" href="emphome.jsp"><i class="fa fa-fw fa-home"></i> Home</a> &nbsp;
     <a class="" href="viewallcourse"><i class="fa fa-fw fa-home"></i> Courses</a>
  <a href="updateprofile.jsp"><i class="fa fa-fw fa-envelope"></i>Update profile</a> 
  <a href="emplogin.jsp"><i class="fa fa-fw fa-user"></i> Logout</a>
</div>


</body>
</html>