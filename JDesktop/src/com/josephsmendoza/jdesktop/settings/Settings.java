package com.josephsmendoza.jdesktop.settings;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import com.josephsmendoza.jdesktop.Data;

public class Settings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9156641949521141769L;

	Label dir;

	public Settings() {
		super();
		setBackground(Data.primary);
		setTitle("Jdesktop-Settings");
		Main m = new Main();
		add(m, BorderLayout.CENTER);

		Panel navPane = new Panel();
		navPane.setLayout(new BoxLayout(navPane, BoxLayout.X_AXIS));
		add(navPane, BorderLayout.NORTH);

		Button back = new Button("<");
		// ActionListener(go back)
		navPane.add(back);

		dir = new Label("Main");
		navPane.add(dir);

		pack();
		setResizable(false);
		setVisible(true);
	}
}
