package oop.concur.ext;

import java.time.Duration;
import java.util.ArrayList;

/**
 * 
 * To be run with JVM option --enable-preview (if JDK < 21)
 * 
 * @author aricci
 *
 */
public class TestVirtualThreads {

	public static void main(String[] args) {
		var list = new ArrayList<Thread>();
		var t0 = System.currentTimeMillis();
		var c = new Counter();
		for (var i = 0; i < 1000_000; i++) {		
			// Thread t = new Thread(TestVirtualThreads::sleepBehaviour);
			Thread t = MyVirtualThread.make(c);
			t.start();
			list.add(t);
		}
		
		list.forEach(t -> {
			try {
				t.join();
			} catch (Exception ex) {};
		});

		var t1 = System.currentTimeMillis();
		System.out.println("Counter final value: " + c.getValue());
		System.out.println("Time elapsed: " + (t1 - t0));

	}
	
	static void sleepBehaviour() {
		try {
			Thread.sleep(Duration.ofSeconds(1));
		} catch (Exception ex) {
		}
	}
}
