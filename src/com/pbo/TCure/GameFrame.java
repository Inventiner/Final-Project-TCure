package com.pbo.TCure;

import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	public static GamePanel gameCanvas;
	
	public GameFrame() {
		super("TCure - Early Concept Build");
		gameCanvas = new GamePanel();
		add(gameCanvas, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
//		setLocationRelativeTo(null);
		pack();
		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				int choose = JOptionPane.showConfirmDialog(null, "Do you really want to exit the application?","Confirm Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
//				if (choose == JOptionPane.YES_OPTION) {
//					e.getWindow().dispose();
//					System.out.println("close");
//				} else {
//					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//				}
//			}
//		});
		
	}
	
}
