package net.twilightstudios.amex.totem.view.component.button;

import java.awt.Component;
import java.awt.event.ActionEvent;

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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}