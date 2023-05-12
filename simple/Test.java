package simple;

public class Test {


    public static void main(String[] args) {
        System.out.println("Hello");
        String i = "10";
        int b = 11;
        System.out.println(i + b);
        //System.out.println();
        //System.out.printf(i+b);
        //System.out.println("TwoSum.main");
        String result = (20 > 10) ? "Good" : "Bad";
        System.out.println(result);

        int a = 6;
        do {
            System.out.println("Your a: " + a);
            a--;
        } while (a >= 1);

        int z = 1;
        while(z != 10){
            System.out.println("z is: " + z);
            z += 1;
        }


        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        for (String k : cars) {
            System.out.println("\"" + k + "\"" + "\n");


        }

    }
}

