package com.pbo.TCure;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelPickerPanel extends JPanel {
	public LevelPickerPanel() {
		setBackground(Color.blue); // Warna latar belakang biru
		
		JButton BacktoMenu = new JButton("Kembali ke Menu");
		JButton PickLevel1 = new JButton("Level 1");
		JButton PickLevel2 = new JButton("Level 2");
		JButton PickLevel3 = new JButton("Level 3");
		BacktoMenu.addActionListener(this::BackToMenu);
		PickLevel1.addActionListener(this::picklevel1);
		PickLevel2.addActionListener(this::picklevel2);
		PickLevel3.addActionListener(this::picklevel3);
		add(PickLevel1);
		add(PickLevel2);
		add(PickLevel3);
		add(BacktoMenu);
	}
	
	private void BackToMenu(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("MainMenu");
	}
	
	private void picklevel1(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.levelPicker("Level1");
	}
	
	private void picklevel2(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.levelPicker("Level2");
	}
	
	private void picklevel3(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.levelPicker("Level3");
	}
}
