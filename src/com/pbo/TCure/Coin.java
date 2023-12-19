package com.pbo.TCure;

import java.awt.Color;	
import java.awt.Graphics;
import java.awt.Image;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class Coin {
	private boolean taken = false;
	private int x, y, width, height;
	private static Image asset;
	private AudioInputStream sfx;
	private Clip clip;
	
	public Coin() {
	}
	
	public Coin(int x, int y, int width, int height, Image img) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		asset = img;
		try {
			this.sfx = AudioSystem.getAudioInputStream(this.getClass().getResource("/sfx/coin.wav"));	
			this.clip = AudioSystem.getClip();
			this.clip.open(this.sfx);
		} catch (Exception e) {
			System.out.println(getClass().getName() + ":");
			System.out.println(e.toString());
		}
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void draw(Graphics g, JPanel panel) {
		if(this.taken) {
			g.setColor(new Color(191, 191, 191, 60));
			g.fillOval(x + width/4, y + height/4, width/2, height/2);
		} else {
			g.setColor(Color.yellow);				
			g.drawImage(asset, x, y, width, height, null);
		}
	}
	
	public boolean collide(int playerX, int playerY) {
		if(this.taken) {
			return false;
		} else if(playerX < (this.x + this.width) && playerX >= this.x && playerY < (this.y + this.height) && playerY >= this.y) {
			clip.setFramePosition(0);
			clip.start();
			this.taken = true;
			return true;
		}
		return false;
	}
}