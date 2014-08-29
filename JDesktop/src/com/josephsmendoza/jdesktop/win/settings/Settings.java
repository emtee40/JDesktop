package com.josephsmendoza.jdesktop.win.settings;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Settings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9156641949521141769L;

	public Settings() {
		super();
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(new Main(), BorderLayout.CENTER);

		Panel navPane = new Panel();
		navPane.setLayout(new BoxLayout(navPane, BoxLayout.X_AXIS));
		Button back = new Button("<");
		// ActionListener(go back)
		navPane.add(back);

		Label dir = new Label();
		// setDir
		navPane.add(dir);

		add(navPane, BorderLayout.NORTH);

		pack();
		setVisible(true);
	}
}
