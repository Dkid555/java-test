package com.lang;

public class MyTestClass implements MyInterface {
    @Override
    public int test(int i) {
        System.out.println("from MyTestInterface " + i);
        return 0;
    }

    public static void main(String[] args) {
        MyInterface o = new MyTestClass();
        o.test(1);

        o = new MyTestClass1();
        o.test(2);
    }
}

class MyTestClass1 implements MyInterface {

    @Override
    public int test(int i) {
        System.out.println("from MyTestInterface1 " + i);
        return 1;
    }
}
