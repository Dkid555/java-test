package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySqlConTiles {
    public static void main(String args[]) {

        ReadCSV data = new ReadCSV();
        data.read();

        try  {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/test_db", "root", "root");
            MyConnection mc = new MyConnection();


            Statement stmt = mc.getConnection().createStatement();
            int i = 0;
            while (i < data.file.size()){
                String Query = "insert into Tiles values("  + data.file.get(i)[0]
                        + ",'" + data.file.get(i)[1] + "','"
                        + data.file.get(i)[2] + "','"
                        + data.file.get(i)[3] + "','"
                        + data.file.get(i)[4] + "','"
                        + data.file.get(i)[5] + "',"
                        + data.file.get(i)[6] + ","
                        + data.file.get(i)[7] + ","+
                        data.file.get(i)[8] + ",'"
                        +data.file.get(i)[9] + "','"
                        + data.file.get(i)[10] + "',"
                        + data.file.get(i)[11] + ","
                        + data.file.get(i)[12]+ ",'"
                        + data.file.get(i)[13] + "',"
                        + data.file.get(i)[14] + ",'"
                        + data.file.get(i)[15] + "','"
                        + data.file.get(i)[16]+"','"
                        + data.file.get(i)[17]+"','"
                        + data.file.get(i)[18]+"','"
                        + data.file.get(i)[19]+"','"
                        + data.file.get(i)[20]+"','"
                        + data.file.get(i)[21]+"','"
                        + data.file.get(i)[22]+"','"
                        + data.file.get(i)[23]+"')";
                stmt.executeUpdate(Query);
                ++i;
            }
            mc.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
