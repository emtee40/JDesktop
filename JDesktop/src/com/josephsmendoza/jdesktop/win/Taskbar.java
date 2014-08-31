/**
 * 
 */
package com.josephsmendoza.jdesktop.win;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import com.josephsmendoza.jdesktop.Data;

/**
 * Windows style taskbar
 * 
 * @author josephsmendoza
 */
public class Taskbar extends JFrame {

	private static final long serialVersionUID = -8645927667150164833L;

	public static StartMenu menu = new StartMenu();

	public Taskbar() {
		setTitle("JDesktop-Windows");
		setUndecorated(true);
		setBounds(0, Data.screenSize.height - Data.taskbarHeight,
				Data.screenSize.width, Data.taskbarHeight);
		setLayout(new FlowLayout(FlowLayout.LEFT));
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
				menu.dispose();
				dispose();
				try {
					Data.writeSettings();
				} catch (FileNotFoundException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("\nSomething went wrong! we coulnd't write settings.");
				}
			}

		});
		add(exit);

		setAlwaysOnTop(true);
		setVisible(true);
	}

	private void addButtons() {
		// TODO Auto-generated method stub

	}

}
