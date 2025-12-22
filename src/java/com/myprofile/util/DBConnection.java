package com.myprofile.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String URL = "jdbc:derby:student_profiles;create=true";

    public static Connection getConnection()
            throws SQLException, ClassNotFoundException {

        Class.forName(DRIVER);
        return DriverManager.getConnection(URL);
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
