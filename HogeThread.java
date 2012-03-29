
public class HogeThread extends Thread {

	private static int hoge = 0;

	public void start() {
		System.out.println("Runnable");
		super.start();
	}
	
	public void run() {
		System.out.println("Running");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Count:" + i);
		}
		
		System.out.println("Dead");
	}
	
	
	
}
