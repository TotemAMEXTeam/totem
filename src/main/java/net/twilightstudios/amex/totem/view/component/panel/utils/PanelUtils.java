package net.twilightstudios.amex.totem.view.component.panel.utils;

public class PanelUtils {
	
	public static String primeraLetraMayuscula(String cadena) {
		char c = cadena.toUpperCase().charAt(0);
		String res = c + cadena.substring(1);
		return res;
	}

}
