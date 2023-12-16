package com.pbo.TCure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Door {
	private boolean open = false; 
	private int keyX, keyY;
	private int x, y, width, height;
	private static Image asset;
	
	public Door() {	
	}
	
	public Door(int x, int y, int width, int height, Image img) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		asset = img;
	}
	
	public int getKeyX() {
		return keyX;
	}
	
	public int getKeyY() {
		return keyY;
	}
	
	public boolean getOpen() {
		return this.open;
	}
	
	public void open() {
		this.open = true;
	}

	public void setKeyX(int keyX) {
		this.keyX = keyX;
	}

	public void setKeyY(int keyY) {
		this.keyY = keyY;
	}
	
	public void draw(Graphics g, JPanel panel) {
		if(this.open) {
			g.setColor(new Color(191, 191, 191, 60));
			g.fillOval(x + width/4, y + height/4, width/2, height/2);
		} else {			
			g.drawImage(asset, x, y, width, height, null);
		}
	}
}
