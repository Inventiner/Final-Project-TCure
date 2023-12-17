package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Bullet {
	private boolean valid = true;
	private int x, y, width, height, vX, vY;
	private static Image asset;
	
	public Bullet() {
	}
	
	public Bullet(int x, int y, int width, int height, Image img, int vX, int vY) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		asset = img;
		this.vX = vX;
		this.vY = vY;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public boolean getStatus() {
		return this.valid;
	}
	
	public void hitwall() {
		this.valid = false;
	}
	
	public void draw(Graphics g, JPanel panel) {
		if(this.valid) {
			x += vX;
			y += vY;
			g.drawImage(asset, x, y, width, height, null);
		} else {
		}
	}
}