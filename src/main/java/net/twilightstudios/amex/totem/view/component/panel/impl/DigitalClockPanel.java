package net.twilightstudios.amex.totem.view.component.panel.impl;

import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import net.twilightstudios.amex.totem.view.component.clock.ClockLabel;
import net.twilightstudios.amex.totem.view.component.panel.SectionPanel;

@SuppressWarnings("serial")
public class DigitalClockPanel extends SectionPanel {

	private ClockLabel dayLabel = new ClockLabel("day");
	private ClockLabel monthLabel = new ClockLabel("month");
	private ClockLabel hourLabel = new ClockLabel("hour");
	private ClockLabel amLabel = new ClockLabel("am");
	private ClockLabel weekdayLabel = new ClockLabel("weekday");
    
    
    private Box main;
	
	public DigitalClockPanel() {
		
	}
	@Override
	public void initPanel() {
		
		this.setOpaque(false);
		
		main = Box.createHorizontalBox();
		
		main.add(weekdayLabel);
		
		main.add(new JSeparator(SwingConstants.VERTICAL));
		
		main.add(dayLabel);
		
		main.add(monthLabel);
		
		main.add(new JSeparator(SwingConstants.VERTICAL));
		
		main.add(hourLabel);
		
		main.add(amLabel);
		
		this.add(main);
		
	}
	
}
