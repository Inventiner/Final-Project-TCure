package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Player {
	private boolean init = false;
	private int x, y, width, height;
	private int targetX, targetY, winX, winY;
	private int speed;
	private static Image asset;
	
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
		this.init = true;
		this.speed = speed;
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
//			g.setColor(Color.WHITE);
//			g.fillRect(this.x, this.y, width, height);
			g.drawImage(asset, x, y, width, height, panel);
		}
		else {
//			System.out.println("not init");
		}
	}
}