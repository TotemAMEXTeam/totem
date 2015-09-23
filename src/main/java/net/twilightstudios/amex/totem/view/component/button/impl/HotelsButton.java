package net.twilightstudios.amex.totem.view.component.button.impl;

import java.awt.Component;
import java.awt.event.MouseEvent;

import net.twilightstudios.amex.totem.view.component.button.CategoryButton;
import net.twilightstudios.amex.totem.view.constants.GenericConstants;

@SuppressWarnings("serial")
public class HotelsButton extends CategoryButton {

	public HotelsButton() {
		super();
		this.label = GenericConstants.HOTELS_LABEL;
	}
	
	public HotelsButton(Component parent) {
		super(parent);
		this.label = GenericConstants.HOTELS_LABEL;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		listener.showCategorySelected();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
