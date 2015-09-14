package net.twilightstudios.amex.totem.view.component.keyboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.twilightstudios.amex.totem.event.KeyboardListener;

@SuppressWarnings("serial")
public class KeyboardTotemAmex extends JFrame implements KeyboardPanel {

	private JTextArea text;
	
	private Keyboard keyboardMin;
	private Keyboard keyboardMay;
	private Keyboard keyboardSp1;
	private Keyboard keyboardSp2;
	
	private Keyboard currentKeyboard;
	
	private KeyboardListener parent;
	
	public KeyboardTotemAmex() {}
	
	public KeyboardTotemAmex(KeyboardListener parent) {
		super();
		this.parent = parent;
    	
    }

	/**
	 * Método que inicializa el frame
	 */
	@Override
	public void initWidgets() {

		setLayout(new BorderLayout());
        
		JPanel jpCenter = new JPanel();
        
		text.setPreferredSize(new Dimension(800,25));
		text.setBorder(BorderFactory.createLineBorder(Color.gray));
        
		jpCenter.setLayout( new BorderLayout());
		jpCenter.add(text, BorderLayout.WEST);
		jpCenter.add(text, BorderLayout.CENTER);
        
		currentKeyboard = keyboardMin;
        
		add(jpCenter, BorderLayout.CENTER);
		add(currentKeyboard, BorderLayout.SOUTH);
        
		setUndecorated(true);
        
		pack();
		setLocationRelativeTo(null);
    }

	@Override
	public void switchToMinusculesKeyboard() {
		switchToOtherKeyboard(keyboardMin);
		
	}

	@Override
	public void switchToMayusculesKeyboard() {
		switchToOtherKeyboard(keyboardMay);
	}

	@Override
	public void switchToSpecials1Keyboard() {
		switchToOtherKeyboard(keyboardSp1);
	}

	@Override
	public void switchToSpecials2Keyboard() {
		switchToOtherKeyboard(keyboardSp2);
	}
	
	private void switchToOtherKeyboard(Keyboard keyboard){
		remove(currentKeyboard);
		currentKeyboard = keyboard;
		add(currentKeyboard, BorderLayout.SOUTH);
		this.repaint();
		this.revalidate();
	}
	
	@Override
	public void enterKeyPressed() {
		String text = currentKeyboard.getText().getText();
		System.out.println("Se ha introducido el texto: " + text);
		
		// TODO: Enviar la información correspondiente al panel padre
		parent.processKeyboardInput(text);
		
	}
	
	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}

	public Keyboard getKeyboardMin() {
		return keyboardMin;
	}

	public void setKeyboardMin(Keyboard keyboardMin) {
		this.keyboardMin = keyboardMin;
	}

	public Keyboard getKeyboardMay() {
		return keyboardMay;
	}

	public void setKeyboardMay(Keyboard keyboardMay) {
		this.keyboardMay = keyboardMay;
	}

	public Keyboard getKeyboardSp1() {
		return keyboardSp1;
	}

	public void setKeyboardSp1(Keyboard keyboardSp1) {
		this.keyboardSp1 = keyboardSp1;
	}

	public Keyboard getKeyboardSp2() {
		return keyboardSp2;
	}

	public void setKeyboardSp2(Keyboard keyboardSp2) {
		this.keyboardSp2 = keyboardSp2;
	}

	public void setParent(KeyboardListener parent) {
		this.parent = parent;
	}

}