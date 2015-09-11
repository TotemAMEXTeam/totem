package net.twilightstudios.amex.totem.view.component.keyboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class KeyboardTotemAmex extends JFrame implements KeyboardPanel {

	JTextArea  text = new JTextArea();
	
	Keyboard keyboardMin;
	Keyboard keyboardMay;
	Keyboard keyboardSp1;
	Keyboard keyboardSp2;
	
	Keyboard currentKeyboard;
	
	// No argument constructor to create frame
	public KeyboardTotemAmex() {
		keyboardMin = new KeyboardMin(this, text);
    	keyboardMay = new KeyboardMay(this, text);
    	keyboardSp1 = new KeyboardSpecials1(this, text);
    	keyboardSp2 = new KeyboardSpecials2(this, text);
    	
    	initWidgets();
    }

	// Method to initialize frame component 
	private void initWidgets() {

		setLayout(new BorderLayout());
        
		//Various panel for the layout 
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
	public void swichtToMinusculesKeyboard() {
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

}