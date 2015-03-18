package myNew;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PanelDraw extends JPanel {
	private static final long serialVersionUID = 1L;
	PanelFigure panel;
	Sets sets;

	public PanelDraw(Sets set) {
		this.sets = set;

		setLayout(null);
		setBackground(Color.yellow);
		addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel = new PanelFigure(sets);
				panel.setLocation(e.getX(), e.getY());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panel.setSize(Math.abs(panel.getX() - e.getX()),
						Math.abs(panel.getY() - e.getY()));
				int x = panel.getX();
				int y = panel.getY();
				if (e.getX() < x) {
					x = e.getX();
				}
				if (e.getY() < y) {
					y = e.getY();
				}
				panel.setLocation(x, y);
				add(panel);
				repaint();

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}

}