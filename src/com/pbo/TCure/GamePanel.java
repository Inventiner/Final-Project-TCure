package com.pbo.TCure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener{
	static final int areaWidth = 640, areaHeight = 640, UNIT_SIZE = 40;
	static Level curr_level;
	
	public GamePanel() {
		addKeyListener(this);
		setPreferredSize(new Dimension(areaWidth, areaHeight));
		setBackground(Color.BLACK);
		setFocusable(true);
		curr_level = new Level1(areaWidth, areaHeight, UNIT_SIZE);
		
		startGame();
	}
	
	public void startGame() {
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw Grid For Easy seeing grid
		for(int i = 0; i < areaHeight/UNIT_SIZE; i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, areaHeight);
		}
		for(int i = 0; i < areaWidth/UNIT_SIZE; i++) {
			g.drawLine(0, i*UNIT_SIZE, areaWidth, i*UNIT_SIZE);
		}
		
		draw(g);
	}
	
	public void draw(Graphics g) {
		curr_level.draw(g);
		curr_level.drawPlayer(g);
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		curr_level.keyHandler(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
