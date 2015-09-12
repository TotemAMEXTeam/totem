package net.twilightstudios.amex.totem.view.component.button;

import java.awt.Component;
import java.awt.event.ActionEvent;

import net.twilightstudios.amex.totem.view.constants.GenericConstants;

@SuppressWarnings("serial")
public class ArtCultureButton extends CategoryButton {

	public ArtCultureButton() {
		super();
		this.label = GenericConstants.ARTS_CULTURE_LABEL;
	}
	
	public ArtCultureButton(Component parent) {
		super(parent);
		this.label = GenericConstants.ARTS_CULTURE_LABEL;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}