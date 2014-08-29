package com.josephsmendoza.jdesktop.win.settings;

import java.awt.Button;
import java.awt.Panel;

import javax.swing.BoxLayout;

public class Main extends Panel {

	public Main() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Panel theme = new Panel();
		theme.setLayout(new BoxLayout(theme, BoxLayout.X_AXIS));

		Button colors = new Button("Colors");
		// actionListener(colors panel)
		theme.add(colors);

		Button walpapr = new Button("Wallpaper");
		// actionListener(wallpaper panel)
		theme.add(walpapr);
	}
}
