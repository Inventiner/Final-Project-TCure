package com.pbo.TCure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player {
	private boolean init = false;
	private int x, y, width, height;
	private int targetX, targetY, winX, winY;
	private static BufferedImage asset;
	
	public Player() {
	}
	
	public Player(int x, int y, int width, int height) {
		URL url = getClass().getResource("Temp-Player.png");
		File img = new File(url.getPath());
		try {
			asset = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.targetX = x;
		this.targetY = y;
		this.height = height;
		this.width = width;
		this.init = true;
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
	
	public void draw(Graphics g) {
		if(this.init) {
			if(this.x != this.targetX) {
				if(this.x < this.targetX) {
					this.x += 2;
				}
				else{
					this.x -= 2;
				}
			}
			if(this.y != this.targetY) {
				if(this.y < this.targetY) {
					this.y += 2;
				}
				else {
					this.y -= 2;
				}
			}
			
//			System.out.println("init " + asset);
			g.setColor(Color.WHITE);
			g.fillRect(this.x, this.y, width, height);
			g.drawImage(asset, this.x, this.y, width, height, null);
		}
		else {
//			System.out.println("not init");
		}
	}
}