package mainThreadTimer.copy;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NewBall extends JPanel {

	private static final long serialVersionUID = 1L;
	private int x, y;
	private int dx, dy;
	private final int radius = 15;
	private Component contain;
	private Color color;

	public NewBall(int x, int y, Component container) {
		this.x = x;
		this.y = y;
		this.dx = getDelta();
		this.dy = getDelta();
		contain = container;
		this.color = new Color(new Random().nextInt(255),
				new Random().nextInt(255), new Random().nextInt(255));
	}

	public void moveBall() {
		x += dx;
		y += dy;
		if (x >= contain.getWidth() - radius) {
			x = contain.getWidth() - radius - 1;
			dx = -dx;
		}
		if (y >= contain.getHeight() - radius) {
			y = contain.getHeight() - radius - 1;
			dy = -dy;
		}
		if (x < radius) {
			x = radius;
			dx = -dx;
		}
		if (y < radius) {
			y = radius;
			dy = -dy;
		}
	}

	private int getDelta() {
		Random random = new Random();
		return random.nextInt(10) - 5;
	}

	public void paint(Graphics g) {
			g.fillOval(x, y, radius, radius);
			moveBall();
	}
}
