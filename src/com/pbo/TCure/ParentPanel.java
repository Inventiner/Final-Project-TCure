package com.pbo.TCure;

import java.awt.CardLayout;	
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ParentPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4852823351708283398L;
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
		add(new LevelPickerPanel(), "Level");
	}
	
	public void showPanel(String name) {
		cardlayout.show(this, name);
		
		if(name == "GameScreen") {
			game.startGame();
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
	
	public void levelPicker(String level) {
		cardlayout.show(this, "GameScreen");
		
		if (level == "Level1") {
			game.changeLevel(new Level1());
			cardlayout.show(this, "GameScreen");
			game.requestFocus();
		} else if (level == "Level2") {
			game.changeLevel(new Level2());
			cardlayout.show(this, "GameScreen");
			game.requestFocus();
		} else if (level == "Level3") {
			game.changeLevel(new Level3());
			cardlayout.show(this, "GameScreen");
			game.requestFocus();
		} else if (level == "Level4") {
			game.changeLevel(new Level4());
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
