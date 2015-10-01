package net.twilightstudios.amex.totem.view.component.button.listener.impl;

import java.util.List;

import net.twilightstudios.amex.places.entity.Place;
import net.twilightstudios.amex.totem.view.component.button.listener.CategoryButtonListener;
import net.twilightstudios.amex.totem.view.component.panel.impl.SliderPanel;

public class RestaurantsButtonListener implements CategoryButtonListener {

	private SliderPanel sliderPanel;
	
	@Override
	public void showCategorySelected() {
		
		// Llamada al servicio que recupera los restaurantes
		List<Place> restaurants;
		// Llamada al panel para que carge la lista de restaurantes
		sliderPanel.loadRestaurantCategory();
	}

	public SliderPanel getSliderPanel() {
		return sliderPanel;
	}

	public void setSliderPanel(SliderPanel sliderPanel) {
		this.sliderPanel = sliderPanel;
	}

}
