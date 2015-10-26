package ihm.ricm.widget.rangeslider;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JSlider;

public class RangeSlider extends JSlider {

	private static final long serialVersionUID = 1L;

	public RangeSlider(int orientation, int extent, int min, int max, int value){
		this.orientation = orientation;
		sliderModel = new DefaultBoundedRangeModel(value, extent, min, max);
		sliderModel.setExtent(extent);
		sliderModel.addChangeListener(changeListener);

		updateUI();
	}
	
	@Override
	public void updateUI() {
		setUI(new RangeSliderUI(this));
		updateLabelUIs();
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

	/**
	 * Rien de spé ici.
	 */
	@Override
	public int getValue() {
		return super.getValue();
	}

	/**
	 * On override, redirection vers notre fonction, pour set le rect gauche.
	 */
	@Override
	public void setValue(int n) {
		setSliderGauche(n);
	}


	/**
	 * la position du rect droite
	 * @return la position du rect droite
	 */
	public int getUpValue() {
		return (this.getValue() + this.getExtent());
	}

	/**
	 * Set rect gauche
	 * @param n la position souhaitée
	 */
	public void setSliderGauche(int n) {
		int old = this.getValue();
		
		// on s'assure que la nouvelle valeur soit inférieur au rect droite, et supérieur au min.
		int new_val = Math.min(Math.max(getMinimum(),n),getUpValue());
		int new_extent = old-new_val+getExtent();
		
		// On est obligé d'appeler cette méthode, vu qu'on a override setValue ;)
		this.getModel().setRangeProperties(new_val,new_extent,getMinimum(),getMaximum(),getValueIsAdjusting());
	}

}