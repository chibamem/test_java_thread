import static org.junit.Assert.*;

import org.junit.Test;


public class HogeThreadTest {

	@Test
	public void test() {
		Thread thread = new HogeThread();
		Thread thread2 = new HogeThread();
		thread2.start();
		thread.start();
	}

}
