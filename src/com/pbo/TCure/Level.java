package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import org.graalvm.compiler.nodes.java.AbstractNewArrayNode;

abstract public class Level {
	private int[][] level;
	private int width, height, unitSize;
	
	public Level() {		
	}
	
	public Level(int[][] level, int width, int height, int unitSize) {
		this.level = level;
		this.width = width;
		this.height = height;;
		this.unitSize = unitSize;
	}
	
	public int[][] getLevel() {
		return level;
	}

	public void setLevel(int[][] level) {
		this.level = level;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getUnitSize() {
		return unitSize;
	}

	public void setUnitSize(int unitSize) {
		this.unitSize = unitSize;
	}

	abstract public void draw(Graphics g);
	
	abstract public void keyHandler(KeyEvent e);
	
	abstract void drawPlayer(Graphics g);
}
