package ihm.ricm.widget.rangeslider;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;


public class RangeSliderUI extends BasicSliderUI {

	private Rectangle gauche, droite;
	RangeSlider self;
	enum States {IDLE,CLICK_RIGHT_SIDE,CLICK_LEFT_SIDE,CLICK_RECT_RIGHT,CLICK_RECT_LEFT,DRAG_RECT_RIGHT,DRAG_LEFT_RECT,CLICK_MIDDLE,DRAG_MIDDLE};
	States state;
	public RangeSliderUI(RangeSlider o) {
		super(o);
		this.self = o;
		state = States.IDLE;
		gauche = new Rectangle(self.getValue(),0,10,20);
		droite = new Rectangle(self.getUpValue(),0,10,20);	
	}
	
	@Override
	protected TrackListener createTrackListener(JSlider slider) {
		return new RangeSliderEvent();
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
		
		gauche.x = self.getValue();
		droite.x = self.getUpValue();
		
		// middle
		g2D.setColor(Color.ORANGE);
		g2D.fillRect(gauche.x+gauche.width,0,droite.x-gauche.x,gauche.height);
		
		// left cursor
		g2D.setColor(Color.LIGHT_GRAY);
		g2D.fillRect(gauche.x, gauche.y, gauche.width, gauche.height);
		
		//right cursor
		g2D.setColor(Color.LIGHT_GRAY);
		g2D.fillRect(droite.x,droite.y,droite.width,droite.height);
		
		
		g2D.dispose();
	}

	
	private class RangeSliderEvent extends TrackListener{
		int old_x;
		
		States getPosition(MouseEvent e) {
			if(droite.contains(e.getPoint())){
				return States.CLICK_RECT_RIGHT;
			}else if(gauche.contains(e.getPoint())){
				return States.CLICK_RECT_LEFT;
			}else if(e.getX()<gauche.x){
				return States.CLICK_LEFT_SIDE;
			}else if(e.getX()>droite.x){
				return States.CLICK_RIGHT_SIDE;
			}else{
				return States.CLICK_MIDDLE;
			}
		}
		
		
		
		@Override
		public void mouseReleased(MouseEvent e) {
			state = States.IDLE;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			switch(state) {
			case IDLE:
				// où on a cliqué ?
				state = getPosition(e);
				switch(state){
				case CLICK_LEFT_SIDE:
					self.setSliderGauche(e.getX());
					state = States.IDLE;
					break;
				case CLICK_RIGHT_SIDE:
					self.setSliderDroite(e.getX());
					state = States.IDLE;
					break;
				default:
					break;
				}
		
				break;
			default:
				break;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			switch(state) {
			case CLICK_MIDDLE:
				self.setSliderGauche(e.getX());
				self.setSliderDroite(e.getX());
				break;
			case CLICK_RECT_LEFT:
				self.setSliderGauche(e.getX());
				break;
			case CLICK_RECT_RIGHT:
				self.setSliderDroite(e.getX());
				break;
			case DRAG_LEFT_RECT:
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
