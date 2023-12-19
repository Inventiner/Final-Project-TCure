package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Player {
	private boolean attacking, alive;
	private int x, y, width, height;
	private int targetX, targetY, winX, winY;
	private int speed;
	private static BufferedImage idleR1, idleR2, idleR3, idleR4, 
								idleL1, idleL2, idleL3, idleL4, 
								attack1, attack2, attack3, attack4, attack5, attack6, attack7, attack8, attack9, attack10,
								 attack11, attack12, attack13, attack14;
	private int ShieldCount = 0;
	private int ShieldNum = 1;
	private int SpriteCount = 0;
	private int SpriteNum = 1;
	
	
	public Player() {
	}
	
	public Player(int x, int y, int width, int height, int speed, Image img, Image att) {
		this.alive = true;
		this.attacking = false;
		this.x = x;
		this.y = y;
		this.targetX = x;
		this.targetY = y;
		this.height = height;
		this.width = width;
		this.speed = speed;
		getplayerimage();
	}
	
	public void getplayerimage() {
		try {
			//Player Idle
			idleR1 = ImageIO.read(getClass().getResource("/assets/PlayerIdle1.png"));
			idleR2 = ImageIO.read(getClass().getResource("/assets/PlayerIdle2.png"));
			idleR3 = ImageIO.read(getClass().getResource("/assets/PlayerIdle3.png"));
			idleR4 = ImageIO.read(getClass().getResource("/assets/PlayerIdle4.png"));
			
			//Player Move
			idleL1 = ImageIO.read(getClass().getResource("/assets/PlayerIdleLeft1.png"));
			idleL2 = ImageIO.read(getClass().getResource("/assets/PlayerIdleLeft2.png"));
			idleL3 = ImageIO.read(getClass().getResource("/assets/PlayerIdleLeft3.png"));
			idleL4 = ImageIO.read(getClass().getResource("/assets/PlayerIdleLeft4.png"));
			
			//attack
			attack1 = ImageIO.read(getClass().getResource("/assets/attack1.png"));
			attack2 = ImageIO.read(getClass().getResource("/assets/attack2.png"));
			attack3 = ImageIO.read(getClass().getResource("/assets/attack3.png"));
			attack4 = ImageIO.read(getClass().getResource("/assets/attack4.png"));
			attack5 = ImageIO.read(getClass().getResource("/assets/attack5.png"));
			attack6 = ImageIO.read(getClass().getResource("/assets/attack6.png"));
			attack7 = ImageIO.read(getClass().getResource("/assets/attack7.png"));
			attack8 = ImageIO.read(getClass().getResource("/assets/attack8.png"));
			attack9 = ImageIO.read(getClass().getResource("/assets/attack9.png"));
			attack10 = ImageIO.read(getClass().getResource("/assets/attack10.png"));
			attack11 = ImageIO.read(getClass().getResource("/assets/attack11.png"));
			attack12 = ImageIO.read(getClass().getResource("/assets/attack12.png"));
			attack13 = ImageIO.read(getClass().getResource("/assets/attack13.png"));
			attack14 = ImageIO.read(getClass().getResource("/assets/attack14.png"));
			
		} catch (Exception e) {
			System.out.println("Error when reading Image!");
			System.out.println(e.toString()); 
		}	
	}
	
	public void update(int x, int y) {
		this.targetX = x;
		this.targetY = y;
	}
	
	public void setCoord(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	public void draw(Graphics g, JPanel panel) {
		
		BufferedImage image = null;
		BufferedImage attackimage = null;
		
		if(this.x == this.targetX && this.y == this.targetY) {
			if(this.SpriteNum == 1) image = idleR1;
			if(this.SpriteNum == 2) image = idleR2;
			if(this.SpriteNum == 3) image = idleR3;
			if(this.SpriteNum == 4) image = idleR4;
		}
		
		if(this.x != this.targetX) {
			//kanan
			if(this.x < this.targetX && this.x + this.speed < this.targetX) {
				this.x += this.speed;
				if(this.SpriteNum == 1) image = idleR1;
				if(this.SpriteNum == 2) image = idleR2;
				if(this.SpriteNum == 3) image = idleR3;
				if(this.SpriteNum == 4) image = idleR4;
			}
			//kiri
			else if(this.x > this.targetX && this.x - this.speed > this.targetX) {
				if(this.SpriteNum == 1) image = idleL1;
				if(this.SpriteNum == 2) image = idleL2;
				if(this.SpriteNum == 3) image = idleL3;
				if(this.SpriteNum == 4) image = idleL4;
				this.x -= this.speed;
			}
			else {
				this.x = this.targetX;
			}
		}
		
		if(this.y != this.targetY) {
			//turun
			if(this.y < this.targetY && this.y + this.speed < this.targetY) {
				if(this.SpriteNum == 1) image = idleR1;
				if(this.SpriteNum == 2) image = idleR2;
				if(this.SpriteNum == 3) image = idleR3;
				if(this.SpriteNum == 4) image = idleR4;
				this.y += this.speed;
			}
			//naik
			else if(this.y > this.targetY && this.y - this.speed > this.targetY) {
				if(this.SpriteNum == 1) image = idleR1;
				if(this.SpriteNum == 2) image = idleR2;
				if(this.SpriteNum == 3) image = idleR3;
				if(this.SpriteNum == 4) image = idleR4;
				this.y -= this.speed;
			}
			else {
				this.y = this.targetY;
			}
		}
		
		this.SpriteCount++;
		if(this.SpriteCount>100){
			if(this.SpriteNum == 1) {
				this.SpriteNum = 2;
			}
			else if(this.SpriteNum == 2) {
				this.SpriteNum = 3;
			}
			else if(this.SpriteNum == 3) {
				this.SpriteNum = 4;
			}
			else if(this.SpriteNum == 4) {
				this.SpriteNum = 1;
			}
			this.SpriteCount = 0;
		}
		
		g.drawImage(image, x, y, width, height, null);
		
		if(this.attacking) {
			this.ShieldCount++;
			if(this.ShieldCount>30){
				if(this.ShieldNum == 1) {
					this.ShieldNum = 2;
				}
				else if(this.ShieldNum == 2) {
					this.ShieldNum = 3;
				}
				else if(this.ShieldNum == 3) {
					this.ShieldNum = 4;
				}
				else if(this.ShieldNum == 4) {
					this.ShieldNum = 5;
				}
				else if(this.ShieldNum == 5) {
					this.ShieldNum = 6;
				}
				else if(this.ShieldNum == 6) {
					this.ShieldNum = 7;
				}
				else if(this.ShieldNum == 7) {
					this.ShieldNum = 8;
				}
				else if(this.ShieldNum == 8) {
					this.ShieldNum = 9;
				}
				else if(this.ShieldNum == 9) {
					this.ShieldNum = 10;
				}
				else if(this.ShieldNum == 10) {
					this.ShieldNum = 11;
				}
				else if(this.ShieldNum == 11) {
					this.ShieldNum = 12;
				}
				else if(this.ShieldNum == 12) {
					this.ShieldNum = 13;
				}
				else if(this.ShieldNum == 13) {
					this.ShieldNum = 14;
				}
				else if(this.ShieldNum == 14) {
					this.ShieldNum = 1;
					this.attacking = false;	
				}
			}
				if(this.ShieldNum == 1) attackimage = attack1;
				if(this.ShieldNum == 2) attackimage = attack2;
				if(this.ShieldNum == 3) attackimage = attack3;
				if(this.ShieldNum == 4) attackimage = attack4;
				if(this.ShieldNum == 5) attackimage = attack5;
				if(this.ShieldNum == 6) attackimage = attack6;
				if(this.ShieldNum == 7) attackimage = attack7;
				if(this.ShieldNum == 8) attackimage = attack8;
				if(this.ShieldNum == 9) attackimage = attack9;
				if(this.ShieldNum == 10) attackimage = attack10;
				if(this.ShieldNum == 11) attackimage = attack11;
				if(this.ShieldNum == 12) attackimage = attack12;
				if(this.ShieldNum == 13) attackimage = attack13;
				if(this.ShieldNum == 14) attackimage = attack14;
				g.drawImage(attackimage, x-width, y-height, width * 3, height * 3, null);
		}
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void collide(int bulletX, int bulletY) {
		if(this.x < (bulletX + this.width) && this.x >= bulletX && this.y < (bulletY + this.height) && this.y >= bulletY) {
			this.alive = false;
		}
	}
	
	public void attack() {
		this.attacking = true;
	}
}