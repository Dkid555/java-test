package data;

import java.sql.*;

class MysqlCon {
    public static void main(String args[]) {

        int a = 2;
        String[] s = new String[]{"Jackon", "Michael", "Town Dr", "Los Angeles"};
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test_db", "root", "root");
//here test_db is database name, root is username and password
            Statement stmt = con.createStatement();
            String Query = "insert into Persons values(" + 2 + ",'" +s[0] + "','" + s[1] + "','" + s[2] + "','" + s[3] +"')";

            stmt.executeUpdate(Query);
            ResultSet rs = stmt.executeQuery("select * from Persons");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)
                        + " " +rs.getString(4) + " " +rs.getString(5));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
