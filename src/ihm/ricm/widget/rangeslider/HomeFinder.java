package ihm.ricm.widget.rangeslider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeFinder {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("HomeFinder");
		window.setVisible(true);
		window.setLayout(new BorderLayout());
		window.setBackground(Color.RED);
		
		JPanel iner_right= new JPanel();
		iner_right.setLayout(new BorderLayout());
		iner_right.setBackground(Color.BLACK);
		iner_right.setPreferredSize(new Dimension(500,500));
		
		JPanel iner_left = new JPanel();
		iner_left.setLayout(new BorderLayout());
		iner_left.setBackground(Color.CYAN);
		iner_left.setPreferredSize(new Dimension(250,500));
		
		JPanel iner_south = new JPanel();
		iner_south.setLayout(new BorderLayout());
		iner_south.setBackground(Color.GREEN);
		iner_south.setPreferredSize(new Dimension(500,100));

		window.add(iner_right,BorderLayout.WEST);
		window.add(iner_left,BorderLayout.EAST);
		window.add(iner_south,BorderLayout.SOUTH);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.pack();
		window.setLocationRelativeTo(null);

	}

}
