package buttons;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import myNew.PanelFigure;
import myNew.SizeMoveListener;

public class ButtonTopRigth extends JPanel implements MouseMotionListener,
		MouseListener, SizeMoveListener {
	private static final long serialVersionUID = 1L;
	private int dx;
	private int dy;
	JPanel panel;

	public ButtonTopRigth(PanelFigure figure) {
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
		setBounds(figure.getWidth() - 8, 0, 8, 8);
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
		pp.translate(0, e.getY() - dy);
		panel.setSize(getParent().getWidth() + e.getX() - dx, dy - e.getY()
				+ getParent().getHeight());
		panel.setLocation(pp);
	}

	@Override
	public void checkMove() {
		JPanel parent = (JPanel) getParent();
		this.setLocation(parent.getWidth() - 8, 0);
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
