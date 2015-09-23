package net.twilightstudios.amex.totem.view.component.keyset.listener.impl;

import javax.swing.JTextArea;

import net.twilightstudios.amex.totem.view.component.keyboard.impl.FlightTextboardPanel;
import net.twilightstudios.amex.totem.view.component.keyset.listener.KeysetListener;

public class FlightKeysetListener implements KeysetListener {

	private FlightTextboardPanel flightTextboardPanel;
	
	@Override
	public void deleteKeyPressed() {
		JTextArea flightTextArea = flightTextboardPanel.getFlightTextArea();
		String textValue = flightTextArea.getText();
		if (textValue.length() > 0) {
			flightTextArea.setText(textValue.substring(0, textValue.length()-1));
		}
	}

	// Do nothing as the panel won't need an action on this key
	@Override
	public void tabKeyPressed() {
	}

	@Override
	public void enterKeyPressed() {
		// TODO Auto-generated method stub
		System.out.println("He pulsado la tecla ENTER");
	}

	@Override
	public void genericKeyPressed(String keyValue) {
		JTextArea flightTextArea = (JTextArea) flightTextboardPanel.getFlightTextArea();
		flightTextArea.setText(flightTextArea.getText() + keyValue);
	}

	public FlightTextboardPanel getFlightTextboardPanel() {
		return flightTextboardPanel;
	}

	public void setFlightTextboardPanel(FlightTextboardPanel flightTextboardPanel) {
		this.flightTextboardPanel = flightTextboardPanel;
	}

}
