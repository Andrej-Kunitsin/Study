package mainOneThreadWhile;

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
		setBackground(Color.RED);
		addMouseListener(this);
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (NewBall ball : list) {
			ball.paint(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		NewBall ball = new NewBall(e.getX(), e.getY(), this);
		list.add(ball);
		Thread t = new Thread(ball);
		t.start();
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