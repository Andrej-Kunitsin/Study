package ballWorkVersion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class BallsPanel extends JPanel implements MouseListener
{
	public BallsPanel()
	{
		setLayout(null);
		addMouseListener(this);

		ThreadBallsMove tt = new ThreadBallsMove();
		tt.start();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (SwingUtilities.isRightMouseButton(e))
		{
			InPanel b = new InPanel(e.getPoint());
			add(b);
		} else
		{
			Ball b = new Ball(e.getPoint());
			add(b);
		}
	}

	class ActionBallsMove implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Component[] list = getComponents();
			for (Component b : list)
			{
				Ball bb = (Ball) b;
				bb.move();
				bb.repaint();
			}
		}
	}

	class ThreadBallsMove extends Thread
	{
		@Override
		public void run()
		{
			try
			{
				while (true)
				{
					Component[] list = getComponents();
					for (Component b : list)
					{

						InterficeFigur bb = (InterficeFigur) b;
						bb.move();
						b.repaint();
					}
					sleep(50);
				}
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

}
