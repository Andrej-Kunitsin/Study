package mainThreadTimer.copy;

import javax.swing.JFrame;


public class BallsFrame extends JFrame 
{
	public BallsFrame() 
	{
		setTitle("Balls");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 400);
		add( new BallsPanel() );
		setVisible(true);
	}
}
