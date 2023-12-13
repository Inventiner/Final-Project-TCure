package com.pbo.TCure;

import java.awt.Color;	
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Level1 extends Level{
	static JPanel panel;
	static int winX, winY;
	static final int sizeX = 16, sizeY = 16;
	List<Coin> coins;
	List<Wall> walls;
	// 0 = empty, 1 = wall, 2 = player, 3 = goal / finish
	static final int[][] levelMapTemplate = 
		   {{1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
	
	static final int[][] coinMap = 
		   {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	public Level1() {
		super(levelMapTemplate.clone(), 640, 640, 40);
		arrX = sizeX;
		arrY = sizeY;
		this.coins = new ArrayList<>();
		this.walls = new ArrayList<>();
		this.point = 0;
		initCoin();
		initLevel();
	}
	
	public void initCoin() {
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
				if(coinMap[i][j] == 1) {
					coins.add(new Coin(j * getUnitSize(), i * getUnitSize(), getUnitSize(), getUnitSize(), assetManager.getCoin()));
				}
			}
		}
	}
	
	public void initLevel() {
		int boxSize = getUnitSize();
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
				switch (levelMap[i][j]) {
				case WALL:
					walls.add(new Wall(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getWall()));
					break;
				case PLAYER:
					charX = j;
					charY = i;
					System.out.println("Creating new player! at " + j * boxSize + ", " + i * boxSize);
					player = new Player(j * boxSize, i * boxSize, boxSize, boxSize, 3, assetManager.getPlayer());
					player.setCoord(j * boxSize, i * boxSize);
					break;
				case WIN:
					winX = j * boxSize;
					winY = i * boxSize;
					break;
				default:
					break;
				}
			}
		}	
		player.setWinX(winX);
		player.setWinY(winY);
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
		
		this.player.draw(g, panel);
		
		// draw win zone
		g.setColor(Color.yellow);
		g.fillRect(winX, winY, getUnitSize(), getUnitSize());
	}
	
	@Override
	public void keyHandler(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			movementHandler('R');
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			movementHandler('U');
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			movementHandler('D');
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			movementHandler('L');
		}
	}
	
	public Level getNextLevel() {
		return new Level2();
	}
	public Level RetryLevel() {
		return new Level1();
	}
	
}
