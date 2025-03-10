package com.pbo.TCure;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
// import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinPanel extends JPanel {
	private static final long serialVersionUID = 6792606481218821235L;
	private Image backgroundImage;

	public WinPanel() {
		try {
            // Load the background image
            backgroundImage = ImageIO.read(getClass().getResource("/assets/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		// JLabel label = new JLabel("You Win");
		JButton BacktoMenu = new JButton("Kembali ke Menu");
		JButton Next = new JButton("Level Selanjutnya");
		JButton Retry = new JButton("Ulang Level");
		BacktoMenu.addActionListener(this::BackToMenu);
		Next.addActionListener(this::nextlevel);
		Retry.addActionListener(this::RetryLevel);
		// add(label);
		add(BacktoMenu);
		add(Next);
		add(Retry);
	}
	
	private void BackToMenu(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("MainMenu");
	}
	
	private void nextlevel(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("NextLevel");
	}
	
	private void RetryLevel(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("Retry");
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
		YouWin(g);
    }
	
	public void YouWin(Graphics g) {
		g.setColor(Color.GREEN);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("YOU WIN!!!", (getWidth() - metrics.stringWidth("YOU WIN!!!"))/2, getHeight()/2);
	}
}
