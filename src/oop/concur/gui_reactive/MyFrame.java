package oop.concur.gui_reactive;

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

public class MyFrame extends JFrame implements ActionListener {

	private JButton start;
	private MyController controller;
	
	public MyFrame(MyController controller) {
		setTitle("My GUI");
		this.controller = controller;
		setSize(300, 70);
		
		start = new JButton("start");

		Container cp = getContentPane();
		JPanel panel = new JPanel();

		Box p1 = new Box(BoxLayout.X_AXIS);
		p1.add(start);

		panel.add(p1);
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
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object src = ev.getSource();
		if (src == start) {
			controller.notifyStarted();
		}
	}
	
}
