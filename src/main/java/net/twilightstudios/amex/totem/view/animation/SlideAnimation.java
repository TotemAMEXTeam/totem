package net.twilightstudios.amex.totem.view.animation;

import javax.swing.JLabel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SlideAnimation {
	

	private Log log = LogFactory.getLog(SlideAnimation.class);
	
	public void jLabelXLeft(final int start, final int stop, final int delay, final int increment, final JLabel jLabel) {

		if (jLabel.getX() == start) {
			new Thread() {
				public void run() {
					while (jLabel.getX() > stop) {
						for (int i = start; i >= stop; i -= increment) {
							try {
								Thread.sleep(delay);
								jLabel.setLocation(i, jLabel.getY());
							} catch (InterruptedException e) {
								log.error("Error en la animacion hacia la izquierda");
							}
						}
					}
					jLabel.setLocation(stop, jLabel.getY());
				}
			}
			.start();
		}
	}

	public void jLabelXRight(final int start, final int stop, final int delay, final int increment, final JLabel jLabel) {
		
		if (jLabel.getX() == start) {
			new Thread() {
				public void run() {
					while (jLabel.getX() <= start) {
						for (int i = start; i <= stop; i += increment) {
							try {
								Thread.sleep(delay);
								jLabel.setLocation(i, jLabel.getY());
							} catch (InterruptedException e) {
								log.error("Error en la animación hacia la derecha");
							}
						}
					}
					jLabel.setLocation(stop, jLabel.getY());
				}
			}
			.start();
		}
	}
}
