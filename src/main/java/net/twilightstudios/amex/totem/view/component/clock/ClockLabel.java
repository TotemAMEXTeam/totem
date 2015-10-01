package net.twilightstudios.amex.totem.view.component.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

import net.twilightstudios.amex.totem.view.component.panel.utils.PanelUtils;
import net.twilightstudios.amex.totem.view.constants.styles.DigitalClockPanelStyles;

@SuppressWarnings("serial")
public class ClockLabel extends JLabel implements ActionListener {
	 
	String type;
	SimpleDateFormat sdf;
	 
	public ClockLabel(String type) {
		this.type = type;
		setForeground(DigitalClockPanelStyles.DIGITALCLOCK_TEXTCOLOR);
		setFont(DigitalClockPanelStyles.DIGITALCLOCK_FONT);
	 
		switch (type) {
			case "day" :
				sdf = new SimpleDateFormat("dd ");
				break;
			case "month":
				sdf = new SimpleDateFormat("MMMM");
				break;
			case "hour" :
				sdf = new SimpleDateFormat("hh:mm ");
				break;
			case "am" :
				sdf = new SimpleDateFormat("a");
				break;
			case "weekday" :
				sdf = new SimpleDateFormat("EEEE");
				break;
			default:
				sdf = new SimpleDateFormat();
				break;
		}
	 
		Timer t = new Timer(1000, this);
		t.start();
	}
	 
	public void actionPerformed(ActionEvent ae) {
		Date d = new Date();
		
		String formato = sdf.format(d);
		switch (type) {
			case "month":
			case "weekday" :
				formato = PanelUtils.primeraLetraMayuscula(formato);
				break;
			case "am" :
				formato = formato.toLowerCase();
				break;
		}
		setText(formato);
	}
}
