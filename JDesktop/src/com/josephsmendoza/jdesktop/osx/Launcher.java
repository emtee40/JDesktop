package com.josephsmendoza.jdesktop.osx;

import javax.swing.UIManager;

public class Launcher {

	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("ch.randelshofer.quaqua.BasicQuaquaLookAndFeel");
		} catch (Exception e) {
		}
		new Taskbar();
		new ProgsMenu();
	}

}
