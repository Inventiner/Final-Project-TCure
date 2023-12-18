package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel{
	private static final long serialVersionUID = -7328034255109132598L;
    private Image backgroundImage;
	
	public MainMenuPanel() {
		
		try {
            // Load the background image
            backgroundImage = ImageIO.read(getClass().getResource("/assets/Menu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        setLayout(null);
		
		JButton startButton = new JButton("Mulai game");
		JButton levelpicker = new JButton("Pilih Level");
		
        startButton.setBounds(130, 400, 150, 30);
        levelpicker.setBounds(350, 400, 150, 30);
        
		startButton.addActionListener(this::mulaiGame);
		levelpicker.addActionListener(this::picklevel);
		add(startButton);
		add(levelpicker);
	}
	
	private void mulaiGame(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("Lore1");
	}
	
	private void picklevel(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("Level");
	}
	
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 640, 640, this);
        }
    }
}