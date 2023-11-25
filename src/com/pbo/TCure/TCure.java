package com.pbo.TCure;

public class TCure {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameFrame gameGUI = new GameFrame();
				gameGUI.setVisible(true);
			}
		});
		
	}
}
