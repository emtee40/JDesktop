package com.josephsmendoza.jdesktop.osx;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.josephsmendoza.jdesktop.Data;

public class Taskbar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5419970169844075677L;

	public Taskbar() {
		setBounds(0, 0, Data.screenSize.width, 19);
		setBackground(Data.primary);
		setLayout(new FlowLayout(FlowLayout.LEFT));

		setJMenuBar(new JMenuBar());

		JMenu menu = new JMenu("");
		menu.setIcon(new ImageIcon("apple-logo"));
		getJMenuBar().add(menu);

		JMenuItem prefs = new JMenuItem("Preferences");
		prefs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Data.settings();
			}

		});
		menu.add(prefs);

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}

		});
		menu.add(exit);

		setResizable(false);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setVisible(true);
	}
}
