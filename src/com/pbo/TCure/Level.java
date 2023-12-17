package com.pbo.TCure;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

/*
 * Template of CoinMap and LevelMap
 * static final int[][] level = 
		   {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
	
	static final int[][] coinMap = 
		   {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
 */


abstract public class Level {
	protected int point;
	protected Win winSquare;
	protected Door door;
	protected Key key;
	protected Player player;
	protected int[][] levelMap;
	private int width, height, unitSize;
	boolean win = false, lose = false;
	private Dimension currDimension;
	private assetManager assets;
	protected static final int EMPTY = 0, WALL = 1, PLAYER = 2, WIN = 3, TRAP = 4, DOOR = 5, KEY = 6, ENEMY = 7;
	protected static int charX, charY, arrX, arrY;
	
	public Level() {
	}
	
	public Level(int[][] level, int width, int height, int unitSize) {
		this.assets = new assetManager();
		this.width = width;
		this.height = height;
		this.unitSize = unitSize;
		this.point = 0;
		this.currDimension = new Dimension(width, height);
		initMap(level);
	}
	
	public void initMap(int[][] level) {
		this.levelMap = new int[getHeight()/getUnitSize()][getWidth()/getUnitSize()];
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
				this.levelMap[i][j] = level[i][j];
			}
		}
	}
	
	
	
	public int[][] getLevel() {
		return levelMap;
	}

	public Player getPlayer() {
		return player;
	}

	public void setLevel(int[][] level) {
		this.levelMap = level;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getUnitSize() {
		return unitSize;
	}

	public void setUnitSize(int unitSize) {
		this.unitSize = unitSize;
	}
	
	public Dimension getCurrDimension() {
		return currDimension;
	}

	public void setCurrDimension(Dimension currDimension) {
		this.currDimension = currDimension;
	}

	public boolean getWin() {
		return win;
	}
	
	public boolean getLose() {
		return lose;
	}

	public void movementHandler(char direction) {
//		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
//			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
//				System.out.print(this.levelMap[i][j]);
//			}
//			System.out.print('\n');
//		}
		
		switch (direction) {
		case 'R':
			if(!player.getMoving() && ((charX + 1 < arrX && levelMap[charY][charX + 1] == EMPTY) 
					|| (charX + 1 < arrX && levelMap[charY][charX + 1] == KEY) 
					|| ((charX + 1 < arrX && levelMap[charY][charX + 1] == DOOR) && door.getOpen()))) { //cek apakah bisa gerak ke arah tsb
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY][charX + 1] = 2;
					charX += 1;
				} while(((charX + 1 < arrX && levelMap[charY][charX + 1] == EMPTY) 
						|| (charX + 1 < arrX && levelMap[charY][charX + 1] == KEY) 
						|| ((charX + 1 < arrX && levelMap[charY][charX + 1] == DOOR) && door.getOpen()))); //gerak terus hingga nabrak tembok / menang / kena musuh (TBA)
				
				if(charX + 1 < arrX && levelMap[charY][charX + 1] == 3) { //cek apakah sampai spot menang
					win = true;
				}				
				else if(charX + 1 < arrX && levelMap[charY][charX + 1] == 4) { //cek apakah sampai spot kalah
					lose = true;
				}
				
//				if(charX + 1 < arrX && levelMap[charY][charX + 1] == KEY) {
//					key.setTaken(true);
//					door.open();
//				}
			}
			break;
		case 'U':
			if(!player.getMoving() && ((charY - 1 >= 0 && levelMap[charY - 1][charX] == 0)
					||(charY - 1 >= 0 && levelMap[charY - 1][charX] == KEY)
					|| ((charY - 1 >= 0 && levelMap[charY - 1][charX] == DOOR) && door.getOpen()))) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY - 1][charX] = 2;
					charY -= 1;
				} while(((charY - 1 >= 0 && levelMap[charY - 1][charX] == 0)
						||(charY - 1 >= 0 && levelMap[charY - 1][charX] == KEY)
						|| ((charY - 1 >= 0 && levelMap[charY - 1][charX] == DOOR) && door.getOpen())));
				
				if(charY - 1 >= 0 && levelMap[charY - 1][charX] == 3) {
					win = true;						
				}
				else if(charY - 1 >= 0 && levelMap[charY - 1][charX] == 4) {
					lose = true;
				}
				
//				if(charY - 1 >= 0 && levelMap[charY - 1][charX] == KEY) {
//					key.setTaken(true);
//					door.open();
//				}
			}
			break;
		case 'D':
			if(!player.getMoving() && ((charY + 1 < arrY && levelMap[charY + 1][charX] == 0) 
					||(charY + 1 < arrY && levelMap[charY + 1][charX] == KEY)
					|| ((charY + 1 < arrY && levelMap[charY + 1][charX] == DOOR) && door.getOpen()))) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY + 1][charX] = 2;
					charY += 1;
				} while(((charY + 1 < arrY && levelMap[charY + 1][charX] == 0) 
						||(charY + 1 < arrY && levelMap[charY + 1][charX] == KEY)
						|| ((charY + 1 < arrY && levelMap[charY + 1][charX] == DOOR) && door.getOpen())));
				
				if(charY + 1 < arrY && levelMap[charY + 1][charX] == 3) {
					win = true;
				}
				else if(charY + 1 < arrY && levelMap[charY + 1][charX] == 4) {
					lose = true;
				}
				
//				if(charY + 1 < arrY && levelMap[charY + 1][charX] == KEY) {
//					key.setTaken(true);
//					door.open();
//				}
			}
			break;
		case 'L':
			if(!player.getMoving() && ((charX - 1 >= 0 && levelMap[charY][charX - 1] == 0)
					||(charX - 1 >= 0 && levelMap[charY][charX - 1] == KEY)
					||((levelMap[charY][charX - 1] == DOOR) && door.getOpen()))) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY][charX - 1] = 2;
					charX -= 1;
				} while(((charX - 1 >= 0 && levelMap[charY][charX - 1] == 0)
						||(charX - 1 >= 0 && levelMap[charY][charX - 1] == KEY)
						||((levelMap[charY][charX - 1] == DOOR) && door.getOpen())));
				
				if(charX - 1 >= 0 && levelMap[charY][charX - 1] == 3) { //cek apakah sampai spot menang?
					win = true;
				}
				else if(charX - 1 >= 0 && levelMap[charY][charX - 1] == 4) {
					lose = true;
				}
				
//				if(charX - 1 >= 0 && levelMap[charY][charX - 1] == KEY) {
//					key.setTaken(true);
//					door.open();
//				}
			}
			break;
		default:
			break;
		}
		System.out.println("New X Target: " + charX * getUnitSize() + "New Y Target: " + charY * getUnitSize());
		player.update(charX * getUnitSize(), charY * getUnitSize());
	}
	
	public void attack() {
		if ((levelMap[charY][charX + 1] == TRAP) || (levelMap[charY][charX + 1] == ENEMY)) {
			levelMap[charY][charX + 1] = WALL;
			System.out.println(levelMap[charY][charX + 1]);
			initLevel();
		}
		if ((levelMap[charY][charX - 1] == TRAP) || (levelMap[charY][charX - 1] == ENEMY)) {
			levelMap[charY][charX - 1] = WALL;
			System.out.println(levelMap[charY][charX - 1]);
			initLevel();
		}
		if ((levelMap[charY + 1][charX] == TRAP) || (levelMap[charY + 1][charX] == ENEMY)) {
			levelMap[charY + 1][charX] = WALL;
			System.out.println(levelMap[charY + 1][charX]);
			initLevel();
		}
		if ((levelMap[charY - 1][charX] == TRAP) || (levelMap[charY - 1][charX] == ENEMY)) {
			levelMap[charY - 1][charX] = WALL;
			System.out.println(levelMap[charY - 1][charX]);
			initLevel();
		}
	}
	
	abstract public void initCoin();
	
	abstract public void initLevel();
	
	abstract public void draw(Graphics g, JPanel panel);
	
	abstract public void keyHandler(KeyEvent e);
	
	abstract public Level getNextLevel();
	
	abstract public Level RetryLevel();
	
	public assetManager getAssets() {
		return assets;
	}
}
