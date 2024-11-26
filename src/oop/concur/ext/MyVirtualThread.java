package oop.concur.ext;

public class MyVirtualThread implements Runnable {
	
	private Counter counter;
	
	protected MyVirtualThread(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
		counter.inc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {}
	}
	
	public static Thread make(Counter counter) {
		Thread t = Thread.ofVirtual().unstarted(new MyVirtualThread(counter));
		return t;
	}
}
