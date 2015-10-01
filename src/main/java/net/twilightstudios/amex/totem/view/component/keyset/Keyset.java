package net.twilightstudios.amex.totem.view.component.keyset;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.twilightstudios.amex.totem.view.component.keyset.listener.KeysetListener;

@SuppressWarnings("serial")
public abstract class Keyset extends JPanel implements MouseListener {
	
	//Filas individuales del teclado
	private String firstRow[];
	private String secondRow[];
	private String thirdRow[];
	private String fourthRow[];
	private String fifthRow[];
	
	//Jbuttons correspondientes a cada columna
	private JButton first[];
	private JButton second[];
	private JButton third[];
	private JButton fourth[];
	private JButton fifth[];
    
	protected static boolean capsLocked;
	protected static boolean swifted;
	
	protected KeysetListener listener;
    
	public Keyset(String[] firstRow, String[] secondRow, String[] thirdRow, String[] fourthRow, String[] fifthRow) {
		super(new GridBagLayout());
		this.firstRow = firstRow;
		this.secondRow = secondRow;
		this.thirdRow = thirdRow;
		this.fourthRow = fourthRow;
		this.fifthRow = fifthRow;
		capsLocked = false;
		swifted = false;
		initWidgets();
	}
	
	/**
	 * Método para inicializar las filas de botones
	 */
	private void initWidgets() {

		this.setOpaque(false);
		first = new JButton[firstRow.length];
		second = new JButton[secondRow.length];
		third = new JButton[thirdRow.length];
		fourth = new JButton[fourthRow.length];
		fifth = new JButton[fifthRow.length];

		addKeys(this, 0, firstRow, first);
		addKeys(this, 1, secondRow, second);
		addKeys(this, 2, thirdRow, third);
		addKeys(this, 3, fourthRow, fourth);
		addKeys(this, 4, fifthRow, fifth);

	}
	
	/**
	 * Método para añadir los botones a cada una de las filas e incluirlas en el panel
	 * @param parent
	 * @param row
	 * @param keys
	 * @param buttons
	 */
	protected void addKeys(JPanel parent, int row, String[] keys, JButton[] buttons) {

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = row;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.BOTH;

		int gap = 0;
		for (int index = 0; index < keys.length; index++) {
			String key = keys[index];
			if ("blank".equalsIgnoreCase(key)) {
				gbc.gridx++;
			} else if ("fill".equalsIgnoreCase(key)) {
				gbc.gridwidth++;
				gap++;
			} else {
				JButton btn = new JButton(key);
				btn.addMouseListener(this);
				buttons[index] = btn;
				parent.add(btn, gbc);
				gbc.gridx += gap + 1;
				gbc.gridwidth = 1;
				gap = 0;
			}
		}

	}

	@Override
	public abstract void mouseClicked(MouseEvent e);

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	public KeysetListener getListener() {
		return listener;
	}

	public void setListener(KeysetListener listener) {
		this.listener = listener;
	}

}
