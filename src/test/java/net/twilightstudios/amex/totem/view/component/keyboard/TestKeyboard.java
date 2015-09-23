package net.twilightstudios.amex.totem.view.component.keyboard;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.twilightstudios.amex.totem.view.component.keyboard.impl.FlightKeyboardPanel;

public class TestKeyboard {
	
	private static BeanFactory factory;
	
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		
		factory = new ClassPathXmlApplicationContext("testAppContext.xml");
		FlightKeyboardPanel keyboard = (FlightKeyboardPanel) factory.getBean("keyboardPanel");
		keyboard.initWidgets();
		keyboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keyboard.setVisible(true);
    }

}
