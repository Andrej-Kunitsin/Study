package ballWorkVersion;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class InPanel extends BallsPanel implements InterficeFigur
{
	int dx;
	int dy;

	public InPanel(Point p)
	{
		setLocation(p);
		setSize(100, 100);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		Random rnd = new Random();
		dx = rnd.nextInt(10) - 5;
		dy = rnd.nextInt(10) - 5;	
	}

	@Override
	public void move()
	{
		JPanel pp = (JPanel) getParent();
		if (getX() <= 0 || getX() >= pp.getWidth() - 100)
			dx *= -1;
		if (getY() <= 0 || getY() >= pp.getHeight() - 100)
			dy *= -1;

		Point p = getLocation();
		p.translate(dx, dy);
		setLocation(p);
	}
}