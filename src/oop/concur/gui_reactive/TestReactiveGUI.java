package oop.concur.gui_reactive;

public class TestReactiveGUI {
	public static void main(String[] args) {

		MyController controller = new MyController();
		MyView view = new MyView(controller);

	}
}
