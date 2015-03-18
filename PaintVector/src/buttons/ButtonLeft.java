package buttons;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import myNew.PanelFigure;
import myNew.SizeMoveListener;

public class ButtonLeft extends JPanel implements MouseMotionListener,
		MouseListener, SizeMoveListener {
	private static final long serialVersionUID = 1L;
	private int dx;
	JPanel panel;

	public ButtonLeft(PanelFigure figure) {
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		setBounds(0, figure.getHeight() / 2 - 4, 8, 8);
		panel = figure;
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		dx = e.getX();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point pp = panel.getLocation();
		int dX = e.getX() - dx;
		pp.translate(dX, 0);
		panel.setSize(dx - e.getX() + panel.getWidth(), panel.getHeight());
		panel.setLocation(pp);
	}

	@Override
	public void checkMove() {
		this.setLocation(0, panel.getHeight() / 2 - 4);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
