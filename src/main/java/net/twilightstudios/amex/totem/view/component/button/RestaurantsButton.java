package net.twilightstudios.amex.totem.view.component.button;

import java.awt.Component;
import java.awt.event.ActionEvent;

import net.twilightstudios.amex.totem.view.constants.GenericConstants;

@SuppressWarnings("serial")
public class RestaurantsButton extends CategoryButton {

	public RestaurantsButton() {
		super();
		this.label = GenericConstants.RESTAURANTS_LABEL;
	}
	
	public RestaurantsButton(Component parent) {
		super(parent);
		this.label = GenericConstants.RESTAURANTS_LABEL;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
