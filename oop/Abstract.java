package oop;

abstract class Abstract1 {
    public void test() {}
}

public class Abstract extends Abstract1{
    public void test(){
        System.out.println("from a");
    }
    public static void main(String[] args) {
        Abstract1 a = new Abstract();
        a.test();
        a = new A2();
        a.test();
    }
}

class A2 extends Abstract1{
    public void test() {
        System.out.println("a2");
    }
}
