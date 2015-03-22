package mainThreadTimer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class PanelGame extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	List<NewBall> list = new LinkedList<NewBall>();

	public PanelGame() {
		setBackground(Color.WHITE);
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (NewBall ball : list) {
			ball.paint(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		list.add(new NewBall(e.getX(), e.getY(), this));
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