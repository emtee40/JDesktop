package com.josephsmendoza.jdesktop.win;

import javax.swing.UIManager;

import com.josephsmendoza.jdesktop.Data;

public class Launcher {

	public static void main(String[] args) {
		if (Data.os.equals("Windows")) {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}
		}
		Data.init();
		new Taskbar();
	}

}
