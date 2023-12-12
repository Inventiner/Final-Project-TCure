package com.pbo.TCure;

import java.awt.Color;	
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LosePanel extends JPanel {
	public LosePanel() {
		setBackground(Color.green); //
		JLabel label = new JLabel("You Win");
		JButton BacktoMenu = new JButton("Kembali ke Menu");
		JButton Retry = new JButton("Ulang Level");
		BacktoMenu.addActionListener(this::BackToMenu);
		Retry.addActionListener(this::RetryLevel);
		add(label);
		add(BacktoMenu);
		add(Retry);
	}
	
	private void BackToMenu(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("MainMenu");
	}
	
	private void RetryLevel(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("Retry");
	}
}