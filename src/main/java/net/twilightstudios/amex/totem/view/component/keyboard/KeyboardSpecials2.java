package net.twilightstudios.amex.totem.view.component.keyboard;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class KeyboardSpecials2 extends Keyboard {

	//Filas individuales del teclado  
	private static final String ROW_1[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "fill", "BackSpace"};
	private static final String ROW_2[] = {"Tab", "#", "-", "_", "~", "!", "$", "&", "%", "(", ")"};
	private static final String ROW_3[] = {"Caps", "*", "+", ",", ".", ";", "=", ":", "'", "\"", "fill", "fill", "Enter"};
	private static final String ROW_4[] = {"2/2", "<", ">", "@", "[", "]", "\\", "M", "blank", "Up"};
	private static final String ROW_5[] = {"ABC", "blank", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "", "< Left", "Down", "Rigth >"};
	
	private KeyboardPanel parent;

	public KeyboardSpecials2(KeyboardPanel parent, JTextArea text) {
		super(text, ROW_1, ROW_2, ROW_3, ROW_4, ROW_5);
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
				parent.switchToMayusculesKeyboard();
			} else {
				parent.switchToMinusculesKeyboard();
			}
			break;
		case "Caps":
			break;
			
		case "2/2":
			parent.switchToSpecials1Keyboard();
			break;
		default:
			text.setText(text.getText() + keyValue);
			text.repaint();
			text.revalidate();
		}
		
	}

	public void setParent(KeyboardPanel parent) {
		this.parent = parent;
	}
}