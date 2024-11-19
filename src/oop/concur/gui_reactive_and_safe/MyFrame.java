package oop.concur.gui_reactive_and_safe;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MyFrame extends JFrame implements ActionListener {

	private JButton start;
	private JProgressBar bar;
	private MyController controller;
	
	public MyFrame() {
		setTitle("My GUI");
		setSize(300, 120);

		bar = new JProgressBar();
		bar.setMinimum(0);
		bar.setMaximum(100);
		
		start = new JButton("start");

		Container cp = getContentPane();
		JPanel panel = new JPanel();

		Box p0 = new Box(BoxLayout.X_AXIS);
		p0.add(start);

		Box p1 = new Box(BoxLayout.X_AXIS);
		p1.add(bar);

		Box p2 = new Box(BoxLayout.Y_AXIS);
		p2.add(p0);
		p2.add(Box.createVerticalStrut(10));
		p2.add(p1);

		panel.add(p2);
		cp.add(panel);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(-1);
			}

			public void windowClosed(WindowEvent ev) {
				System.exit(-1);
			}
		});

		start.addActionListener(this);
	}
	
	public void attachController(MyController controller) {
		this.controller = controller;
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object src = ev.getSource();
		if (src == start) {
			if (controller != null) {		
				controller.notifyStarted();
			}				
		}
	}
	
	public void updateProgressBar(int perc) {
		bar.setValue(perc);
	}
	
}
