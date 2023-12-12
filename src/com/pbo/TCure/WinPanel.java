package com.pbo.TCure;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinPanel extends JPanel {
	public WinPanel() {
		setBackground(Color.green); //
		JLabel label = new JLabel("You Win");
		JButton BacktoMenu = new JButton("Kembali ke Menu");
		BacktoMenu.addActionListener(this::BackToMenu);
		add(label);
		add(BacktoMenu);
	}
	
	private void BackToMenu(ActionEvent e) {
		ParentPanel parent = (ParentPanel) getParent();
		parent.showPanel("MainMenu");
	}
	
	public void YouWin(Graphics g) {
		g.setColor(Color.GREEN);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("YOU WIN!!!", (getWidth() - metrics.stringWidth("YOU WIN!!!"))/2, getHeight()/2);
	}
}
