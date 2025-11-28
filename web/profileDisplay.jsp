<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Profile</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Re-use your stylesheet for consistency -->
    <style>
        /* Specific styles for the display page if needed, or override existing ones */
        .profile-card {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            margin: 50px auto; /* Center the card */
            box-sizing: border-box;
        }
        .profile-card h1 {
            color: #007bff;
            margin-bottom: 25px;
            font-size: 2.5em;
            text-align: center;
        }
        /* COMBINED AND CORRECTED .profile-item RULE */
    .profile-item {
        display: flex; /* CRITICAL for side-by-side alignment */
        margin-bottom: 15px; /* Space between each item */
        padding: 10px 0; /* Padding inside the item, top/bottom (from your original rule) */
        border-bottom: 1px dashed #e0e0e0; /* Subtle separator line (from your original rule) */
        flex-wrap: wrap; /* Allows text to wrap to the next line */
        align-items: baseline; /* Aligns items on the same baseline */
    }
        .profile-item:last-child {
            border-bottom: none; /* No border for the last item */
        }
        .profile-item strong {
            color: #007bff; /* Blue for category names */
            /* Remove 'display: inline-block' here. It's not needed with flexbox. */
            width: 170px; /* **THIS IS THE VALUE TO TUNE (start with 120px)** */
            text-align: right;/* Aligns label text to the right within its width */
            flex-shrink: 0; /* Prevents the label from shrinking */
            padding-right: 15px; /* Corrected from margin-right */
        }
        .profile-item span {
            color: #444;
            line-height: 1.5;
            flex-grow: 1; /* Makes the span take up the remaining space */
        }
       
          /* DELETED: .profile-item p { ... } - this rule is gone */
          
    border-bottom: none; /* No border for the last item */
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
            /* Add these for cross-browser button styling consistency */
    -webkit-appearance: none;
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

        <div class="profile-item">
            <strong>Name:</strong> <span><%= request.getAttribute("profileName") %></span>
        </div>

        <div class="profile-item">
            <strong>Student ID:</strong> <span><%= request.getAttribute("profileStudentId") %></span> 
        </div>

        <div class="profile-item">
            <strong>Program:</strong> <span><%= request.getAttribute("profileProgram") %></span>
        </div>

        <div class="profile-item">
            <strong>Email:</strong> <span><%= request.getAttribute("profileEmail") %></span>
        </div>

        <div class="profile-item">
            <strong>Hobbies:</strong> <span><%= request.getAttribute("profileHobbies") %></span>
        </div>

        <div class="profile-item">
            <strong>Self-Introduction:</strong> <span><%= request.getAttribute("profileSelfIntro") %></span>
        </div>

        <!-- Add the Go Back to Form button here, after all profile items -->
        <a href="index.html" class="back-button">Go Back to Form</a>

    </div> <!-- Closing div for profile-card -->
</body>
</html>

