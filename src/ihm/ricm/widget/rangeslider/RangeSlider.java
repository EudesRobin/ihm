package ihm.ricm.widget.rangeslider;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JSlider;

public class RangeSlider extends JSlider {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void updateUI() {
		//setUI(new RangeSliderUI(this));
		repaint();
	}
	
   public RangeSlider(int orientation, int extent, int min, int max, int value){
        this.orientation = orientation;
        sliderModel = new DefaultBoundedRangeModel(value, extent, min, max);
        sliderModel.setExtent(extent);
        sliderModel.addChangeListener(changeListener);
        setUI(new RangeSliderUI(this));
        updateUI();
     }
   
   /**
    * Set la val supérieur du RangeSlider
    * @param val valeur souhaité pour la valeur supérieur du RangeSlider
    */
   public void setSliderDroite(int val) {
	   // Cela revient à calculer une valeur d'extent, compte tenu des contraintes du slider :
	   // la valeur minimale entre
	   //	l'incrément qu'on prévoit de faire par rapport à la valeur du Slider "de gauche" (le max assure la positivité)
	   //   la valeur maximale d'un incrément (toujours par rapport au slider "de gauche")
	   this.setExtent(Math.min(Math.max(0,val-this.getValue()),this.getMaximum()-this.getValue()));
   }
   
   public int getUpValue() {
	   return (this.getValue() + this.getExtent());
   }
   
   //TODO setValue (vu qu'on calcule le slider droite par rapport à celui de gauche, et la valeur de extent...
   // besoin d'override ?
   

}