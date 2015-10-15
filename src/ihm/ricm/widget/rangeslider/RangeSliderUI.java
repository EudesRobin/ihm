package ihm.ricm.widget.rangeslider;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicSliderUI;
import com.sun.javafx.geom.Rectangle;

public class RangeSliderUI extends BasicSliderUI {

	Rectangle sup_droite;
	RangeSlider self;
	
	public RangeSliderUI(RangeSlider o) {
		super(o);
		this.self = o;
	}
	
	// Pour add un rectangle sup.
	@Override
	public void installUI(JComponent c) {
		sup_droite = new Rectangle(10,5);
		super.installUI(c);
	}
	
	// pour dessiner nos 2 rectangles...
	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		
		paint_gauche(g);
		paint_droite(g);
	}
	
	// on override pour qu'il fasse rien, et nous laisse dessiner nos 2 rect.
	@Override
	public void paintThumb(Graphics g) {
		return;
	}
	
	public void paint_droite(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g.create();
		
		g2D.drawRect(0,0,10,20);
		g2D.dispose();
	}

	
	public void paint_gauche(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g.create();
		
		g2D.drawRect(self.getUpValue(), 0,10,20);
		g2D.dispose();
	}
	
	
	
}
