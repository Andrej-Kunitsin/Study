package mainBallThread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PanelGame extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	public PanelGame() {
		setBackground(Color.WHITE);
		addMouseListener(this);
	}
@Override
	public void paint(Graphics g) {
		super.paint(g);
			//paint(g);
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		new Thread(new NewBall(e.getX(), e.getY(), this)).start();;
		
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