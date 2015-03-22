package mainOneThreadWhile;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public Frame() {
		setTitle("Ball Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 150, 600, 670);

		PanelGame panelGame = new PanelGame();
		add(panelGame);

		setVisible(true);
	}
}
