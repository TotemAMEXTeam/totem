package net.twilightstudios.amex.totem.view.component.panel;

import java.awt.Component;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class SectionPanel extends JPanel {

	protected Component parent;
	
	public SectionPanel() {}
	
	public SectionPanel(Component parent) {
		this.parent = parent;
	}
	
	public abstract void initPanel();
}
