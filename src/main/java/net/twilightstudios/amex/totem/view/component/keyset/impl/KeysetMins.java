package net.twilightstudios.amex.totem.view.component.keyset.impl;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import net.twilightstudios.amex.totem.view.component.keyboard.KeyboardPanel;
import net.twilightstudios.amex.totem.view.component.keyset.Keyset;

@SuppressWarnings("serial")
public class KeysetMins extends Keyset {

	//Filas individuales del teclado  
	private static final String ROW_1[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "fill", "Delete"};
	private static final String ROW_2[] = {"Tab", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
	private static final String ROW_3[] = {"Caps On", "a", "s", "d", "f", "g", "h", "j", "k", "l", "fill", "fill", "Enter"};
	private static final String ROW_4[] = {"Shift", "z", "x", "c", "v", "b", "n", "m", "blank", "Up"};
	private static final String ROW_5[] = {"@/?", "blank", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "", "< Left", "Down", "Rigth >"};
	
	private KeyboardPanel parent;
	
	public KeysetMins(KeyboardPanel parent) {
		super(ROW_1, ROW_2, ROW_3, ROW_4, ROW_5);
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String keyValue = ((JButton)e.getSource()).getText();
		keyValue = (keyValue == null || keyValue.equals("")) ? " " : keyValue;
		switch (keyValue) {
		case "@/?":
			swifted = false;
			parent.switchToSpecials1Keyset();
			break;
		case "Caps On":
			if (!swifted) {
				capsLocked = true;
			}
			swifted = false;
			parent.switchToMayusculesKeyset();
			break;
			
		case "Shift":
			swifted = true;
			parent.switchToMayusculesKeyset();
			break;
			
		case "Delete":
			if (swifted) {
				swifted = false;
				parent.switchToMayusculesKeyset();
			}
			listener.deleteKeyPressed();
			break;
			
		case "Tab":
			listener.tabKeyPressed();
			break;
			
		case "Enter":
			listener.enterKeyPressed();
			break;
			
		default:
			if (swifted) {
				swifted = false;
				parent.switchToMayusculesKeyset();
			}
			listener.genericKeyPressed(keyValue);
		}
		
	}
	
	public void setParent(KeyboardPanel parent) {
		this.parent = parent;
	}
}