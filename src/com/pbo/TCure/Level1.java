package com.pbo.TCure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Level1 extends Level{
	Player player = new Player();
	static int charX, charY;
	static boolean moving;
	static final int sizeX = 16, sizeY = 16;
	static final int[][] level = 
		   {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
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
	
	public Level1() {
		super();
	}
	
	public Level1(int width, int height, int unitSize) {
		super(level, width, height, unitSize);
		moving = false;
	}
	
	@Override
	public void draw(Graphics g) {
		int boxW = getUnitSize();
		int boxH = getUnitSize();
		for(int i = 0; i < getHeight()/getUnitSize(); i++) {
			for(int j = 0; j < getWidth()/getUnitSize(); j++) {
//				System.out.println("i: " + i + " J: " + j);
				switch (level[i][j]) {
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
						drawPlayer(g);
					}
					else {
						charX = j;
						charY = i;
						player.update(j * boxW, i * boxH);
					}
					break;
					
				default:
					break;
				}
			}
		}
	}
	
	@Override
	public void keyHandler(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(!moving && charX + 1 < sizeX && level[charY][charX + 1] == 0) {
				moving = true;
				do {
					level[charY][charX] = 0;
					level[charY][charX + 1] = 2;
					charX += 1;
				} while(level[charY][charX + 1] != 1);
				moving = false;
			}
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(!moving && level[charY - 1][charX] == 0) {
				moving = true;
				do {
					level[charY][charX] = 0;
					level[charY - 1][charX] = 2;
					charY -= 1;
					moving = true;
					if(charY - 1 >= 0) {
						break;
					}
				} while(level[charY - 1][charX] != 1);
				moving = false;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			if(!moving && charY + 1 < sizeY && level[charY + 1][charX] == 0) {
				moving = true;
				do {
					level[charY][charX] = 0;
					level[charY + 1][charX] = 2;
					charY += 1;
				} while(level[charY + 1][charX] != 1);
				moving = false;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			if(!moving && charX - 1 >= 0 && level[charY][charX - 1] == 0) {
				moving = true;
				do {
					level[charY][charX] = 0;
					level[charY][charX - 1] = 2;
					charX -= 1;
				} while(level[charY][charX - 1] != 1);
				moving = false;
			}
		}
		
	}
	
	@Override
	public void drawPlayer(Graphics g) {
		this.player.draw(g);
	}
}
