package com.josephsmendoza.jdesktop;

import com.josephsmendoza.jdesktop.win.Taskbar;

public class Launcher {

	public static void main(String[] args) {
		Data.init();
		new Taskbar();
	}

}
