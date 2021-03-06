package net.twilightstudios.amex.totem.view.component.textboard.impl;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import net.twilightstudios.amex.totem.view.component.textboard.TextboardPanel;

@SuppressWarnings("serial")
public class FlightTextboardPanel extends TextboardPanel {
	
	private JTextArea flightTextArea;
	
	public FlightTextboardPanel() {
		super();
	}

	@Override
	public void initWidget() {
		this.setOpaque(false);
		flightTextArea.setPreferredSize(new Dimension(800,25));
		flightTextArea.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		add(flightTextArea);
		
	}

	public JTextArea getFlightTextArea() {
		return flightTextArea;
	}

	public void setFlightTextArea(JTextArea flightTextArea) {
		this.flightTextArea = flightTextArea;
	}
}
