import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.SetOfIntegerSyntax;



public class ObservableSet256<E> extends ForwardingSet<E> {
    public ObservableSet256(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E> observers = new ArrayList<SetObserver<E>>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observer.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers)
                observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element);// notifyElementAdded呼び出し
        return result;
    }

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
