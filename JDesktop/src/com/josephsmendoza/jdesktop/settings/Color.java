package com.josephsmendoza.jdesktop.settings;

import java.awt.Panel;

import javax.swing.JColorChooser;
import javax.swing.JTabbedPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.josephsmendoza.jdesktop.Data;

public class Color extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3087010075909611153L;

	Color() {

		JTabbedPane pane = new JTabbedPane();
		add(pane);

		final JColorChooser primary = new JColorChooser(Data.primary);
		ColorSelectionModel a = primary.getSelectionModel();
		a.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				Data.primary = primary.getColor();
				System.out.println(Integer
						.toString(primary.getColor().getRGB()));
			}

		});
		pane.add("Primary", primary);

		final JColorChooser secondary = new JColorChooser(Data.secondary);
		ColorSelectionModel b = secondary.getSelectionModel();
		b.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				Data.secondary = secondary.getColor();
				System.out.println(Integer.toString(secondary.getColor()
						.getRGB()));
			}

		});
		pane.add("Secondary", secondary);
	}
}
