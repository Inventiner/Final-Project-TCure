package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Level3 extends Level{
	static final int sizeX = 16, sizeY = 16;
	static final int[][] levelMapTemplate = 
		   {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 2, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 3},
			{1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 4, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 6, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1}};
	
	static final int[][] coinMap = 
		   {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	public Level3() {
		super(levelMapTemplate, 720, 720, 45);
		arrX = sizeX;
		arrY = sizeY;
		this.player = new Player();
		this.winSquare = new Win();
		this.key = new Key();
		this.win = false;
		this.lose = false;
		this.point = 0;
		initCoin(coinMap);
		initLevel();
	}
	
	@Override
	public void draw(Graphics g, JPanel panel) {
		for (Coin coin : coins) {
			if(coin.collide(player.getX(), player.getY())) {
				point += 10;
				System.out.println("Point: " + point);
			}
			coin.draw(g, panel);
		}
		
		for (Wall wall : walls) {
			wall.draw(g, panel);
		}
		
		for (Trap trap : traps) {
			trap.draw(g, panel);
		}
		
		if(key.collide(player.getX(), player.getY())) {
			this.key.setTaken(true);
		}
		
		if(key.isTaken()) {
			this.door.open();
		}
		
		this.key.draw(g, panel);
		this.player.draw(g, panel);
		this.door.draw(g, panel);
		this.winSquare.draw(g, panel);
	}
	
	@Override
	public void keyHandler(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			movementHandler('R');
		} else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			movementHandler('U');
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
			movementHandler('D');
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
			movementHandler('L');
		}
	}
	
	public Level getNextLevel() {
		return new Level4();
	}
	public Level RetryLevel() {
		return new Level3();
	}
}
