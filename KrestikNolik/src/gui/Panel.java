package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api.GameClient;

public class Panel extends JPanel
{
	public JTextField infoFild;
	PanelGameFilds gameFild;
	JButton buttonConn;
	GameClient gameClient;

	public Panel()
	{
		gameClient = new GameClient();

		setLayout(new BorderLayout());
		infoFild = new JTextField();
		infoFild.setText(String.valueOf(gameClient.idClient));
		gameFild = new PanelGameFilds(gameClient);
		gameFild.setBackground(Color.blue);
		buttonConn = new JButton("Connect");

		add(infoFild, BorderLayout.NORTH);
		add(gameFild, BorderLayout.CENTER);
		add(buttonConn, BorderLayout.SOUTH);
		buttonConn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				gameClient.sendMesage("command:connect");
			}
		});
		gameClient.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String string = e.getActionCommand();
				String[] parsStrings = string.split("/n");
				for (String str : parsStrings)
				{
					gameFild.actionFilling(str);
				}
			}
		});
	}
}