package net.twilightstudios.amex.totem.view.component.panel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import net.twilightstudios.amex.totem.view.component.button.CategoryButton;
import net.twilightstudios.amex.totem.view.constants.GenericConstants;

@SuppressWarnings("serial")
public class CategorySelectorPanel extends SectionPanel {
	
	private Box main;
	
	private CategoryButton restaurantsButton;
	private CategoryButton artCultureButton;
	private CategoryButton hotelsButton;
	private CategoryButton mapButton;
	
	public CategorySelectorPanel(){}
	
	public CategorySelectorPanel(Component parent) {
		super(parent);
	}
	
	/**
	 * Método que inicializa el panel
	 */
	@Override
	public void initPanel() {
	
		main = Box.createHorizontalBox();
		
		Box restaurantsCategory = createCategoryButton(restaurantsButton);
		
		main.add(restaurantsCategory);
		main.add(Box.createHorizontalStrut(20));
		
		Box artCultureCategoy = createCategoryButton(artCultureButton);
		
		main.add(artCultureCategoy);
		main.add(Box.createHorizontalStrut(20));
		
		Box hotelsCategory = createCategoryButton(hotelsButton);
		
		main.add(hotelsCategory);
		main.add(Box.createHorizontalStrut(20));
		
		Box mapCategory = createCategoryButton(mapButton);
		
		main.add(mapCategory);
		
		this.add(main);
	}

	/**
	 * Método privado que crea un box con un botón para la categoría y su etiqueta correspondiente
	 * @param categoryButton
	 * @param label
	 * @return
	 */
	private Box createCategoryButton(CategoryButton categoryButton) {
		Box category = Box.createVerticalBox();
		
		categoryButton.initButton();
		categoryButton.setSize(new Dimension(30, 30));
		category.add(categoryButton);
		
		JLabel jLabel = new JLabel(categoryButton.getLabel(), SwingConstants.CENTER);
		category.add(jLabel);
		
		return category;
	}

	public CategoryButton getRestaurantsButton() {
		return restaurantsButton;
	}

	public void setRestaurantsButton(CategoryButton restaurantsButton) {
		this.restaurantsButton = restaurantsButton;
	}

	public CategoryButton getArtCultureButton() {
		return artCultureButton;
	}

	public void setArtCultureButton(CategoryButton artCultureButton) {
		this.artCultureButton = artCultureButton;
	}

	public CategoryButton getHotelsButton() {
		return hotelsButton;
	}

	public void setHotelsButton(CategoryButton hotelsButton) {
		this.hotelsButton = hotelsButton;
	}

	public CategoryButton getMapButton() {
		return mapButton;
	}

	public void setMapButton(CategoryButton mapButton) {
		this.mapButton = mapButton;
	}

}
