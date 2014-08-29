/**
 * 
 */
package com.josephsmendoza.jdesktop.win;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.josephsmendoza.jdesktop.Data;
import com.josephsmendoza.jdesktop.win.settings.Settings;

/**
 * Windows-style start menu
 * 
 * @author josephsmendoza
 */
public class StartMenu extends JFrame {

	private static final long serialVersionUID = 719685236873744245L;

	public StartMenu() {
		super();
		setBounds(0, (Data.screenSize.height / 2) - Data.taskbarHeight,
				Data.screenSize.width / 4, Data.screenSize.height / 2);
		addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				setVisible(false);
			}

		});
		Panel progs = new Panel();
		progs.setLayout(new BoxLayout(progs, BoxLayout.Y_AXIS));
		add(new JScrollPane(progs), BorderLayout.CENTER);

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
		userNav.setLayout(new BoxLayout(userNav, BoxLayout.X_AXIS));
		userNav.add(new Label(Data.username));

		Panel sidebar = new Panel();
		sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
		// TODO setup dis stuffs
		add(sidebar, BorderLayout.EAST);
	}

}
