import java.util.concurrent.TimeUnit;



public class SopThread253 extends Thread {

	private static boolean stopRequested;
	private static synchronized void requestStop() {
		stopRequested = true;
	}
	private static synchronized boolean stopRequested() {
		return stopRequested;
	}
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				System.out.println("**start**");
				while (!stopRequested())
					System.out.println("i:" + i);
					i++;
			}
		});
		
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
