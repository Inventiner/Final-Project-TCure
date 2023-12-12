package com.pbo.TCure;

import java.awt.Color;	
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level1 extends Level{
	static JPanel panel;
	static int charX, charY, winX, winY;
	static final int sizeX = 16, sizeY = 16;
	List<Coin> coins;
	// 0 = empty, 1 = wall, 2 = player, 3 = goal / finish
	static final int[][] levelMap = 
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
		super(levelMap, 640, 640, 40);
		this.coins = new ArrayList<>();
		
		// init coins
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
//					System.out.println("i: " + i + " J: " + j);
				switch (coinMap[i][j]) {
				case 1:
					coins.add(new Coin(j * getUnitSize(), i * getUnitSize(), getUnitSize(), getUnitSize()));
				default:
					break;
				}
			}
		}
	}
	
	@Override
	public void draw(Graphics g, JPanel panel) {
		int boxW = getUnitSize();
		int boxH = getUnitSize();
		
		for (Coin coin : coins) {
			coin.draw(g, panel);
		}
		
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
//				System.out.println("i: " + i + " J: " + j);
				switch (levelMap[i][j]) {
				case 0:
//					g.setColor(Color.black);
//					g.fillRect(j * boxW, i * boxH, boxW, boxH);
					break;
				case 1:
					g.setColor(Color.cyan);
					g.fillRect(j * boxW, i * boxH, boxW, boxH);
					break;
				case 2:
					if(!player.getstatus()) {
						charX = j;
						charY = i;
						player = new Player(j * boxW, i * boxH, getUnitSize(), getUnitSize());
						drawPlayer(g, panel);
					}
					break;
				case 3:
					winX = j * boxW;
					winY = i * boxH;
					g.setColor(Color.yellow);
					g.fillRect(j * boxW, i * boxH, boxW, boxH);
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
	
	@Override
	public void drawPlayer(Graphics g, JPanel panel) {
		this.player.draw(g, panel);
	}
	
	public Level getNextLevel() {
		Level next_level = new Level2();
		return next_level;
	}
}
