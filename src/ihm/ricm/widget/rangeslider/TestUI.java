package ihm.ricm.widget.rangeslider;

import javax.swing.JFrame;

public class TestUI {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("Debug");
		window.setVisible(true);
		// pour se simplifier la vie (dans le positionement des curseurs...)
		window.setResizable(false);
		window.add(new RangeSlider(0,50,0,100,0));
		window.pack();
		window.setLocationRelativeTo(null);
	}

}
