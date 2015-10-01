package net.twilightstudios.amex.totem.view.component.keyset.listener.impl;

import javax.swing.JTextArea;

import net.twilightstudios.amex.totem.view.component.keyset.listener.KeysetListener;
import net.twilightstudios.amex.totem.view.component.textboard.impl.FlightTextboardPanel;

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

	// No hacer nada, ya que el panel no realizará ninguna acción al presional esta tecla
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
