package com.pbo.TCure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Coin {
	private boolean get = false;
	private int x, y, width, height;
	private static ImageIcon asset;
	
	public Coin() {
	}
	
	public Coin(int x, int y, int width, int height) {
		asset = new ImageIcon("file:assets/Temp-Coin.png");
	
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public boolean getstatus() {
		return this.get;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void draw(Graphics g, JPanel panel) {
		if(!this.get) {
			g.setColor(Color.yellow);
			g.fillOval(x, y, width, height);
			asset.paintIcon(panel, g, this.x, this.y);
		}
		else {
//			System.out.println("not init");
		}
	}
}