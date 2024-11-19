package oop.concur.gui_reactive_and_safe;

public class MyAgent extends Thread {

	private MyView view;
	
	public MyAgent(MyView view) {
		this.view = view;
	}

	public void run() {
		log("starting a long job...");
		long t0 = System.currentTimeMillis();
		doMyJob();
		long t1 = System.currentTimeMillis();
		log("job finished (after " + (t1 - t0) + "ms)");
		
	}

	protected void doMyJob() {
		try {
			view.reset();
			for (int i = 1; i <= 100; i++) {
				Thread.sleep(20);
				view.updateProgress(i);
			}
		} catch (Exception ex) {}
	}
	
	protected void log(String msg) {
		System.out.println("[MYAGENT][" + Thread.currentThread().getName()+"] " + msg);
	}
}
