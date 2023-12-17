package com.pbo.TCure;

import java.awt.Color;	
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener, MouseListener{
	static private JFrame gameFrame;
	static int areaWidth, areaHeight, UNIT_SIZE;
	protected static Level curr_level;
	static final int DELAY = 75;
	boolean running = false;
	boolean win = false;
	Timer timer;
	Random random;
	private static int level_index = 1;

	public GamePanel(JFrame masterFrame) {
		gameFrame = masterFrame;
		curr_level = new Level1();
		addMouseListener(this);
		addKeyListener(this);
		setPreferredSize(curr_level.getCurrDimension());
		areaWidth = curr_level.getWidth();
		areaHeight = curr_level.getHeight();
		UNIT_SIZE = curr_level.getUnitSize();
		setBackground(Color.BLACK);
		setFocusable(true);
        

		startGame();
	}
	
	public void changeLevel(Level level) {
		removeAll();
		System.out.println(curr_level);
		curr_level = level;
		System.out.println(curr_level);
		setPreferredSize(curr_level.getCurrDimension());
		areaWidth = curr_level.getWidth();
		areaHeight = curr_level.getHeight();
		UNIT_SIZE = curr_level.getUnitSize();
		gameFrame.pack();
		startGame();
		validate();
		repaint();
	}
	
	public void startGame() {
		running = true;
		timer = new Timer();			
	}

	// Draw Grid For Easy seeing grid
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//draw grid
		g.setColor(new Color(151,151,151,90));
		for(int i = 0; i < areaHeight/UNIT_SIZE; i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, areaHeight);
		}
		for(int i = 0; i < areaWidth/UNIT_SIZE; i++) {
			g.drawLine(0, i*UNIT_SIZE, areaWidth, i*UNIT_SIZE);
		}
		

		draw(g);
	}

	public void draw(Graphics g) {
		if((curr_level.getWin() || curr_level.getLose()) && !curr_level.getPlayer().getMoving()) {
			running = false;
		}
		if(running) {
			curr_level.draw(g, this);
		} else if(curr_level.getWin()) {
			win();
		} else if (curr_level.getLose()) {
			Lose();
		}
		repaint();
	}

	public void YouWin(Graphics g) {
//		g.setColor(Color.GREEN);
//		g.setFont(new Font("Ink Free", Font.BOLD, 75));
//		FontMetrics metrics = getFontMetrics(g.getFont());
//		g.drawString("YOU WIN!!!", (areaWidth - metrics.stringWidth("YOU WIN!!!"))/2, areaHeight/2);
		win();
	}
	
	public int getLevel() {
		return GamePanel.level_index;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		curr_level.keyHandler(e);	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	private void win() {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("Win");
	}
	
	private void Lose() {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("Lose");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!curr_level.getPlayer().getMoving()) {
			curr_level.attack();			
		}
		saySomething("Mouse clicked (# of clicks: "
                + e.getClickCount() + ")", e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    void saySomething(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " detected on "
                        + e.getComponent().getClass().getName()
                        + "." + "\n");
    }
	
}
