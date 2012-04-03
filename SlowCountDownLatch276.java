
public class SlowCountDownLatch276 {
	private int count;
	public SlowCountDownLatch276(int count) {
		if (count < 0)
			throw new IllegalArgumentException(count + " < 0");
		this.count = count;
	}
	
	public void await() {
		while (true) {
			synchronized (this) {
				if (count == 0) return;
			}
		}
	}

}
