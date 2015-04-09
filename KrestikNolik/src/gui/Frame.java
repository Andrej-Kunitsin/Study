package gui;

import javax.swing.JFrame;

public class Frame extends JFrame
{

	public Frame()
	{
		setTitle("App Noughts and Crosses");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 150, 500, 350);
		add(new Panel());
		setVisible(true);
	}
}