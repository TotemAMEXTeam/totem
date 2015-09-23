package net.twilightstudios.amex.totem.view.component.keyboard.impl;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.twilightstudios.amex.totem.view.component.keyboard.KeyboardPanel;
import net.twilightstudios.amex.totem.view.component.keyboard.TextboardPanel;
import net.twilightstudios.amex.totem.view.component.keyset.Keyset;

@SuppressWarnings("serial")
public class FlightKeyboardPanel extends JFrame implements KeyboardPanel {

	private TextboardPanel textboardPanel;
	
	private Keyset keysetMin;
	private Keyset keysetMay;
	private Keyset keysetSp1;
	private Keyset keysetSp2;
	
	private Keyset currentKeyset;
	
	public FlightKeyboardPanel() {
		super();
    }

	/**
	 * Método que inicializa el frame
	 */
	@Override
	public void initWidgets() {

		setLayout(new BorderLayout());
        
		JPanel jpCenter = new JPanel();
        
		//textboardPanel.setPreferredSize(new Dimension(800,25));
		//textboardPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
		jpCenter.setLayout( new BorderLayout());
		textboardPanel.initWidget();
		jpCenter.add(textboardPanel, BorderLayout.WEST);
		jpCenter.add(textboardPanel, BorderLayout.CENTER);
        
		currentKeyset = keysetMin;
        
		add(jpCenter, BorderLayout.CENTER);
		add(currentKeyset, BorderLayout.SOUTH);
        
		setUndecorated(true);
        
		pack();
		setLocationRelativeTo(null);
    }

	@Override
	public void switchToMinusculesKeyset() {
		switchToOtherKeyset(keysetMin);
		
	}

	@Override
	public void switchToMayusculesKeyset() {
		switchToOtherKeyset(keysetMay);
	}

	@Override
	public void switchToSpecials1Keyset() {
		switchToOtherKeyset(keysetSp1);
	}

	@Override
	public void switchToSpecials2Keyset() {
		switchToOtherKeyset(keysetSp2);
	}
	
	private void switchToOtherKeyset(Keyset keyset){
		remove(currentKeyset);
		currentKeyset = keyset;
		add(currentKeyset, BorderLayout.SOUTH);
		this.repaint();
		this.revalidate();
	}
	
	public TextboardPanel getTextboardPanel() {
		return textboardPanel;
	}

	public void setTextboardPanel(TextboardPanel textboardPanel) {
		this.textboardPanel = textboardPanel;
	}

	public Keyset getKeysetMin() {
		return keysetMin;
	}

	public void setKeysetMin(Keyset keysetMin) {
		this.keysetMin = keysetMin;
	}

	public Keyset getKeysetMay() {
		return keysetMay;
	}

	public void setKeysetMay(Keyset keysetMay) {
		this.keysetMay = keysetMay;
	}

	public Keyset getKeysetSp1() {
		return keysetSp1;
	}

	public void setKeysetSp1(Keyset keysetSp1) {
		this.keysetSp1 = keysetSp1;
	}

	public Keyset getKeysetSp2() {
		return keysetSp2;
	}

	public void setKeysetSp2(Keyset keysetSp2) {
		this.keysetSp2 = keysetSp2;
	}

}