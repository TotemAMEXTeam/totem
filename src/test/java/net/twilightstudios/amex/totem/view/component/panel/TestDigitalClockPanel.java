package net.twilightstudios.amex.totem.view.component.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.twilightstudios.amex.flight.entity.FlightStatus;
import net.twilightstudios.amex.totem.view.component.panel.impl.DigitalClockPanel;
import net.twilightstudios.amex.totem.view.component.panel.impl.FlightInfoPanel;
import net.twilightstudios.amex.totem.view.component.panel.impl.MainPanel;
import net.twilightstudios.amex.weather.entity.Forecast;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDigitalClockPanel {

	private static BeanFactory factory;

	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		factory = new ClassPathXmlApplicationContext("testAppContext.xml");
		JFrame f = (JFrame) factory.getBean("frame");
		f.setLayout(new BorderLayout());
		
		Image bgImage;
		Image scaledImage = null;
		try {
			bgImage = ImageIO.read(new URL("http://www.psdgraphics.com/file/fresh-green-background.jpg"));
			scaledImage = bgImage.getScaledInstance(1920, 1080, Image.SCALE_FAST);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainPanel p = new MainPanel(scaledImage);
		
		DigitalClockPanel dgPanel = (DigitalClockPanel)factory.getBean("digiClock");
		dgPanel.initPanel();
		
		p.add(dgPanel, BorderLayout.EAST);
		p.add(dgPanel, BorderLayout.NORTH);
		
		f.add(p, BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setVisible(true);
    }
}
