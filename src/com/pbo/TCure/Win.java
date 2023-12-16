package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Win {
	private int x, y, width, height;
	private static Image asset;
	
	public Win() {	
	}
	
	public Win(int x, int y, int width, int height, Image img) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		asset = img;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void draw(Graphics g, JPanel panel) {
		g.drawImage(asset, x, y, width, height, null);
	}
}
