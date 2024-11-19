package oop.concur.gui_reactive_and_safe;

import javax.swing.SwingUtilities;

public class MyView {

	private MyFrame frame;

	public MyView() {
		frame = new MyFrame();
	}

	public void attachController(MyController controller) {
		frame.attachController(controller);
	}

	public void show() {
		SwingUtilities.invokeLater(() -> {
			frame.setVisible(true);
		});	
	}

	public void reset() {
		SwingUtilities.invokeLater(() -> {
			frame.updateProgressBar(0);
		});
	}	

	public void updateProgress(int perc) {
		SwingUtilities.invokeLater(() -> {
			frame.updateProgressBar(perc);
		});
	}	

}
