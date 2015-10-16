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

	RangeSlider self;
	enum States {IDLE,CLICK_RIGHT_SIDE,CLICK_LEFT_SIDE,CLICK_RECT_RIGHT,CLICK_RECT_LEFT,DRAG_RECT_RIGHT,DRAG_LEFT_RECT,CLICK_MIDDLE,DRAG_MIDDLE};
	States state;
	public RangeSliderUI(RangeSlider o) {
		super(o);
		this.self = o;
		state = States.IDLE;
	}
	
	// Pour add un rectangle sup.
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
	}
	
	// pour dessiner nos 2 rectangles...
	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		// appel à paintThunb dans le super...
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
		int old_x;
		
		States getPosition(MouseEvent e) {
			
			return States.CLICK_RECT_LEFT;
		}
		
		
		
		@Override
		public void mouseReleased(MouseEvent e) {
			switch(state) {
			case CLICK_LEFT_SIDE:
				break;
			case CLICK_MIDDLE:
				break;
			case CLICK_RECT_LEFT:
				
				break;
			case CLICK_RECT_RIGHT:
				break;
			case CLICK_RIGHT_SIDE:
				break;
			case DRAG_LEFT_RECT:
				state = States.IDLE;
				break;
			case DRAG_MIDDLE:
				break;
			case DRAG_RECT_RIGHT:
				break;
			case IDLE:
				break;
			default:
				break;
			
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			switch(state) {
			case IDLE:
				// où on a cliqué ?
				state = getPosition(e);
				old_x=e.getX();
				break;
			default:
				break;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			switch(state) {
			case CLICK_MIDDLE:
				break;
			case CLICK_RECT_LEFT:
//				state = States.DRAG_LEFT_RECT;
//				if(e.getX()-old_x>0) {
//					self.setSliderGauche(self.getValue()-1);
//				}else {
//					self.setSliderGauche(self.getValue()+1);
//				}
//				old_x=e.getX();
				break;
			case CLICK_RECT_RIGHT:
				break;
			case DRAG_LEFT_RECT:
//				if(e.getX()-old_x>0) {
//					self.setSliderGauche(self.getValue()-1);
//				}else {
//					self.setSliderGauche(self.getValue()+1);
//				}
				break;
			case DRAG_MIDDLE:
				break;
			case DRAG_RECT_RIGHT:
				break;
			default:
				break;
			}
		}

	}
}
