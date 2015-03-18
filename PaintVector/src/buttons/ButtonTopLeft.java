package buttons;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import myNew.PanelFigure;
import myNew.SizeMoveListener;

public class ButtonTopLeft extends JPanel implements MouseMotionListener,
		MouseListener, SizeMoveListener {
	private static final long serialVersionUID = 1L;
	private int dx;
	private int dy;
	JPanel panel;

	public ButtonTopLeft(PanelFigure figure) {
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
		// setBackground(Color.YELLOW);
		setBounds(0, 0, 8, 8);
		panel = figure;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		dx = e.getX();
		dy = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point pp = getParent().getLocation();
		int dX = e.getX() - dx;
		int dY = e.getY() - dy;
		pp.translate(dX, dY);
		panel.setSize(dx - e.getX() + panel.getWidth(),
				dy - e.getY() + panel.getHeight());
		panel.setLocation(pp);
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

	@Override
	public void checkMove() {
		// TODO Auto-generated method stub

	}

}
