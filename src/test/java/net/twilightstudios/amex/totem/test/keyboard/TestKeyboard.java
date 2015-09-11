package net.twilightstudios.amex.totem.test.keyboard;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.twilightstudios.amex.totem.view.component.keyboard.KeyboardTotemAmex;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestKeyboard {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		BeanFactory factory = new ClassPathXmlApplicationContext("appContext.xml");
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		KeyboardTotemAmex keyboard = new KeyboardTotemAmex();
		keyboard.setVisible(true);
    }

}
