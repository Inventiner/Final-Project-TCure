package com.pbo.TCure;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel{
	public MainMenuPanel() {
		setBackground(Color.blue); // Warna latar belakang biru
		
		JButton startButton = new JButton("Mulai game");
		startButton.addActionListener(this::mulaiGame);
		add(startButton);
	}
	
	private void mulaiGame(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("GameScreen");
	}
}