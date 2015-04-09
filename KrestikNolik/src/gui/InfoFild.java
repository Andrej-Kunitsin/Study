package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoFild extends JPanel
{
	JTextField choice;

	public InfoFild()
	{
		choice = new JTextField("Вы крестик");
		add(choice);
	}
}
