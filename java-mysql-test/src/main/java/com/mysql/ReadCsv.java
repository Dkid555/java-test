package com.mysql;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadCsv {
    ArrayList<String[]> file = new ArrayList<>();
    String path = new String();

    public void read() {
        System.out.println("Input Path to csv file: ");
        Scanner p = new Scanner(System.in);
        if (p.hasNextLine()) {
            this.path = p.nextLine();
        } else {
            this.path = String.valueOf(p);
        }
        try {
            Scanner sc = new Scanner(new File(this.path));
            sc.useDelimiter(",");
            sc.nextLine();
            while (sc.hasNextLine()) {
                file.add(sc.nextLine().split(","));
//                System.out.println("hello");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
