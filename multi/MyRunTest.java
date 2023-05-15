package multi;

public class MyRunTest implements Runnable{
    public String name;
    public int pause;
    public int count;
    @Override
    public void run() {
        for (int i = 0; i < count; ++i) {
            System.out.println(i+ "-> From MyRunTest::thread():" + name);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public MyRunTest(String name, int pause, int count) {
        this.name = name;
        this.pause = pause;
        this.count = count;
    }

    public static void main(String[] args) {
        Runnable r1 = new MyRunTest("r1", 100, 200);
        Runnable r2 = new MyRunTest("r2", 150, 300);

        new Thread(r1).start();
        new  Thread(r2).start();

    }

}
