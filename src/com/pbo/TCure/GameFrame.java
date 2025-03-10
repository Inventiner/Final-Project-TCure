package com.pbo.TCure;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 7332413315321181596L;
	public static ParentPanel gameCanvas;
	
	public GameFrame() {
		super("TCure - Alpha Build 24.12.09");
		gameCanvas = new ParentPanel(this);
		add(gameCanvas, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
//		setLocationRelativeTo(null);
		pack();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int choose = JOptionPane.showConfirmDialog(null, "Do you really want to exit the application?","Confirm Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (choose == JOptionPane.YES_OPTION) {
					e.getWindow().dispose();
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
	}
}
