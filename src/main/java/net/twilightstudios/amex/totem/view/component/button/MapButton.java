package net.twilightstudios.amex.totem.view.component.button;

import java.awt.Component;
import java.awt.event.ActionEvent;

import net.twilightstudios.amex.totem.view.constants.GenericConstants;

@SuppressWarnings("serial")
public class MapButton extends CategoryButton {

	public MapButton() {
		super();
		this.label = GenericConstants.MAPS_LABEL;
	}
	
	public MapButton(Component parent) {
		super(parent);
		this.label = GenericConstants.MAPS_LABEL;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}