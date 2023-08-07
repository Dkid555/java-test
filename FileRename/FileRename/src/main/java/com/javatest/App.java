package com.javatest;

import com.hiber.ReadCsv;

import java.io.File;

public class App {

    public static void main(String[] args) {
        ReadCsv Data = new ReadCsv();
        Data.read();
        for (String[] strings : Data.file) {
            File file = new File(strings[0]);

            // Create an object of the File class
            // Replace the file path with path of the directory
            File rename = new File(strings[1]);

            // store the return value of renameTo() method in
            // flag
            boolean flag = file.renameTo(rename);

            // if renameTo() return true then if block is
            // executed
            if (flag) {
                System.out.println("File Successfully Rename");
            }
            // if renameTo() return false then else block is
            // executed
            else {
                System.out.println("Operation Failed");
            }
        }
    }
}

