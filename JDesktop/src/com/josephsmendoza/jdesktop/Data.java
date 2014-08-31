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
 */
public class Data {

	public static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	public static File progsDir;
	public static File[] progs;
	public static final String os = System.getProperty("os.name");
	public static byte taskbarHeight;
	public static final String username = System.getProperty("user.name");
	public static Color primary;
	public static Color secondary;
	public static com.josephsmendoza.jdesktop.settings.Settings s;

	/**
	 * Gather all the data needed to run the program
	 */
	public static void init() {
		if (os.equals("Linux")) {
			progsDir = new File("/usr/bin");
		}
		if (os.equals("osx")) {
			progsDir = new File("/Applications");
		}
		if (os.equals("Windows")) {
			progsDir = new File("C:\\Program Files");// TODO Find windows start
														// menu
		}
		progs = progsDir.listFiles();

		try {
			loadSettings();
		} catch (Exception e) {
			e.printStackTrace();
			defaults();
		}
	}

	/**
	 * Load default settings.
	 */
	private static void defaults() {
		taskbarHeight = 33;
		primary = Color.LIGHT_GRAY;
		secondary = Color.GRAY;
	}

	/**
	 * Load settings from user config file.
	 * 
	 * @throws FileNotFoundException
	 *             if the file is missing
	 */
	private static void loadSettings() throws FileNotFoundException {
		// get the file to read from; returns the error
		Scanner in = new Scanner(new File(username));

		// Get the settings
		taskbarHeight = in.nextByte();
		in.nextLine();
		primary = new Color(Integer.parseInt(in.nextLine()));
		secondary = new Color(Integer.parseInt(in.nextLine()));

		// close the thing
		in.close();
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
		out.println(Integer.toString(primary.getRGB()));
		out.println(Integer.toString(secondary.getRGB()));

		// close the thing
		out.close();
	}

	public static void settings() {
		s = new com.josephsmendoza.jdesktop.settings.Settings();
	}
}
