package com.pbo.TCure;

import java.awt.image.BufferedImage;	
import javax.imageio.ImageIO;

public class assetManager {
	private static BufferedImage wall, coin, player, trap, door, key, win, att, enemy;
	public assetManager() {
		try {
			wall = ImageIO.read(getClass().getResource("/assets/Temp-Brain.png"));
			coin = ImageIO.read(getClass().getResource("/assets/WBC.png"));
			player = ImageIO.read(getClass().getResource("/assets/Temp-Player.png"));
			trap = ImageIO.read(getClass().getResource("/assets/Temp-Trap.png"));
			door = ImageIO.read(getClass().getResource("/assets/Temp-Door.png"));
			key = ImageIO.read(getClass().getResource("/assets/Temp-key.png"));
			win = ImageIO.read(getClass().getResource("/assets/Temp-Win.png"));
			att = ImageIO.read(getClass().getResource("/assets/attack.png"));
			enemy = ImageIO.read(getClass().getResource("/assets/Temp-Enemy.png"));
		} catch (Exception e) {
			System.out.println("Error when reading Image!");
			System.out.println(e.toString()); 
		}	
	}
	public static BufferedImage getWall() {
		return wall;
	}
	public static BufferedImage getCoin() {
		return coin;
	}
	public static BufferedImage getPlayer() {
		return player;
	}	
	public static BufferedImage getTrap() {
		return trap;
	}	
	public static BufferedImage getDoor() {
		return door;
	}	
	public static BufferedImage getKey() {
		return key;
	}	
	public static BufferedImage getWin() {
		return win;
	}	
	public static BufferedImage getAtt() {
		return att;
	}
	public static BufferedImage getEnemy() {
		return enemy;
	}
}
