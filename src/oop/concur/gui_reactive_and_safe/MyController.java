package oop.concur.gui_reactive_and_safe;

public class MyController  {

	private MyView view;
	
	public MyController(MyView view) {
		this.view = view;
	}
	
	public void notifyStarted() {
		log("started event => spawning a new agent...");
		MyAgent agent = new MyAgent(view);
		agent.start();
		// agent.run(); // WRONG!
		log("agent spawned.");
	}
	
	protected void log(String msg) {
		System.out.println("[MYCONTROLLER][" + Thread.currentThread().getName()+"] " + msg);
	}
	
}
