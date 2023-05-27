package com.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/plitkazavr_db";
    private static final String USER = "root";
    private static final String PSWD = "root";

    private java.sql.Connection conn;

    public java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.jdbc.Driver
        this.conn = DriverManager.getConnection(
                CONNECTION_STR, USER, PSWD);
        return this.conn;
    }

    public void closeConnection() throws SQLException {
        if (this.conn != null) {
            this.conn.close();
        }
    }
}
