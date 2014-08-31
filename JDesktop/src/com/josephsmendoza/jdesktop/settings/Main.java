package com.josephsmendoza.jdesktop.settings;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;

import com.josephsmendoza.jdesktop.Data;

public class Main extends Panel {

	public Main() {

		// setLayout(new CardLayout());

		Panel i = new Panel();
		Panel theme = new Panel();
		theme.setLayout(new BoxLayout(theme, BoxLayout.X_AXIS));
		i.add(theme);

		Button colors = new Button("Colors");
		colors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Data.s.setPane(new Color());

			}

		});
		theme.add(colors);

		Button walpapr = new Button("Wallpaper");
		// actionListener(wallpaper panel)
		theme.add(walpapr);

		add(i);
	}
}
