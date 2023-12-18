package com.pbo.TCure;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TutorialPanel extends JPanel {
	private static final long serialVersionUID = -4130161060444139604L;
    private Image backgroundImage;
	
	public TutorialPanel() {
		
		try {
            // Load the background image
            backgroundImage = ImageIO.read(getClass().getResource("/assets/Tutorial.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        setLayout(null);
		
		JButton Continue = new JButton("Lanjut");
        Continue.setBounds(450, 600, 150, 30);
		Continue.addActionListener(this::Continuee);
		add(Continue);
	}
	
	private void Continuee(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("GameScreen");
	}
	
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 640, 640, this);
        }
    }
}