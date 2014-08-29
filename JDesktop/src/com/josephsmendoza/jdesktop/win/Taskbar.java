/**
 * 
 */
package com.josephsmendoza.jdesktop.win;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import com.josephsmendoza.jdesktop.Data;

/**
 * Windows style taskbar
 * 
 * @author josephsmendoza
 */
public class Taskbar extends JFrame {

	private static final long serialVersionUID = -8645927667150164833L;

	StartMenu menu = new StartMenu();

	public Taskbar() {
		super();
		setUndecorated(true);
		setBounds(0, Data.screenSize.height - Data.taskbarHeight,
				Data.screenSize.width, Data.taskbarHeight);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		Button start = new Button("Start");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
			}

		});
		add(start);

		addButtons();

		Button exit = new Button("exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}

		});
		add(exit);

		setVisible(true);
	}

	private void addButtons() {
		// TODO Auto-generated method stub

	}

}
