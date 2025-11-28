package com.example.profile; // Adjust package as needed

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet") // Maps this servlet to the URL /ProfileServlet
public class ProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Retrieve data from the HTML form
        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String selfIntro = request.getParameter("selfIntro");

        // 2. Store the data in the request scope to pass to JSP
        request.setAttribute("profileName", name);
        request.setAttribute("profileStudentId", studentId);
        request.setAttribute("profileProgram", program);
        request.setAttribute("profileEmail", email);
        request.setAttribute("profileHobbies", hobbies);
        request.setAttribute("profileSelfIntro", selfIntro);

        // 3. Forward the request to the JSP page for display
        request.getRequestDispatcher("/profileDisplay.jsp").forward(request, response);
    }
}
