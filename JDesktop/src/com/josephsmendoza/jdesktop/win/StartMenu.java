/**
 * 
 */
package com.josephsmendoza.jdesktop.win;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.josephsmendoza.jdesktop.Data;
import com.josephsmendoza.jdesktop.settings.Settings;

/**
 * Windows-style start menu
 * 
 * @author josephsmendoza
 */
public class StartMenu extends JFrame {

	private static final long serialVersionUID = 719685236873744245L;

	public StartMenu() {
		setTitle("JDesktop-Windows");
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowIconified(WindowEvent wEvt) {
			}

			@Override
			public void windowDeactivated(WindowEvent wEvt) {
				setVisible(false);
			}

		});
		setBounds(0, (Data.screenSize.height / 2) - Data.taskbarHeight,
				Data.screenSize.width / 4, Data.screenSize.height / 2);
		setBackground(Data.primary);

		Panel progs = new Panel();
		progs.setLayout(new FlowLayout());
		add(progs, BorderLayout.WEST);

		Button settings = new Button("Settings");
		settings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Settings();
			}

		});
		progs.add(settings);

		Panel userNav = new Panel();
		add(userNav, BorderLayout.NORTH);
		userNav.setLayout(new FlowLayout());
		userNav.setBackground(Data.secondary);
		userNav.add(new Label(Data.username));

		Panel sidebar = new Panel();
		sidebar.setLayout(new GridLayout(20, 1));
		sidebar.setBackground(Data.secondary);
		// TODO setup dis stuffs
		add(sidebar, BorderLayout.EAST);

		Button home = new Button(Data.username);
		sidebar.add(home);

		setResizable(false);
		setUndecorated(true);
	}

}
