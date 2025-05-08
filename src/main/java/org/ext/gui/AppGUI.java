package org.ext.gui;

import javax.swing.SwingUtilities;

public class AppGUI {

	public static void main(String[] args) {
		
		  SwingUtilities.invokeLater(() -> {
	            new LoginFrame(); // apre finestra di login
	        });

	}

}
