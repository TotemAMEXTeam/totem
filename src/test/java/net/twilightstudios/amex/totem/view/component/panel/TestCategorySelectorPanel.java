package net.twilightstudios.amex.totem.view.component.panel;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.twilightstudios.amex.totem.view.component.panel.impl.CategorySelectorPanel;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCategorySelectorPanel {
	
	private static BeanFactory factory;

	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		
		factory = new ClassPathXmlApplicationContext("testAppContext.xml");
		JFrame f = (JFrame) factory.getBean("frame");
		f.setLayout(new BorderLayout());
		CategorySelectorPanel panel = (CategorySelectorPanel) factory.getBean("categorySelectorPanel");
		panel.initPanel();
		f.add(panel, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
