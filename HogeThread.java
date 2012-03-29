
public class HogeThread extends Thread {

	private static int hoge = 0;
	private static synchronized int getHoge(){
		return hoge;
	}
	
	private static volatile int fuga = 0;
	private static synchronized int getFuga(){
		return fuga;
	}
	
	
	public void start() {
		System.out.println("Runnable");
		super.start();
	}
	
	public void run() {
		System.out.println("Running");
		
		for (int i = 0; i < 5; i++) {
			System.out.println(getName() + "Count:" + i);
			hoge++;
			fuga++;
			System.out.println(getName() + "hoge:" + hoge);
			System.out.println(getName() + "fuga:" + fuga);
			System.out.println(getName() + "getHoge:" + getHoge());
			System.out.println(getName() + "getFuga:" + getFuga());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Dead");
	}
	
	
	
}
