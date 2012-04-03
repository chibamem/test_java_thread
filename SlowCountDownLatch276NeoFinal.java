import java.util.concurrent.CountDownLatch;


public class SlowCountDownLatch276NeoFinal {

    public static void main(String args[]) throws Exception {
        final CountDownLatch c = new CountDownLatch(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (c.getCount() > 0) {
                    System.out.println(c.getCount());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    c.countDown();
                }
            }
        }).start();
        c.await();
        System.out.println("Finished!");
    }

}
