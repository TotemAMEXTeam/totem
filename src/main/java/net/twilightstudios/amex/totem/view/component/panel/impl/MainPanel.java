package net.twilightstudios.amex.totem.view.component.panel.impl;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	private Image scaledImage;
	
	public MainPanel(Image scaledImage) {
		super();
		this.scaledImage = scaledImage;
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

		super.paintComponent(g);
	    g.drawImage(scaledImage, 0, 0, null);
	    
	}

	public Image getScaledImage() {
		return scaledImage;
	}

	public void setScaledImage(Image scaledImage) {
		this.scaledImage = scaledImage;
	}
	
}
