package com.pbo.TCure;

import java.awt.image.BufferedImage;	
import javax.imageio.ImageIO;

public class assetManager {
	private static BufferedImage wall, coin, player, trap, door, key, win, att, enemy
	, playeridle1, playeridle2, playeridle3, playeridle4;
	public assetManager() {
		try {
			wall = ImageIO.read(getClass().getResource("/assets/Temp-Brain.png"));
			coin = ImageIO.read(getClass().getResource("/assets/WBC.png"));
			player = ImageIO.read(getClass().getResource("/assets/Temp-Player.png"));
			trap = ImageIO.read(getClass().getResource("/assets/Temp-Trap.png"));
			door = ImageIO.read(getClass().getResource("/assets/Temp-Door.png"));
			key = ImageIO.read(getClass().getResource("/assets/Temp-Key.png"));
			win = ImageIO.read(getClass().getResource("/assets/Temp-Win.png"));
			enemy = ImageIO.read(getClass().getResource("/assets/Temp-Enemy.png"));
			
			//Player Idle
			playeridle1 = ImageIO.read(getClass().getResource("/assets/PlayerIdle1.png"));
			playeridle2 = ImageIO.read(getClass().getResource("/assets/PlayerIdle1.png"));
			playeridle3 = ImageIO.read(getClass().getResource("/assets/PlayerIdle1.png"));
			playeridle4 = ImageIO.read(getClass().getResource("/assets/PlayerIdle1.png"));
			
			//Player Move
			
			
			
		} catch (Exception e) {
			System.out.println("Error when reading Image! in assetmanager");
			e.printStackTrace(); 
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
	public static BufferedImage getPlayeridle1() {
		return playeridle1;
	}
	public static BufferedImage getPlayeridle2() {
		return playeridle2;
	}
	public static BufferedImage getPlayeridle3() {
		return playeridle3;
	}
	public static BufferedImage getPlayeridle4() {
		return playeridle4;
	}
	
}
