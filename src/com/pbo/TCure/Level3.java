package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Level3 extends Level{
	
	static int winX, winY, keyX, keyY;
	static final int sizeX = 16, sizeY = 16;
	List<Coin> coins;
	List<Wall> walls;	
	List<Trap> traps;	
	// 0 = empty, 1 = wall, 2 = player, 3 = goal / finish
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
		this.coins = new ArrayList<>();
		this.walls = new ArrayList<>();
		this.traps = new ArrayList<>();
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
		walls.clear();
		traps.clear();
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
					player = new Player(j * boxSize, i * boxSize, boxSize, boxSize, 3, assetManager.getPlayer());
					break;
				case WIN:
					winSquare = new Win(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getWin());
					winX = j * boxSize;
					winY = i * boxSize;
					player.setWinX(winX);
					player.setWinY(winY);
					break;
				case TRAP:
					traps.add(new Trap(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getTrap()));
					break;
				case DOOR:
					door = new Door(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getDoor());
					break;
				case KEY:
					key = new Key(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getKey());
					keyX = j * boxSize;
					keyY = i * boxSize;
					break;
				default:
					break;
				}
			}
		}
		door.setKeyX(keyX);
		door.setKeyY(keyY);
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
		return new Level1();
	}
	public Level RetryLevel() {
		return new Level3();
	}
	
	public void MouseHandler(MouseEvent e) {
		if(!player.getMoving())
		this.attack();
	}
}
