package net.twilightstudios.amex.totem.view.component.button.listener.impl;

import net.twilightstudios.amex.totem.view.component.button.listener.CategoryButtonListener;
import net.twilightstudios.amex.totem.view.component.panel.impl.SliderPanel;

public class MapButtonListener implements CategoryButtonListener {

	private SliderPanel sliderPanel;
	
	@Override
	public void showCategorySelected() {
		// TODO Auto-generated method stub
		sliderPanel.loadMapCategory();
	}

	public SliderPanel getSliderPanel() {
		return sliderPanel;
	}

	public void setSliderPanel(SliderPanel sliderPanel) {
		this.sliderPanel = sliderPanel;
	}

}
