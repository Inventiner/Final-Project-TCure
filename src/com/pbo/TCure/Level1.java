package com.pbo.TCure;

import java.awt.Color;	
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Level1 extends Level{
	static JPanel panel;
	static int charX, charY, winX, winY;
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
		super(levelMapTemplate, 640, 640, 40);
		this.player = new Player();
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
				case 1:
					walls.add(new Wall(j * boxSize, i * boxSize, boxSize, boxSize, assetManager.getWall()));
					break;
				case 2:
					charX = j;
					charY = i;
					player = new Player(j * boxSize, i * boxSize, boxSize, boxSize, 3, assetManager.getPlayer());
					player.setCoord(j * boxSize, i * boxSize);
					break;
				case 3:
					winX = j * boxSize;
					winY = i * boxSize;
					player.setWinX(winX);
					player.setWinY(winY);
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
			}
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(!player.getMoving() && charY - 1 >= 0 && levelMap[charY - 1][charX] == 0) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY - 1][charX] = 2;
					charY -= 1;
				} while(levelMap[charY - 1][charX] != 1 && levelMap[charY - 1][charX] != 3);
				
				if(charY - 1 >= 0 && levelMap[charY - 1][charX] == 3) { //cek apakah sampai spot menang
					//level[charY][charX] = 0;
					//level[charY - 1][charX] = 2;
					//charY -= 1;
					//player.update(charX * getUnitSize(), charY * getUnitSize());
					//if(player.isWin()) {
						win = true;						
					//}
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			if(!player.getMoving() && charY + 1 < sizeY && levelMap[charY + 1][charX] == 0) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY + 1][charX] = 2;
					charY += 1;
				} while(levelMap[charY + 1][charX] != 1 && levelMap[charY + 1][charX] != 3);
				
				if(charY + 1 >= 0 && levelMap[charY + 1][charX] == 3)
				{ //cek apakah sampai spot menang
					levelMap[charY][charX] = 0;
					levelMap[charY + 1][charX] = 2;
					win = true;
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			if(!player.getMoving() && charX - 1 >= 0 && levelMap[charY][charX - 1] == 0) {
				do {
					levelMap[charY][charX] = 0;
					levelMap[charY][charX - 1] = 2;
					charX -= 1;
				} while(levelMap[charY][charX - 1] != 1 && levelMap[charY][charX - 1] != 3);
				
				if(charX - 1 < sizeX && levelMap[charY][charX - 1] == 3) { //cek apakah sampai spot menang?
					win = true;
				}
			}
		}
		System.out.println("New X Target: " + charX * getUnitSize() + "New Y Target: " + charY * getUnitSize());
		player.update(charX * getUnitSize(), charY * getUnitSize());
	}
	
	public Level getNextLevel() {
		return new Level2();
	}
}
