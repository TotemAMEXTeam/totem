package net.twilightstudios.amex.totem.view.component.keyset.impl;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import net.twilightstudios.amex.totem.view.component.keyboard.KeyboardPanel;
import net.twilightstudios.amex.totem.view.component.keyset.Keyset;

@SuppressWarnings("serial")
public class KeysetSpecials2 extends Keyset {

	//Filas individuales del teclado  
	private static final String ROW_1[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "fill", "Delete"};
	private static final String ROW_2[] = {"Tab", "#", "-", "_", "~", "!", "$", "&", "%", "(", ")"};
	private static final String ROW_3[] = {"Caps", "*", "+", ",", ".", ";", "=", ":", "'", "\"", "fill", "fill", "Enter"};
	private static final String ROW_4[] = {"2/2", "<", ">", "@", "[", "]", "\\", "M", "blank", "Up"};
	private static final String ROW_5[] = {"ABC", "blank", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "", "< Left", "Down", "Rigth >"};
	
	private KeyboardPanel parent;

	public KeysetSpecials2(KeyboardPanel parent) {
		super(ROW_1, ROW_2, ROW_3, ROW_4, ROW_5);
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		swifted = false;
		String keyValue = ((JButton)e.getSource()).getText();
		keyValue = (keyValue == null || keyValue.equals("")) ? " " : keyValue;
		switch (keyValue) {
		case "ABC":
			if (capsLocked) {
				parent.switchToMayusculesKeyset();
			} else {
				parent.switchToMinusculesKeyset();
			}
			break;
			
		case "Caps":
			break;
			
		case "2/2":
			parent.switchToSpecials1Keyset();
			break;
			
		case "Delete":
			listener.deleteKeyPressed();
			break;
			
		case "Tab":
			listener.tabKeyPressed();
			break;
			
		case "Enter":
			listener.enterKeyPressed();
			break;
			
		default:
			listener.genericKeyPressed(keyValue);
		}
		
	}

	public void setParent(KeyboardPanel parent) {
		this.parent = parent;
	}
}