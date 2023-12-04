package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Coin {
	private boolean get = false;
	private int x, y, width, height;
	private static BufferedImage asset;
	
	public Coin() {
	}
	
	public Coin(int x, int y, int width, int height) {
		URL url = getClass().getResource("Temp-Coin.png");
		File img = new File(url.getPath());
		try {
			asset = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void draw(Graphics g) {
		if(!this.get) {
			g.drawImage(asset, this.x, this.y, width, height, null);
		}
		else {
//			System.out.println("not init");
		}
	}
}