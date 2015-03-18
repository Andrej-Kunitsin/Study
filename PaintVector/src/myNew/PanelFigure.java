package myNew;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import buttons.ResizeComponents;

public class PanelFigure extends JPanel implements MouseListener,
		MouseMotionListener, FocusListener, ComponentListener {
	private static final long serialVersionUID = 1L;

	public Figures fig;
	private int dx = 0;
	private int dy = 0;

	private ArrayList<SizeMoveListener> sml = new ArrayList<SizeMoveListener>();

	public PanelFigure() {
	}

	public PanelFigure(Sets sets) {
		fig = sets.mFigure;
		setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		addMouseListener(this);
		addMouseMotionListener(this);
		addFocusListener(this);
		addComponentListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isFocusable()) {
			((Graphics2D) g).setStroke(new BasicStroke(5));
		} else {
			((Graphics2D) g).setStroke(new BasicStroke(2));
			removeAll();
		}
		if (fig == Figures.Rectangl) {
			g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		} else if (fig == Figures.Cicle) {
			g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
		}
	}

	private void SizeChangeAction() {
		for (SizeMoveListener s : sml) {
			s.checkMove();
		}

	}

	public void addSizeChangeListener(SizeMoveListener ss) {
		sml.add(ss);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		SizeChangeAction();

	}

	@Override
	public void componentResized(ComponentEvent e) {
		SizeChangeAction();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		dx = e.getX();
		dy = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point pp = getLocation();
		pp.translate(e.getX() - dx, e.getY() - dy);
		setLocation(pp);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();
		repaint();
	}

	@Override
	public void focusGained(FocusEvent e) {
		setOpaque(true);
		repaint();
	}

	@Override
	public void focusLost(FocusEvent e) {
		setOpaque(false);
		for (Component cc : getComponents()) {
			cc.setVisible(false);
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		requestFocus();
		//setFocusable(true);
		new ResizeComponents(this);
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}
}
