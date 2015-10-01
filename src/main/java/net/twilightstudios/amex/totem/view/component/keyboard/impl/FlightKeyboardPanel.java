package net.twilightstudios.amex.totem.view.component.keyboard.impl;

import javax.swing.Box;
import javax.swing.JPanel;

import net.twilightstudios.amex.totem.view.component.keyboard.KeyboardPanel;
import net.twilightstudios.amex.totem.view.component.keyset.Keyset;
import net.twilightstudios.amex.totem.view.component.textboard.TextboardPanel;
import net.twilightstudios.amex.totem.view.constants.styles.KeyboardPanelStyles;

@SuppressWarnings("serial")
public class FlightKeyboardPanel extends JPanel implements KeyboardPanel {

	private TextboardPanel textboardPanel;
	
	private Keyset keysetMin;
	private Keyset keysetMay;
	private Keyset keysetSp1;
	private Keyset keysetSp2;
	
	private Keyset currentKeyset;
	
	private Box boxCenter;
	
	public FlightKeyboardPanel() {
		super();
    }

	/**
	 * Método que inicializa el panel
	 */
	@Override
	public void initPanel() {
		this.setBackground(KeyboardPanelStyles.BACKGROUND_COLOR);
		
		boxCenter = Box.createVerticalBox();
		textboardPanel.initWidget();
		currentKeyset = keysetMin;
		
		boxCenter.add(textboardPanel);
		boxCenter.add(currentKeyset);
		
		add(boxCenter);
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
		boxCenter.remove(currentKeyset);
		currentKeyset = keyset;
		boxCenter.add(currentKeyset);
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