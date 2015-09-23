package net.twilightstudios.amex.totem.view.component.button;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import net.twilightstudios.amex.totem.view.component.button.listener.CategoryButtonListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public abstract class CategoryButton extends JButton implements MouseListener {
	
	protected Component parent;
	
	protected String label;
	
	private String urlIcon;
	
	protected CategoryButtonListener listener;
	
	private static Log log = LogFactory.getLog(CategoryButton.class);
	
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
			log.error("No se ha podido encontrar el archivo: " + path);
			return null;
		} catch (IOException e) {
			log.error("Error de lectura o escritura");
			return null;
		}
		
	}

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

	public CategoryButtonListener getListener() {
		return listener;
	}

	public void setListener(CategoryButtonListener listener) {
		this.listener = listener;
	}

}
