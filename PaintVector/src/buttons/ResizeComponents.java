package buttons;

import myNew.PanelFigure;

public class ResizeComponents {

	public ResizeComponents(PanelFigure panel) {

		ButtonTopLeft buttonTopLeft = new ButtonTopLeft(panel);
		ButtonTopRigth buttonTopRigth = new ButtonTopRigth(panel);
		ButtonTop buttonTop = new ButtonTop(panel);
		ButtonBottom buttonBottom = new ButtonBottom(panel);
		ButtonBottomRigth buttonBottomRigth = new ButtonBottomRigth(panel);
		ButtonBottomLeft buttonBottomLeft = new ButtonBottomLeft(panel);
		ButtonLeft buttonLeft = new ButtonLeft(panel);
		ButtonRight buttonRight = new ButtonRight(panel);

		panel.add(buttonTopLeft);
		panel.add(buttonTopRigth);
		panel.add(buttonTop);
		panel.add(buttonBottom);
		panel.add(buttonLeft);
		panel.add(buttonRight);
		panel.add(buttonBottomRigth);
		panel.add(buttonBottomLeft);

		panel.addSizeChangeListener(buttonTopLeft);
		panel.addSizeChangeListener(buttonTopRigth);
		panel.addSizeChangeListener(buttonTop);
		panel.addSizeChangeListener(buttonBottom);
		panel.addSizeChangeListener(buttonLeft);
		panel.addSizeChangeListener(buttonRight);
		panel.addSizeChangeListener(buttonBottomRigth);
		panel.addSizeChangeListener(buttonBottomLeft);

	}
}
