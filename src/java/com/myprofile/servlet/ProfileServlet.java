/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprofile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
// Note: If you did NOT tick the 'web.xml' checkbox in the New Servlet wizard,
// you would need to uncomment the following line:
// import javax.servlet.annotation.WebServlet;

// If you did NOT tick the 'web.xml' checkbox in the New Servlet wizard,
// you would need to uncomment the following line:
// @WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    /**
     * This method will handle both GET and POST requests.
     * For this assignment, we primarily expect POST from the form.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Retrieve form parameters (names must match 'name' attributes in index.html)
        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String selfIntro = request.getParameter("introduction");
       

        // Store the retrieved data as attributes in the request object.
        // These attributes will be available in the JSP.
        request.setAttribute("userName", name);
        request.setAttribute("userStudentId", studentId);
        request.setAttribute("userProgram", program);
        request.setAttribute("userEmail", email);
        request.setAttribute("userHobbies", hobbies);
        request.setAttribute("userSelfIntro", selfIntro);

        // Forward the request and response to the profileDisplay.jsp page.
        // The JSP will then use the attributes we just set.
        request.getRequestDispatcher("profileDisplay.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // For this assignment, if a GET request comes, we'll just process it
        // which will likely mean blank fields displayed, or you could redirect to the form:
        // response.sendRedirect("index.html");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // All POST requests go to processRequest
    }
     /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Profile Servlet for displaying user information";
    }// </editor-fold>

}
