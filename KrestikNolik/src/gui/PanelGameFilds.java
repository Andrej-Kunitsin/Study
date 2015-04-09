package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api.GameClient;

public class PanelGameFilds extends JPanel
{
	JButton[][] buttonArray;
	GameClient gameClient;

	public PanelGameFilds(GameClient client)
	{
		gameClient = client;
		setLayout(new GridLayout(3, 3));
		buttonArray = new JButton[3][3];

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				buttonArray[i][j] = new MyButton();
				add(buttonArray[i][j]);

				buttonArray[i][j].addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
						JButton b = (JButton) e.getSource();
						Point p = b.getLocation();

						for (int i = 0; i < 3; i++)
						{
							for (int j = 0; j < 3; j++)
							{
								if (p.equals(buttonArray[i][j].getLocation()))
								{
									gameClient.sendMesage("action:[" + i + "]["
											+ j + "]");
								}
							}
						}
					}
				});
			}
		}
	}

	public void actionFilling(String str) //какую кнопку нажал?
	{
		int buttonX = Character
				.getNumericValue(str.charAt(str.indexOf("[") + 1));
		int buttonY = Character
				.getNumericValue(str.charAt(str.lastIndexOf("]") - 1));

		char i = str.charAt(0);

		if (Integer.parseInt("" + i) == gameClient.idClient)
		{

			System.out.println(buttonX + " " + buttonY);
			((MyButton) buttonArray[buttonX][buttonY]).setFigure("Крестик");
		} else
		{
			((MyButton) buttonArray[buttonX][buttonY]).setFigure("Нолик");
		}
		(buttonArray[buttonX][buttonY]).setEnabled(false);
		repaint();
	}

	class MyButton extends JButton
	{
		String figure = "";

		public void setFigure(String string)
		{
			figure = string;
		}

		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if (figure.equals("Крестик"))
			{
				g.drawLine(0, 0, getWidth(), getHeight());
				g.drawLine(0, getHeight(), getWidth(), 0);
			} else if (figure.equals("Нолик"))
			{
				g.drawOval(0, 0, getWidth(), getHeight());
			}
		}
	}

}
