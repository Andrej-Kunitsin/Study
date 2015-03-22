package mainThreadTimer.copy;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class PanelGame extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;

	public PanelGame() {
		setBackground(Color.WHITE);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		add(new NewBall(e.getX(), e.getY(), this));
		while (true) {
			repaint();
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		for (Component s : getComponents()) {
			s.paint(g);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}