package net.twilightstudios.amex.totem.view.component.keyboard;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class KeyboardMay extends Keyboard {

	//Individual keyboard rows  
	private static final String ROW_1[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "fill", "BackSpace"};
	private static final String ROW_2[] = {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
	private static final String ROW_3[] = {"Caps Off", "A", "S", "D", "F", "G", "H", "J", "K", "L", "fill", "fill", "Enter"};
	private static final String ROW_4[] = {"Shift", "Z", "X", "C", "V", "B", "N", "M", "blank", "Up"};
	private static final String ROW_5[] = {"@/?", "blank", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "", "< Left", "Down", "Rigth >"};
	
	private KeyboardPanel parent;

	// No argument constructor to create frame
	public KeyboardMay(KeyboardPanel parent, JTextArea text) {
		super(text, ROW_1, ROW_2, ROW_3, ROW_4, ROW_5);
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String keyValue = ((JButton)e.getSource()).getText();
		keyValue = (keyValue == null || keyValue.equals("")) ? " " : keyValue;
		switch (keyValue) {
		case "@/?":
			swifted = false;
			parent.switchToSpecials1Keyboard();
			break;
		case "Caps Off":
			if (!swifted) {
				capsLocked = false;
			}
			swifted = false;
			parent.switchToMinusculesKeyboard();
			break;
			
		case "Shift":
			swifted = true;
			parent.switchToMinusculesKeyboard();
			break;
		default:
			text.setText(text.getText() + keyValue);
			text.repaint();
			text.revalidate();
			if (swifted) {
				swifted = false;
				parent.switchToMinusculesKeyboard();
			}
		}
		
	}
}