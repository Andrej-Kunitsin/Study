package buttons;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import myNew.PanelFigure;
import myNew.SizeMoveListener;

public class ButtonRight extends JPanel implements MouseMotionListener,
		MouseListener, SizeMoveListener {
	private static final long serialVersionUID = 1L;
	private int dx;
	JPanel panel;

	public ButtonRight(PanelFigure figure) {
		panel = figure;
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
		setBounds(panel.getWidth() - 8, panel.getHeight() / 2 - 4, 8, 8);
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		dx = e.getX();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		panel.setSize(e.getX() - dx + panel.getWidth(), panel.getHeight());

	}

	@Override
	public void checkMove() {
		this.setLocation(panel.getWidth() - 8, panel.getHeight() / 2 - 4);

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
