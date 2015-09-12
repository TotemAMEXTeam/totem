package net.twilightstudios.amex.totem.view.component.button;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public abstract class CategoryButton extends JButton implements ActionListener {
	
	protected Component parent;
	
	protected String label;
	
	private String urlIcon;
	
	public CategoryButton() {}
	
	public CategoryButton (Component parent) {
		super();
		this.parent = parent;
	}
	
	/**
	 * Inicializa el botón para la categoría actual
	 */
	public void initButton() {
		setIcon(createImageIcon(urlIcon));
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
	}
	
	/**
	 * Devuelve un ImageIcon o null si el path es inválido
	 * @param path
	 * @return
	 */
	protected static ImageIcon createImageIcon(String path) {
		URL imgURL;
		Image image;
		Image scaledImage;
		try {
			imgURL = new URL(path);
			image = ImageIO.read(imgURL);
			scaledImage = image.getScaledInstance(60, 60, Image.SCALE_FAST);
			ImageIcon imageIcon = new ImageIcon(scaledImage);
			return imageIcon;
		} catch (MalformedURLException e) {
			System.err.println("No se ha podido encontrar el archivo: " + path);
			return null;
		} catch (IOException e) {
			System.err.println("Error de lectura o escritura");
			return null;
		}
		
	}

	@Override
	public abstract void actionPerformed(ActionEvent arg0);

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setParent(Component parent) {
		this.parent = parent;
	}

	public String getUrlIcon() {
		return urlIcon;
	}

	public void setUrlIcon(String urlIcon) {
		this.urlIcon = urlIcon;
	}

}
