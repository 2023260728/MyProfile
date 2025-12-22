<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.myprofile.bean.ProfileBean" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile List</title>
    <link rel="stylesheet" href="css/style.css">

    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7fa;
            padding: 20px;
            color: #333;
        }
        h1 {
            text-align: center;
            color: #007bff;
        }
        table {
            width: 100%;
            max-width: 900px;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            border-bottom: 1px solid #e0e0e0;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        .message {
            text-align: center;
            font-weight: bold;
            color: #dc3545;
            margin-top: 20px;
        }
        .back-button {
            display: block;
            width: fit-content;
            margin: 20px auto;
            padding: 10px 25px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 8px;
        }
        .back-button:hover {
            background-color: #5a6268;
        }
    </style>
</head>

<body>

<%
    ArrayList<ProfileBean> profileList =
            (ArrayList<ProfileBean>) request.getAttribute("profileList");

    String errorMessage = (String) request.getAttribute("errorMessage");
    String pageTitle = (String) request.getAttribute("pageTitle");

    if (pageTitle == null) {
        pageTitle = "All Profiles";
    }
%>

<h1><%= pageTitle %></h1>

<% if (errorMessage != null) { %>

    <p class="message"><%= errorMessage %></p>

<% } else if (profileList == null || profileList.isEmpty()) { %>

    <p class="message">No profiles found.</p>

<% } else { %>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Student ID</th>
        <th>Program</th>
        <th>Email</th>
        <th>Hobbies</th>
        <th>Self-Introduction</th>
    </tr>

    <% for (ProfileBean p : profileList) { %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getStudentId() %></td>
            <td><%= p.getProgram() %></td>
            <td><%= p.getEmail() %></td>
            <td><%= p.getHobbies() %></td>
            <td><%= p.getSelfIntroduction() %></td>
        </tr>
    <% } %>
</table>

<% } %>

<a href="index.html" class="back-button">Back to Home</a>

</body>
</html>
