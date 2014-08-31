package com.josephsmendoza.jdesktop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * the source of all data. Any config or editable params should go here.
 * 
 * @author josephsmendoza
 * @version 1
 */
public class Data {

	public static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	public static File progsDir;
	public static final String os = System.getProperty("os.name");
	public static byte taskbarHeight;
	public static final String username = System.getProperty("user.name");
	public static Color primary;
	public static Color secondary;

	/**
	 * Gather all the data needed to run the program
	 */
	public static void init() {
		if (os.equals("Linux")) {
			progsDir = new File("/usr/bin/");
		}
		if (os.equals("osx")) {
			progsDir = new File("/Applications/");
		}
		if (os.equals("Windows")) {
			progsDir = new File(os);// TODO Find windows start menu
		}

		try {
			loadSettings();
		} catch (Exception e) {
			defaults();
		}
	}

	/**
	 * Load default settings. Called if no config file is found
	 */
	private static void defaults() {
		taskbarHeight = 33;
		primary = Color.LIGHT_GRAY;
		secondary = Color.GRAY;
	}

	/**
	 * Load settings from a file.
	 * 
	 * @param file
	 *            the file to read from
	 * @throws FileNotFoundException
	 *             if the file is missing
	 */
	private static void loadSettings() throws FileNotFoundException {
		// get the file to read from; returns the error
		Scanner in = new Scanner(username);

		// Get the settings
		taskbarHeight = in.nextByte();
		in.nextLine();
		primary = getColor();
		secondary = getColor();

		// close the thing
		in.close();
	}

	private static Color getColor() {
		String color = new Scanner(username).nextLine();
		if (color.equals(Color.BLACK)) {
			return Color.BLACK;
		}
		if (color.equals(Color.BLUE)) {
			return Color.BLUE;
		}
		if (color.equals(Color.CYAN)) {
			return Color.CYAN;
		}
		if (color.equals(Color.DARK_GRAY)) {
			return Color.DARK_GRAY;
		}
		if (color.equals(Color.GRAY)) {
			return Color.GRAY;
		}
		if (color.equals(Color.GREEN)) {
			return Color.GREEN;
		}
		if (color.equals(Color.LIGHT_GRAY)) {
			return Color.LIGHT_GRAY;
		}
		if (color.equals(Color.MAGENTA)) {
			return Color.MAGENTA;
		}
		if (color.equals(Color.ORANGE)) {
			return Color.ORANGE;
		}
		if (color.equals(Color.PINK)) {
			return Color.PINK;
		}
		if (color.equals(Color.RED)) {
			return Color.RED;
		}
		if (color.equals(Color.WHITE)) {
			return Color.WHITE;
		}
		if (color.equals(Color.YELLOW)) {
			return Color.YELLOW;
		}
		return null;
	}

	/**
	 * write settings to a file
	 * 
	 * @param file
	 *            the file to write to
	 * @throws FileNotFoundException
	 *             If a new regular file cannot be created, or if some other
	 *             error occurs while opening or creating the file
	 * @throws SecurityException
	 *             If a security manager is present and
	 *             checkWrite(file.getPath()) denies write access to the file
	 */
	public static void writeSettings() throws FileNotFoundException,
			SecurityException {
		// get the file to write to; returns the error
		PrintWriter out = new PrintWriter(username);

		// Write the settings IN THE SAME ORDER as they are read
		out.println(taskbarHeight);
		out.println(primary);
		out.println(secondary);

		// close the thing
		out.close();
	}
}
