package mainBallThread;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class NewBall extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	private int x, y;
	private int dx, dy;
	private final int radius = 15;
	private Component contain;
	private Color color;
	ActionListener timerListener;
	Timer timer;

	public NewBall(int x, int y, Component container) {
		this.x = x;
		this.y = y;
		this.dx = getDelta();
		this.dy = getDelta();
		contain = container;
		this.color = new Color(new Random().nextInt(255),
				new Random().nextInt(255), new Random().nextInt(255));
		}

	@Override
	public void run() {
		moveBall();
		contain.repaint();
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

	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
		}

}
