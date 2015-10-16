package ihm.ricm.widget.rangeslider;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JSlider;
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
		//sup_droite = new Rectangle(10,5);
		super.installUI(c);
	}
	
	// pour dessiner nos 2 rectangles...
	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		
		//paint_gauche(g);
		//paint_droite(g);
	}
	
	@Override
	public void paintThumb(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g.create();
		
		// left cursor
		g2D.setColor(Color.LIGHT_GRAY);
		g2D.fillRoundRect(self.getValue(),0,10,20,25,25);
		
		//right cursor
		g2D.setColor(Color.LIGHT_GRAY);
		g2D.fillRoundRect(self.getUpValue(),0,10,20,25,25);
		g2D.dispose();
	}
	
	// Redirection vers notre private class pour la gestion d'event
	@Override
	protected TrackListener createTrackListener(JSlider slider) {
		return new RangeSliderEvent();
	}
	
	private class RangeSliderEvent extends TrackListener{

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("oto");
			super.mousePressed(e);
		}

		@Override
		public boolean shouldScroll(int direction) {
			// TODO Auto-generated method stub
			return super.shouldScroll(direction);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseDragged(e);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseMoved(e);
		}
	}
}
