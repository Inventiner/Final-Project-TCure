package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Enemy {
	private boolean alive = true;
	private int x, y, width, height;
	private static Image asset, bulletAsset;
	private int[][] map;
	protected List<Bullet> bullets;
	private int count = 0;
	private Player player;
	
	public Enemy() {
	}
	
	public Enemy(int x, int y, int width, int height, Image img, Image bullet, int[][] map) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		asset = img;
		bulletAsset = bullet;
		this.map = map;
		bullets = new ArrayList<>();
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void draw(Graphics g, JPanel panel) {
		if(this.alive) {				
			g.drawImage(asset, x, y, width, height, null);
			
			if(count % 200 == 0) {
				if(map[y/height - 1][x/width] == 0) {
					bullets.add(new Bullet(x, (y - height), width, height, bulletAsset, 0, -1));
				}
				
				if(map[y/height + 1][x/width] == 0) {
					bullets.add(new Bullet(x, (y + height), width, height, bulletAsset, 0, 1));
				}
				
				if(map[y/height][x/width - 1] == 0) {
					bullets.add(new Bullet(x - height, y, width, height, bulletAsset, -1, 0));
				}
				
				if(map[y/height][x/width + 1] == 0) {
					bullets.add(new Bullet(x + height, y, width, height, bulletAsset, 1, 0));
				}
				count = 0;
			}
			count++;
		}
		
		bullets.removeIf(b -> !b.getStatus());
		
		for(Bullet bullet : bullets) {
			if(map[bullet.getY()/height][bullet.getX()/width] != 0) {
				bullet.hitwall();
			}
			if(player.getX() == -1) {
				// To Do Collision checker
			}
			bullet.draw(g, panel);
		}
	}
}