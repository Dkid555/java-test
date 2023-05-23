package sql;

import java.sql.Statement;


public class MySqlConTiles {
    public static void main(String[] args) {

        ReadCSV data = new ReadCSV();
        data.read();

        try {
            MyConnection mc = new MyConnection();
            Statement stmt = mc.getConnection().createStatement();
            int i = 0;
            while (i < data.file.size()) {
                Query que = new Query();
                que.Create(data, i);
                stmt.executeUpdate(que.getStr());
                i++;
            }
            mc.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
