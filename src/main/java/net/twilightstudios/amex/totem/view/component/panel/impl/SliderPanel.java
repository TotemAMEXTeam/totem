package net.twilightstudios.amex.totem.view.component.panel.impl;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.twilightstudios.amex.totem.view.animation.SlideAnimation;
import net.twilightstudios.amex.totem.view.component.panel.SectionPanel;

@SuppressWarnings("serial")
public class SliderPanel extends SectionPanel {
	
	private JPanel imagePanel;
	
	private SlideAnimation slideAnimation;
	
	private List<JLabel> imagesList;
	
	private int currentImage = 0;
	
	public SliderPanel(Component parent) {
		super();
		this.parent = parent;
	}

	@Override
	public void initPanel() {
		// TODO Auto-generated method stub

	}

	public void loadHotelCategory() {
		// TODO Auto-generated method stub
		
	}

	public void loadCultureCategory() {
		// TODO Auto-generated method stub
		
	}

	public void loadMapCategory() {
		// TODO Auto-generated method stub
		
	}

	public void loadRestaurantCategory() {
		// TODO Auto-generated method stub
		
	}
	
	private class LeftButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int pos = currentImage;
			if (pos == imagesList.size()-1) {
				pos = 0;
			} else {
				pos++;
			}
			slideAnimation.jLabelXLeft(0, -840, 20, 7, imagesList.get(currentImage));
			slideAnimation.jLabelXLeft(840, 0, 20, 7, imagesList.get(pos));
			currentImage = pos;
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

	}
	
	private class RightButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int pos = currentImage;
			if (pos == 0) {
				pos = imagesList.size()-1;
			} else {
				pos--;
			}
			slideAnimation.jLabelXLeft(-840, 0, 20, 7, imagesList.get(currentImage));
			slideAnimation.jLabelXLeft(0, 840, 20, 7, imagesList.get(pos));
			currentImage = pos;
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

	}

}
