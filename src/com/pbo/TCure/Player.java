package com.pbo.TCure;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player {
	private boolean init = false;
	private int x, y, width, height;
	private int targetX, targetY, winX, winY;
	private static ImageIcon asset;
	private int health;
	
	public Player() {
	}
	
	public Player(int x, int y, int width, int height) {
		asset = new ImageIcon("file:assets/Temp-Player.png");
		
		this.x = x;
		this.y = y;
		this.targetX = x;
		this.targetY = y;
		this.height = height;
		this.width = width;
		this.init = true;
		this.health = 3;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean getstatus() {
		return this.init;
	}
	
	public void update(int x, int y) {
		this.targetX = x;
		this.targetY = y;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setWinX(int winX) {
		this.winX = winX;
	}

	public void setWinY(int winY) {
		this.winY = winY;
	}

	public boolean isWin() {
		return(this.winX == this.x && this.winY == this.y);
	}
	
	public boolean getMoving() {
		if(this.x != this.targetX || this.y != this.targetY) {
			return true;
		} else {
			return false;
		}
	}
	
	public void draw(Graphics g, JPanel panel) {
		if(this.init) {
			if(this.x != this.targetX) {
				if(this.x < this.targetX && this.x + 2 < this.targetX) {
					this.x += 2;
				}
				else if(this.x > this.targetX && this.x - 2 > this.targetX) {
					this.x -= 2;
				}
				else {
					this.x = this.targetX;
				}
			}
			if(this.y != this.targetY) {
				if(this.y < this.targetY && this.y + 2 < this.targetY) {
					this.y += 2;
				}
				else if(this.y > this.targetY && this.y - 2 > this.targetY) {
					this.y -= 2;
				}
				else {
					this.y = this.targetY;
				}
			}
			
//			System.out.println("init " + asset);
			g.setColor(Color.WHITE);
			g.fillRect(this.x, this.y, width, height);
			asset.paintIcon(panel, g, this.x, this.y);
		}
		else {
//			System.out.println("not init");
		}
	}
}