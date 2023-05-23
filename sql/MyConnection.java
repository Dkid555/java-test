package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static String CONNECTION_STR = "jdbc:mysql://localhost:3306/test_db";
    private static String USER = "root";
    private static String PSWD = "root";

    private Connection conn;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
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
