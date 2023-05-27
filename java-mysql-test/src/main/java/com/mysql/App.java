package com.mysql;


import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        ReadCsv data = new ReadCsv();
        data.read();
        System.out.println("File has been read");
        try {
            MyConnection mc = new MyConnection();
            Statement stmt = mc.getConnection().createStatement();
            System.out.println("Work in progress");
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
