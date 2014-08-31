package com.josephsmendoza.jdesktop.settings;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JColorChooser;

public class Color extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3087010075909611153L;

	Color() {
		setLayout(new BorderLayout());

		Panel options = new Panel();
		options.setLayout(new GridLayout(3, 1));
		add(options, BorderLayout.WEST);

		add(new JColorChooser());
	}
}
