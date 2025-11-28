<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Profile</title>
    <!-- Link to your stylesheet -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Your Personal Profile</h1>
        <div class="profile-details">
            <p><strong>Name:</strong> <%= request.getAttribute("userName") %></p>
            <p><strong>Student ID:</strong> <%= request.getAttribute("userStudentId") %></p>
            <p><strong>Program:</strong> <%= request.getAttribute("userProgram") %></p>
            <p><strong>Email:</strong> <%= request.getAttribute("userEmail") %></p>
            <p><strong>Hobbies:</strong> <%= request.getAttribute("userHobbies") %></p>
            <h3>About Me:</h3>
            <p class="self-intro-text"><%= request.getAttribute("userSelfIntro") %></p>
        </div>
        <p class="back-link"><a href="index.html">Create another profile</a></p>
    </div>
</body>
</html>
