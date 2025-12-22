<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.myprofile.bean.ProfileBean"%> <%-- IMPORTANT: Add this line to import your ProfileBean class --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Profile</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Re-use your stylesheet for consistency -->
    <style>
        /* Specific styles for the display page if needed, or override existing ones */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7fa;
            margin: 0;
            padding: 20px;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: flex-start; /* Align to the top */
            min-height: 100vh;
        }
        .profile-card {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            margin: 30px auto; /* Center the card with some top margin */
            box-sizing: border-box;
            border: 1px solid #e0e0e0;
        }
        .profile-card h1 {
            color: #007bff;
            margin-bottom: 25px;
            font-size: 2.5em;
            text-align: center;
        }
        /* Style for the save message */
        .message {
            text-align: center;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 8px;
            font-weight: bold;
            color: white;
        }
        .message.success {
            background-color: #28a745; /* Green for success */
        }
        .message.error {
            background-color: #dc3545; /* Red for error */
        }
        .message.warning {
            background-color: #ffc107; /* Orange for warnings */
            color: #333; /* Darker text for warning */
        }

        /* COMBINED AND CORRECTED .profile-item RULE */
        .profile-item {
            display: flex; /* CRITICAL for side-by-side alignment */
            margin-bottom: 15px; /* Space between each item */
            padding: 10px 0; /* Padding inside the item, top/bottom */
            border-bottom: 1px dashed #e0e0e0; /* Subtle separator line */
            flex-wrap: wrap; /* Allows text to wrap to the next line */
            align-items: baseline; /* Aligns items on the same baseline */
        }
        .profile-item:last-child {
            border-bottom: none; /* No border for the last item */
        }
        .profile-item strong {
            color: #007bff; /* Blue for category names */
            width: 170px; /* Adjust this width as needed for alignment */
            text-align: right; /* Aligns label text to the right within its width */
            flex-shrink: 0; /* Prevents the label from shrinking */
            padding-right: 15px; /* Space between label and value */
        }
        .profile-item span {
            color: #444;
            line-height: 1.5;
            flex-grow: 1; /* Makes the span take up the remaining space */
            word-break: break-word; /* Prevents long words from overflowing */
        }

        .back-button {
            display: block;
            width: fit-content;
            margin: 30px auto 0;
            padding: 12px 25px;
            background-color: #6c757d; /* Gray for back button */
            color: white !important; /* Force white text */
            border: none;
            border-radius: 8px;
            font-size: 1em;
            font-weight: 500;
            cursor: pointer;
            text-decoration: none !important; /* Force no underline */
            transition: background-color 0.3s ease, transform 0.2s ease;
            -webkit-appearance: none; /* For cross-browser button styling consistency */
            -moz-appearance: none;
            appearance: none;
        }
        .back-button:hover {
            background-color: #5a6268;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>
    <div class="profile-card">
        <h1>My Personal Profile</h1>

        <%
            // Retrieve the ProfileBean object from the request scope
            ProfileBean profile = (ProfileBean) request.getAttribute("profileBean");
            String saveMessage = (String) request.getAttribute("saveMessage");
            Boolean profileSaveSuccess = (Boolean) request.getAttribute("profileSaveSuccess");
        %>

        <%-- Display save message if available --%>
        <% if (saveMessage != null && !saveMessage.isEmpty()) { %>
            <p class="message <%= (profileSaveSuccess != null && profileSaveSuccess) ? "success" : "error" %>">
                <%= saveMessage %>
            </p>
        <% } %>


        <% if (profile != null) { %>
            <div class="profile-item">
                <strong>Name:</strong> <span><%= profile.getName() != null ? profile.getName() : "N/A" %></span>
            </div>

            <div class="profile-item">
                <strong>Student ID:</strong> <span><%= profile.getStudentId() != null ? profile.getStudentId() : "N/A" %></span>
            </div>

            <div class="profile-item">
                <strong>Program:</strong> <span><%= profile.getProgram() != null ? profile.getProgram() : "N/A" %></span>
            </div>

            <div class="profile-item">
                <strong>Email:</strong> <span><%= profile.getEmail() != null ? profile.getEmail() : "N/A" %></span>
            </div>

            <div class="profile-item">
                <strong>Hobbies:</strong> <span><%= profile.getHobbies() != null ? profile.getHobbies() : "N/A" %></span>
            </div>

            <div class="profile-item">
                <strong>Self-Introduction:</strong> <span><%= profile.getSelfIntroduction() != null ? profile.getSelfIntroduction() : "N/A" %></span>
            </div>
        <% } else { %>
            <p class="message warning">No profile data found to display. Please submit a profile first.</p>
        <% } %>

        <a href="index.html" class="back-button">Go Back to Form</a>

    </div> <!-- Closing div for profile-card -->
</body>
</html>