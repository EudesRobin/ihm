package ihm.ricm.widget.rangeslider;

import javax.swing.JFrame;

public class TestUI {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("Coucou");
		window.setSize(400, 400);
		
		window.setVisible(true);
		window.add(new RangeSlider(0,50,0,100,0));
		
		
		
		window.pack();
		window.setLocationRelativeTo(null);
	}

}
