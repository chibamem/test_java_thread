
public class SlowCountDownLatch276Neo {

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

    public static class CountDownLatch {
	    private int count;

	    public CountDownLatch(int count) {
	        if (count < 0)
	            throw new IllegalArgumentException(count + " < 0");
	        this.count = count;
	    }

	    public void await() throws InterruptedException {
	        while (true) {
	            synchronized (this) {
	                if (count == 0) return;
                    wait(100);
	            }
	        }
	    }

	    public synchronized void countDown() {
	        if (count != 0) {
	            count--;
	        }
            notifyAll();
	    }

        public synchronized int getCount() {
            return count;
        }
    }
}
