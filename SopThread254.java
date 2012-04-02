import java.util.concurrent.TimeUnit;



public class SopThread254 extends Thread {

	private static volatile boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				System.out.println("**start**");
				while (!stopRequested)
					System.out.println("i:" + i);
					i++;
			}
		});
		
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
