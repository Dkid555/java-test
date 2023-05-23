package sql;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



public class ReadCSV {
    ArrayList<String[]> file = new ArrayList<>();

    public void read() {
        System.out.println("Input Path to csv file: ");
        Scanner p = new Scanner(System.in);

        String path = p.nextLine();
        try {
            Scanner sc = new Scanner(new File(path));
            sc.useDelimiter(",");
            sc.nextLine();
            while (sc.hasNext()) {
                file.add(sc.nextLine().split(","));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
