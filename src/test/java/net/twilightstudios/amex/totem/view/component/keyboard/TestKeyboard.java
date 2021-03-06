package net.twilightstudios.amex.totem.view.component.keyboard;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.twilightstudios.amex.totem.view.component.keyboard.impl.FlightKeyboardPanel;
import net.twilightstudios.amex.totem.view.component.panel.impl.MainPanel;

public class TestKeyboard {
	
	private static BeanFactory factory;
	
	public static void main(String[] args) {
		
		try {
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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
		FlightKeyboardPanel keyboard = (FlightKeyboardPanel) factory.getBean("keyboardPanel");
		keyboard.initPanel();
		//f.setUndecorated(true);
		p.add(keyboard);
		f.add(p, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setVisible(true);
    }

}
