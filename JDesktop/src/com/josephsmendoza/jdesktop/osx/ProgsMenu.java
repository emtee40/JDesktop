package com.josephsmendoza.jdesktop.osx;

import java.awt.Button;

import javax.swing.JFrame;

import com.josephsmendoza.jdesktop.Data;

public class ProgsMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3451886243022486766L;

	public ProgsMenu() {
		add(new Button("Test"));
		pack();
		this.setBounds(0,(Data.screenSize.height/2)-(getHeight()/2), getWidth(), getHeight());
		setVisible(true);
	}
}
