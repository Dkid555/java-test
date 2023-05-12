package oop;

public class InterTest implements Interface{
    public static void main(String[] args) {
        Interface i = new InterTest();
        i.test();
        i.test2();

        Interface i1 = new Interface() {
            @Override
            public void test() {
                System.out.println("from i2");
            }

            @Override
            public void test2() {
                System.out.println("test3");
            }
        };
        i1.test();
        i1.test2();
    }

    @Override
    public void test() {
        System.out.println("implement test");
    }

    @Override
    public void test2() {
        System.out.println("test2");
    }
}
