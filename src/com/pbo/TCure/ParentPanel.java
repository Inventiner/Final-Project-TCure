package com.pbo.TCure;

import java.awt.CardLayout;	
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ParentPanel extends JPanel{
	private CardLayout cardlayout = new CardLayout();
	static GamePanel game;
	
	public ParentPanel(JFrame masterFrame) {
		setLayout(cardlayout);
		game = new GamePanel(masterFrame);
		
		
		// Panel game
		add(new MainMenuPanel(),"MainMenu");
		add(game, "GameScreen");
		add(new WinPanel(), "Win");
		add(new LosePanel(), "Lose");
	}
	
	public void showPanel(String name) {
		cardlayout.show(this, name);
		
		if(name == "GameScreen") {
			game.requestFocus();
		} else if (name == "NextLevel") {
			game.changeLevel(GamePanel.curr_level.getNextLevel());
			cardlayout.show(this, "GameScreen");
			game.requestFocus();
		} else if (name == "Retry") {
			game.changeLevel(GamePanel.curr_level.RetryLevel());
			cardlayout.show(this, "GameScreen");
			game.requestFocus();
		}
	}
	
	public void draw(Graphics g) {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
}
