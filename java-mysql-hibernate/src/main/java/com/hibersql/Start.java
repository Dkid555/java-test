package com.hibersql;


import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        while (true) {
            System.out.println("to Display entity: input - d");
            System.out.println("to Add csv: input - a");
            System.out.println("to Erase by id: input - e");
            System.out.println("to Exit: input - t");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if (s.equals("d")) {
                new tilesHelper().getTilesList();
            } else if (s.equals("t")) break;
            else if (s.equals("a")) {
                ReadCsv Data = new ReadCsv();
                Data.read();
                new tilesHelper().addCsv(Data.newOnes);
            } else if (s.equals("e")) {
                System.out.println("Input ID: ");
                Scanner val = new Scanner(System.in);
                new tilesHelper().deleteBy((val.nextLine()));
            }

        }
    }
}
