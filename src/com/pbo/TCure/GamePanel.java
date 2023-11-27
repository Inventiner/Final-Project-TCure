package com.pbo.TCure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener{
	static final int areaWidth = 640, areaHeight = 640, UNIT_SIZE = 40;
	static Level curr_level;
	static final int DELAY = 75;
	boolean running = false;
	boolean win = false;
	Timer timer;
	Random random;


	public GamePanel() {
		addKeyListener(this);
		setPreferredSize(new Dimension(areaWidth, areaHeight));
		setBackground(Color.BLACK);
		setFocusable(true);
		curr_level = new Level1(areaWidth, areaHeight, UNIT_SIZE);

		startGame();
	}

	public void startGame() {
		running = true;
		timer = new Timer();			
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
		if (curr_level.getWin() && !curr_level.getPlayer().getMoving()) running = false;
		if(running) {
			curr_level.draw(g);
			curr_level.drawPlayer(g);
		}else {
			YouWin(g);
		}
		repaint();
	}

	public void YouWin(Graphics g) {
		g.setColor(Color.GREEN);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("YOU WIN!!!", (areaWidth - metrics.stringWidth("YOU WIN!!!"))/2, areaHeight/2);
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
