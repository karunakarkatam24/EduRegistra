<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-weight: bold;
            display: block;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-group input[type="text"]::before {
            content: "📚";
            display: inline-block;
            padding-right: 5px;
        }

        .form-group input[type="text"]::after {
            content: "🔢";
            display: inline-block;
            padding-right: 5px;
        }

        .form-group input[type="text"]::after {
            content: "👨‍🏫";
            display: inline-block;
            padding-right: 5px;
        }

        .btn {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
    <div class="container">
        <h2>Course Registration Form</h2>
        <form method="post" action="insertcourse">
            <div class="form-group">
                <label for="courseName">Course Name</label>
                <input type="text" id="courseName" name="courseName" placeholder="Enter course name">
            </div>

            <div class="form-group">
                <label for="courseCode">Course Code</label>
                <input type="text" id="courseCode" name="courseCode" placeholder="Enter course code">
            </div>

            <div class="form-group">
                <label for="facultyName">Faculty Name</label>
                <input type="text" id="facultyName" name="facultyName" placeholder="Enter faculty name">
            </div>

            <button type="submit" class="btn">Submit</button>
        </form>
    </div>
</body>
</html>
    