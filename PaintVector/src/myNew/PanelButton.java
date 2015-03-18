package myNew;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelButton extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton buttonRect;
	JButton buttonOval;
	JButton buttonClear;
	Sets sets;

	public PanelButton(Sets sets) {
		this.sets = sets;
		setLayout(null);
		buttonRect = new JButton("Квадрат");
		buttonOval = new JButton("Овал");
		buttonClear = new JButton("Очистка");
		buttonRect.setBounds(10, 10, 100, 50);
		buttonOval.setBounds(10, 70, 100, 50);
		buttonClear.setBounds(10, 130, 100, 50);
		add(buttonRect);
		add(buttonOval);
		add(buttonClear);
		buttonRect.addActionListener(this);
		buttonOval.addActionListener(this);
		buttonClear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Квадрат")) {
			sets.mFigure = Figures.Rectangl;
		} else if (e.getActionCommand().equals("Овал")) {
			sets.mFigure = Figures.Cicle;
		} else if (e.getActionCommand().equals("Очистка")) {
			sets.mPanelDraw.removeAll();
			sets.mPanelDraw.repaint();
		}
	}
}
