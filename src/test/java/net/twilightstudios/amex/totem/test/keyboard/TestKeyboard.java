package net.twilightstudios.amex.totem.test.keyboard;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.twilightstudios.amex.totem.view.component.keyboard.KeyboardTotemAmex;

public class TestKeyboard {
	
	private static BeanFactory factory;
	
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		
		factory = new ClassPathXmlApplicationContext("testAppContext.xml");
		KeyboardTotemAmex keyboard = (KeyboardTotemAmex) factory.getBean("keyboardPanel");
		keyboard.initWidgets();
		keyboard.setVisible(true);
    }

}
