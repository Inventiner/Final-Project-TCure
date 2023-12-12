package com.pbo.TCure;

import java.awt.CardLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ParentPanel extends JPanel{
	private CardLayout cardlayout = new CardLayout();
	
	public ParentPanel(JFrame masterFrame) {
		setLayout(cardlayout);
		
		// Panel game
		add(new MainMenuPanel(),"MainMenu");
		add(new GamePanel(masterFrame), "GameScreen");
		add(new WinPanel(), "Win");
	}
	
	public void showPanel(String name) {
		cardlayout.show(this, name);
	}
	
	public void draw(Graphics g) {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
}
