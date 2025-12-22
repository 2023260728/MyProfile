package com.myprofile.servlet;

import com.myprofile.bean.ProfileBean;
import com.myprofile.util.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    // =========================
    // HANDLE FORM SUBMISSION
    // =========================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1️⃣ Get form data
        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String selfIntroduction = request.getParameter("selfIntroduction");

        // 2️⃣ Create JavaBean
        ProfileBean profile = new ProfileBean();
        profile.setName(name);
        profile.setStudentId(studentId);
        profile.setProgram(program);
        profile.setEmail(email);
        profile.setHobbies(hobbies);
        profile.setSelfIntroduction(
                selfIntroduction == null || selfIntroduction.trim().isEmpty()
                        ? "N/A"
                        : selfIntroduction
        );

        Connection con = null;
        PreparedStatement ps = null;
        String message;

        try {
            con = DBConnection.getConnection();

            // 3️⃣ Prevent duplicate Student ID
            String checkSQL = "SELECT 1 FROM APP.PROFILES WHERE STUDENTID = ?";
            PreparedStatement checkPs = con.prepareStatement(checkSQL);
            checkPs.setString(1, studentId);
            ResultSet checkRs = checkPs.executeQuery();

            if (checkRs.next()) {
                message = "Student ID already exists. Please use a different Student ID.";
                request.setAttribute("profileSaveSuccess", false);
                request.setAttribute("profileBean", profile);
                request.setAttribute("saveMessage", message);

                checkRs.close();
                checkPs.close();

                request.getRequestDispatcher("profile.jsp").forward(request, response);
                return;
            }

            checkRs.close();
            checkPs.close();

            // 4️⃣ Insert profile
            String sql =
                "INSERT INTO APP.PROFILES " +
                "(NAME, STUDENTID, PROGRAM, EMAIL, HOBBIES, SELFINTRODUCTION) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, profile.getName());
            ps.setString(2, profile.getStudentId());
            ps.setString(3, profile.getProgram());
            ps.setString(4, profile.getEmail());
            ps.setString(5, profile.getHobbies());
            ps.setString(6, profile.getSelfIntroduction());

            ps.executeUpdate();

            message = "Profile saved successfully!";
            request.setAttribute("profileSaveSuccess", true);

        } catch (Exception e) {
            message = "Database error occurred. Please try again.";
            request.setAttribute("profileSaveSuccess", false);
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) {}
            DBConnection.closeConnection(con);
        }

        request.setAttribute("profileBean", profile);
        request.setAttribute("saveMessage", message);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    // =========================
    // HANDLE GET REQUESTS
    // =========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("viewAll".equals(action)) {
            viewAllProfiles(request, response);
        } else if ("search".equals(action)) {
            searchProfiles(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }

    // =========================
    // VIEW ALL PROFILES
    // =========================
    private void viewAllProfiles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ProfileBean> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement("SELECT * FROM APP.PROFILES ORDER BY ID");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProfileBean p = new ProfileBean();
                p.setId(rs.getInt("ID"));
                p.setName(rs.getString("NAME"));
                p.setStudentId(rs.getString("STUDENTID"));
                p.setProgram(rs.getString("PROGRAM"));
                p.setEmail(rs.getString("EMAIL"));
                p.setHobbies(rs.getString("HOBBIES"));
                p.setSelfIntroduction(rs.getString("SELFINTRODUCTION"));
                list.add(p);
            }

            request.setAttribute("profileList", list);

        } catch (Exception e) {
            request.setAttribute("errorMessage", "Unable to retrieve profiles.");
        }

        request.getRequestDispatcher("viewProfiles.jsp").forward(request, response);
    }

    // =========================
    // SEARCH PROFILE (UNIQUE FEATURE)
    // =========================
    private void searchProfiles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        ArrayList<ProfileBean> list = new ArrayList<>();

        String sql =
            "SELECT * FROM APP.PROFILES " +
            "WHERE STUDENTID LIKE ? OR LOWER(NAME) LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword.toLowerCase() + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProfileBean p = new ProfileBean();
                p.setId(rs.getInt("ID"));
                p.setName(rs.getString("NAME"));
                p.setStudentId(rs.getString("STUDENTID"));
                p.setProgram(rs.getString("PROGRAM"));
                p.setEmail(rs.getString("EMAIL"));
                p.setHobbies(rs.getString("HOBBIES"));
                p.setSelfIntroduction(rs.getString("SELFINTRODUCTION"));
                list.add(p);
            }

            request.setAttribute("profileList", list);

            if (list.isEmpty()) {
                request.setAttribute("errorMessage", "No matching profile found.");
            }

        } catch (Exception e) {
            request.setAttribute("errorMessage", "Search failed.");
        }

        request.getRequestDispatcher("viewProfiles.jsp").forward(request, response);
    }
}
