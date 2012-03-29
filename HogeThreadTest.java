import static org.junit.Assert.*;

import org.junit.Test;


public class HogeThreadTest {

	@Test
	public void test() {
		Thread thread = new HogeThread();
		Thread thread2 = new HogeThread();
		thread.start();
		thread2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
