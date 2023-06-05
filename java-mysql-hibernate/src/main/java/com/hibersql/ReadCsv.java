package com.hibersql;

import com.hibersql.entity.TilesEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadCsv {
    //    Stack<String[]> file = new Stack<>();
    List<TilesEntity> newOnes = new ArrayList<>();
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
                //file.add(sc.nextLine().split(","));
                String[] line = sc.nextLine().split(",");
                newOnes.add(new TilesEntity(Integer.valueOf(line[0]), line[1],
                        line[2], line[3], line[4], line[5],
                        Double.valueOf(line[6]), Double.valueOf(line[7]),
                        Double.valueOf(line[8]), line[9],
                        line[10], Integer.valueOf(line[11]),
                        Integer.valueOf(line[12]), line[13], Integer.valueOf(line[14]), line[15], line[16], line[17], line[18], line[19], line[20], line[21],
                        line[22], line[23]));
//                System.out.println("hello");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
