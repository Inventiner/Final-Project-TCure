package com.pbo.TCure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Level2 extends Level{
	
	static int charX, charY, winX, winY;
	static final int sizeX = 16, sizeY = 16;
	List<Coin> coins;
	List<Wall> walls;	
	List<Trap> traps;	
	// 0 = empty, 1 = wall, 2 = player, 3 = goal / finish
	static final int[][] levelMapTemplate = 
		   {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 4, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
	
	static final int[][] coinMap = 
		   {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	public Level2() {
		super(levelMapTemplate, 720, 720, 45);
		this.player = new Player();
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
					player.setCoord(j * boxSize, i * boxSize);
					break;
				case WIN:
					winX = j * boxSize;
					winY = i * boxSize;
					player.setWinX(winX);
					player.setWinY(winY);
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
		
		this.player.draw(g, panel);
		
		// draw win zone
		g.setColor(Color.yellow);
		g.fillRect(winX, winY, getUnitSize(), getUnitSize());
	}
	
	@Override
	public void keyHandler(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(!player.getMoving() && charX + 1 < sizeX && levelMap[charY][charX + 1] == 0) { //cek apakah bisa gerak ke arah tsb
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY][charX + 1] = 2;
					charX += 1;
				} while(levelMap[charY][charX + 1] == 0); //gerak terus hingga nabrak tembok / menang / kena musuh (TBA)
				
				if(charX + 1 < sizeX && levelMap[charY][charX + 1] == 3) { //cek apakah sampai spot menang
					win = true;
				}				
				else if(charX + 1 < sizeX && levelMap[charY][charX + 1] == 4) { //cek apakah sampai spot menang
					lose = true;
				}
			}
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(!player.getMoving() && charY - 1 >= 0 && levelMap[charY - 1][charX] == 0) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY - 1][charX] = 2;
					charY -= 1;
				} while(levelMap[charY - 1][charX] == 0);
				
				if(charY - 1 >= 0 && levelMap[charY - 1][charX] == 3) { //cek apakah sampai spot menang
					levelMap[charY][charX] = 0;
					levelMap[charY - 1][charX] = 2;
					win = true;						
				}
				else if(charY - 1 >= 0 && levelMap[charY - 1][charX] == 4) { //cek apakah sampai spot menang
					lose = true;
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			if(!player.getMoving() && charY + 1 < sizeY && levelMap[charY + 1][charX] == 0) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY + 1][charX] = 2;
					charY += 1;
					System.out.println("stopping at" + charX + ", " + charY);
				} while(levelMap[charY + 1][charX] == 0);
				
				if(charY + 1 >= 0 && levelMap[charY + 1][charX] == 3) { //cek apakah sampai spot menang
					levelMap[charY][charX] = 0;
					levelMap[charY + 1][charX] = 2;
					win = true;
				}
				else if(charY + 1 >= 0 && levelMap[charY + 1][charX] == 4) {
					lose = true;
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			if(!player.getMoving() && charX - 1 >= 0 && levelMap[charY][charX - 1] == 0) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY][charX - 1] = 2;
					charX -= 1;
				} while(levelMap[charY][charX - 1] == 0);
				
				if(charX - 1 < sizeX && levelMap[charY][charX - 1] == 3) { //cek apakah sampai spot menang?
					levelMap[charY][charX] = 0;
					levelMap[charY][charX - 1] = 2;
					win = true;
				}
				else if(charX - 1 < sizeX && levelMap[charY][charX - 1] == 4) {
					lose = true;
				}
			}
		}
		System.out.println("New X Target: " + charX * getUnitSize() + "New Y Target: " + charY * getUnitSize());
		player.update(charX * getUnitSize(), charY * getUnitSize());
	}
	
	public Level getNextLevel() {
		return new Level1();
	}
}
