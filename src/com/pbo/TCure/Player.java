package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Player {
	private boolean attacking, alive;
	private int x, y, width, height;
	private int targetX, targetY, winX, winY;
	private int speed;
	private static Image asset, attack;
	private int count = 0;
	
	public Player() {
	}
	
	public Player(int x, int y, int width, int height, int speed, Image img, Image att) {
		this.alive = true;
		this.attacking = false;
		asset = img;
		attack = att;
		this.x = x;
		this.y = y;
		this.targetX = x;
		this.targetY = y;
		this.height = height;
		this.width = width;
		this.speed = speed;
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
		
		if(this.attacking) {
			this.count++;
			g.drawImage(attack, x-width, y-height, width * 3, height * 3, null);
			if(count % 50 == 0) {
				this.attacking = false;				
			}
		}
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void collide(int bulletX, int bulletY) {
		if(this.x < (bulletX + this.width) && this.x >= bulletX && this.y < (bulletY + this.height) && this.y >= bulletY) {
			this.alive = false;
		}
	}
	
	public void attack() {
		this.attacking = true;
	}
}