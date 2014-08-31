package com.josephsmendoza.jdesktop;

import javax.swing.UIManager;

import com.josephsmendoza.jdesktop.win.Taskbar;

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
