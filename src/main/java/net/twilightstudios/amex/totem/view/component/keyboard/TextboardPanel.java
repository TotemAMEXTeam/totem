package net.twilightstudios.amex.totem.view.component.keyboard;

import java.awt.KeyboardFocusManager;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class TextboardPanel extends JPanel {
	
	private static KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	
	public TextboardPanel() {
		super();
	}
	
	public abstract void initWidget();

	public KeyboardFocusManager getFocusManager() {
		return focusManager;
	}

}
