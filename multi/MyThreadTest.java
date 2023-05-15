package multi;

public class MyThreadTest extends Thread {
    public String name;
    public int pause;
    public int count;
    @Override
    public void run() {
        for (int i = 0; i < count; ++i) {
            System.out.println(i+ "-> From thread:" + name);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public MyThreadTest(){
        this.name = null;
        this.count = 0;
        this.pause = 0;

    }
    public MyThreadTest(String name, int pause, int count){
        this.name = name;
        this.count = count;
        this.pause = pause;

    }

    public static void main(String[] args) throws InterruptedException {

        MyThreadTest t1 = new MyThreadTest();
        t1.name = "t1";
        t1.count = 10;
        t1.pause = 50;

        MyThreadTest t2 = new MyThreadTest();
        t2.name = "t2";
        t2.count = 20;
        t2.pause = 75;
        MyThreadTest t3 = new MyThreadTest("t3", 30, 100);

        t1.start();
        sleep(1000);
        t2.start();
        sleep(1000);
        t3.start();
        sleep(1000);

    }
}
