package com.josephsmendoza.jdesktop.settings;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;

import com.josephsmendoza.jdesktop.Data;

public class Settings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9156641949521141769L;

	Label dir;
	Panel active;

	public Settings() {
		super();
		setBackground(Data.primary);
		setTitle("Jdesktop-Settings");
		active = new Main();
		add(active, BorderLayout.CENTER);

		Panel navPane = new Panel();
		navPane.setLayout(new FlowLayout(FlowLayout.LEFT));
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

	public void setPane(Panel pane) {
		remove(active);
		active = pane;
		add(active);
		pack();
	}
}
