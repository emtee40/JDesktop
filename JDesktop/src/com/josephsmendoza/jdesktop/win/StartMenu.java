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
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.josephsmendoza.jdesktop.Data;

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
		JScrollPane progPane = new JScrollPane(progs);
		progs.setLayout(new BoxLayout(progs, BoxLayout.Y_AXIS));
		progPane.getVerticalScrollBar().setUnitIncrement(16);
		add(progPane, BorderLayout.CENTER);

		Button settings = new Button("Settings");
		settings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Data.settings();
			}

		});
		progs.add(settings);

		for (final File f : Data.progs) {
			Button b = new Button(f.getName());
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						Runtime.getRuntime().exec(f.getAbsolutePath());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			});
			progs.add(b);
		}

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
