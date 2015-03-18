package buttons;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import myNew.PanelFigure;
import myNew.SizeMoveListener;

public class ButtonBottomRigth extends JPanel implements MouseMotionListener,
		MouseListener, SizeMoveListener {
	private static final long serialVersionUID = 1L;
	private int dx;
	private int dy;
	JPanel panel;

	public ButtonBottomRigth(PanelFigure figure) {
		panel = figure;
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
		setBounds(panel.getWidth() - 8, panel.getHeight() - 8, 8, 8);
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
		panel.setSize(e.getX() - dx + panel.getWidth(),
				e.getY() - dy + panel.getHeight());
	}

	@Override
	public void checkMove() {
		JPanel parent = (JPanel) getParent();
		this.setLocation(parent.getWidth() - 8, parent.getHeight() - 8);
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
