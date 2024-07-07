package com.javatest.oop;


// not allows to extend it because - class aa is final
public class Final_test {
    final String string = "final";
}

final class aa {
    public static void main(String[] args) {
        Final_test test = new Final_test();
        // not allows to change because it's final
//        test.string = "changed";

    }
}

