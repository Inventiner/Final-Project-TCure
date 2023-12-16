package com.pbo.TCure;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel{
	public MainMenuPanel() {
		setBackground(Color.blue); // Warna latar belakang biru
		
		JButton startButton = new JButton("Mulai game");
		JButton levelpicker = new JButton("Pilih Level");
		startButton.addActionListener(this::mulaiGame);
		levelpicker.addActionListener(this::picklevel);
		add(startButton);
		add(levelpicker);
	}
	
	private void mulaiGame(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("GameScreen");
	}
	
	private void picklevel(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("Level");
	}
}