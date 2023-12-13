package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Player {
	private int x, y, width, height;
	private int targetX, targetY, winX, winY;
	private int speed;
	private static Image asset;
	private int health;
	
	public Player() {
	}
	
	public Player(int x, int y, int width, int height, int speed, Image img) {
		asset = img;
		this.x = x;
		this.y = y;
		this.targetX = x;
		this.targetY = y;
		this.height = height;
		this.width = width;
		this.speed = speed;
		this.health = 3;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void update(int x, int y) {
		this.targetX = x;
		this.targetY = y;
	}
	
	public void setCoord(int x, int y) {
		this.x = x;
		this.y = y;
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
		if(this.x != this.targetX) {
			if(this.x < this.targetX && this.x + this.speed < this.targetX) {
				this.x += this.speed;
			}
			else if(this.x > this.targetX && this.x - this.speed > this.targetX) {
				this.x -= this.speed;
			}
			else {
				this.x = this.targetX;
			}
		}
		if(this.y != this.targetY) {
			if(this.y < this.targetY && this.y + this.speed < this.targetY) {
				this.y += this.speed;
			}
			else if(this.y > this.targetY && this.y - this.speed > this.targetY) {
				this.y -= this.speed;
			}
			else {
				this.y = this.targetY;
			}
		}
		g.drawImage(asset, x, y, width, height, null);
	}
}