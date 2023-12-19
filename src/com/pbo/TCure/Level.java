package com.pbo.TCure;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
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
	static int winX, winY, keyX, keyY;
	protected int point;
	protected Win winSquare;
	protected Door door;
	protected Key key;
	protected Player player;
	protected int[][] levelMap;
	private int width, height, unitSize;
	boolean win = false, lose = false;
	private Dimension currDimension;
	protected assetManager assets;
	protected static final int EMPTY = 0, WALL = 1, PLAYER = 2, WIN = 3, TRAP = 4, DOOR = 5, KEY = 6, ENEMY = 7;
	protected static int charX, charY, arrX, arrY;
	protected List<Coin> coins;
	protected List<Wall> walls;	
	protected List<Trap> traps;	
	protected List<Enemy> enemies;
	
	public Level() {
	}
	
	public Level(int[][] level, int width, int height, int unitSize) {
		this.assets = new assetManager();
		this.width = width;
		this.height = height;
		this.unitSize = unitSize;
		this.point = 0;
		this.currDimension = new Dimension(width, height);
		this.coins = new ArrayList<>();
		this.walls = new ArrayList<>();
		this.traps = new ArrayList<>();
		this.enemies = new ArrayList<>();
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
	
	public void initCoin(int[][] coinMap) {
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
				if(coinMap[i][j] == 1) {
					this.coins.add(new Coin(j * getUnitSize(), i * getUnitSize(), getUnitSize(), getUnitSize(), assetManager.getCoin()));
				}
			}
		}
	}
	
	public void initLevel(Level curr_level) {
		int boxSize = getUnitSize();
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
				switch (levelMap[i][j]) {
				case WALL:
					this.walls.add(new Wall(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getWall()));
					break;
				case PLAYER:
					charX = j;
					charY = i;
					this.player = new Player(j * boxSize, i * boxSize, boxSize, boxSize, 3, assetManager.getPlayer(), assetManager.getAtt());
					break;
				case WIN:
					this.winSquare = new Win(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getWin());
					winX = j * boxSize;
					winY = i * boxSize;
					break;
				case TRAP:
					this.traps.add(new Trap(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getTrap()));
					break;
				case DOOR:
					this.door = new Door(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getDoor());
					break;
				case KEY:
					this.key = new Key(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getKey());
					keyX = j * boxSize;
					keyY = i * boxSize;
					break;
				case ENEMY:
					this.enemies.add(new Enemy(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getEnemy(), assetManager.getKey(), levelMap, curr_level));
					break;
				default:
					break;
				}
			}
		}
		for(Enemy enemy: enemies) {
			enemy.setPlayer(this.player);
		}
		player.setWinX(winX);
		player.setWinY(winY);
		if(door != null) {
			door.setKeyX(keyX);
			door.setKeyY(keyY);
		}
	}
	
	public void redrawLevel() {
		walls.clear();
		traps.clear();
		int boxSize = getUnitSize();
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
				switch (levelMap[i][j]) {
				case WALL:
					walls.add(new Wall(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getWall()));
					break;
				case TRAP:
					traps.add(new Trap(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getTrap()));
					break;
				default:
					break;
				}
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
				
				if(charX + 1 < arrX && levelMap[charY][charX + 1] == WIN) { //cek apakah sampai spot menang
					win = true;
				}
				else if(charX + 1 < arrX && levelMap[charY][charX + 1] == TRAP) { //cek apakah sampai spot kalah
					dead();
				}
				
//				if(charX + 1 < arrX && levelMap[charY][charX + 1] == KEY) {
//					key.setTaken(true);
//					door.open();
//				}
			} else if(!player.getMoving() && (charX + 1 < arrX && levelMap[charY][charX + 1] == WIN)) {
				win = true;
			} else if(!player.getMoving() && (charX + 1 < arrX && levelMap[charY][charX + 1] == TRAP)) {
				dead();
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
				
				if(charY - 1 >= 0 && levelMap[charY - 1][charX] == WIN) {
					win = true;						
				}
				else if(charY - 1 >= 0 && levelMap[charY - 1][charX] == TRAP) {
					dead();
				}
				
//				if(charY - 1 >= 0 && levelMap[charY - 1][charX] == KEY) {
//					key.setTaken(true);
//					door.open();
//				}
			} else if(!player.getMoving() && (charY - 1 >= 0 && levelMap[charY - 1][charX] == WIN)) {
				win = true;
			} else if(!player.getMoving() && (charY - 1 >= 0 && levelMap[charY - 1][charX] == TRAP)) {
				dead();
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
				
				if(charY + 1 < arrY && levelMap[charY + 1][charX] == WIN) {
					win = true;
				}
				else if(charY + 1 < arrY && levelMap[charY + 1][charX] == TRAP) {
					dead();
				}
				
//				if(charY + 1 < arrY && levelMap[charY + 1][charX] == KEY) {
//					key.setTaken(true);
//					door.open();
//				}
			} else if(!player.getMoving() && (charY + 1 < arrY && levelMap[charY + 1][charX] == WIN)) {
				win = true;
			} else if(!player.getMoving() && (charY + 1 < arrY && levelMap[charY + 1][charX] == TRAP)) {
				dead();
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
					dead();
				}
				
//				if(charX - 1 >= 0 && levelMap[charY][charX - 1] == KEY) {
//					key.setTaken(true);
//					door.open();
//				}
			} else if(!player.getMoving() && (charX - 1 >= 0 && levelMap[charY][charX - 1] == WIN)) {
				win = true;
			} else if(!player.getMoving() && (charX - 1 >= 0 && levelMap[charY][charX - 1] == TRAP)) {
				dead();
			}
			break;
		default:
			break;
		}
		player.update(charX * getUnitSize(), charY * getUnitSize());
		System.out.println("New X Target: " + charX * getUnitSize() + "New Y Target: " + charY * getUnitSize());
	}
	
	public void dead() {
		lose = true;
	}
	
	public void attack() {
		player.attack();
		if (levelMap[charY][charX + 1] == TRAP) {
			levelMap[charY][charX + 1] = WALL;
			System.out.println(levelMap[charY][charX + 1]);
			redrawLevel();
		} else if (levelMap[charY][charX + 1] == ENEMY) {
		}
		
		
		if (levelMap[charY][charX - 1] == TRAP) {
			levelMap[charY][charX - 1] = WALL;
			System.out.println(levelMap[charY][charX - 1]);
			redrawLevel();
		} else if (levelMap[charY][charX - 1] == ENEMY) {
		}
		
		
		if (levelMap[charY + 1][charX] == TRAP) {
			levelMap[charY + 1][charX] = WALL;
			System.out.println(levelMap[charY + 1][charX]);
			redrawLevel();	
		} else if (levelMap[charY + 1][charX] == ENEMY) {
		}
		
		
		if (levelMap[charY - 1][charX] == TRAP) { 
			levelMap[charY - 1][charX] = WALL;
			System.out.println(levelMap[charY - 1][charX]);
			redrawLevel();			
		} else if (levelMap[charY - 1][charX] == ENEMY) {
		}
		if (levelMap[charY - 1][charX - 1] == TRAP) { 
			levelMap[charY - 1][charX - 1] = WALL;
			System.out.println(levelMap[charY - 1][charX]);
			redrawLevel();			
		} else if (levelMap[charY - 1][charX - 1] == ENEMY) {
		}
		if (levelMap[charY - 1][charX + 1] == TRAP) { 
			levelMap[charY - 1][charX + 1] = WALL;
			System.out.println(levelMap[charY - 1][charX]);
			redrawLevel();			
		} else if (levelMap[charY - 1][charX - 1] == ENEMY) {
		}
		if (levelMap[charY + 1][charX + 1] == TRAP) { 
			levelMap[charY + 1][charX + 1] = WALL;
			System.out.println(levelMap[charY - 1][charX]);
			redrawLevel();			
		} else if (levelMap[charY - 1][charX - 1] == ENEMY) {
		}
		if (levelMap[charY + 1][charX - 1] == TRAP) { 
			levelMap[charY + 1][charX - 1] = WALL;
			System.out.println(levelMap[charY - 1][charX]);
			redrawLevel();			
		} else if (levelMap[charY - 1][charX - 1] == ENEMY) {
		}
	}
	
	abstract public void draw(Graphics g, JPanel panel);
	
	abstract public void keyHandler(KeyEvent e);
	
	abstract public Level getNextLevel();
	
	abstract public Level RetryLevel();
	
	public assetManager getAssets() {
		return assets;
	}
}
