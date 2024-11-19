package oop.concur.gui_reactive;

public class MyAgent extends Thread {

	public MyAgent() {}

	public void run() {
		log("starting a long job...");
		long t0 = System.currentTimeMillis();
		doMyJob();
		long t1 = System.currentTimeMillis();
		log("job finished (after " + (t1 - t0) + "ms)");
		
	}

	protected void doMyJob() {
		try {
			Thread.sleep(10000);
		} catch (Exception ex) {}
	}
	
	protected void log(String msg) {
		System.out.println("[MYAGENT][" + Thread.currentThread().getName()+"] " + msg);
	}
}
