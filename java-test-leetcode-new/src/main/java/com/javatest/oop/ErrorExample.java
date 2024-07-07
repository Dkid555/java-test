package com.javatest.oop;


import java.io.FileInputStream;
import java.io.IOException;

public class ErrorExample {
    private static ABC Mem;//= new ABC();

    public static void foo(String path) throws IOException { // file not found exception
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileInputStream.nullInputStream().close();
        }
    }

    public static void main(String[] args) throws Exception {
        //Runtime Exceptions
//        System.out.println(1/0); // Arithmetic Exception
//        int[] array = {1,2,3};
//        array[5] = 3; //ArrayIndexOutOfBoundsException
//        Mem.foo(); //NullPointerException

//        try {
//            Mem.foo();
//        }catch (Exception e){
//            e.printStackTrace();
//            System.err.println(e); // -> java.lang.NullPointerException: Cannot invoke "com.oop.ABC.foo()" because "com.oop.ErrorExample.Mem" is null
//        }
        //java.lang.NullPointerException: Cannot invoke "com.oop.ABC.foo()" because "com.oop.ErrorExample.Mem" is null
        //	at com.oop.ErrorExample.main(ErrorExample.java:15)
        //java.lang.NullPointerException: Cannot invoke "com.oop.ABC.foo()" because "com.oop.ErrorExample.Mem" is null
//        System.out.println(Runtime.getRuntime().exec(" echo 'hello'")); // IOException
        try {
            foo("ass"); // FileNotFoundException
            Mem.foo(); // NullPointerException
            System.out.println(1 / 0); // ArithmeticException
        } catch (NullPointerException | ArithmeticException e) {
            e.printStackTrace();
        } finally { // то что происходит в конце
            System.out.println("закрываю поток");
        }

    }
}


class ABC {
    public void foo() {
        System.out.println("LALALA");
    }

}