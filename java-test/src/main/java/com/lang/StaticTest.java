package com.lang;

public class StaticTest {
    public int i = 5;
    public static int ii = 22;

    public int getI() {
        System.out.println("from getI");
        return i;
    }

    public static int getII() {
        return ii;
    }

    public static void main(String[] args) {
        StaticTest st = new StaticTest();
        st.i = 1;

        StaticTest st2 = new StaticTest();
        st2.i = 11;

        System.out.println(st.i);
        System.out.println(st.getI());
        System.out.println(st2.i);
        System.out.println(st2.getI());

        StaticTest.ii = 2;
        System.out.println(StaticTest.ii);
        System.out.println(StaticTest.getII());
        StaticTest.ii = 5;
        System.out.println(StaticTest.ii);
        System.out.println(StaticTest.getII());


    }


}
