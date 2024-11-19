package oop.concur.gui_reactive_and_safe;

public class TestReactiveGUI {
	public static void main(String[] args) {

		MyView view = new MyView();		
		MyController controller = new MyController(view);
		view.attachController(controller);
		view.show();
		
		
	}
}
