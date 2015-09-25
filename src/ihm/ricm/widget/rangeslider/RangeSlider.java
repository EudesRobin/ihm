package ihm.ricm.widget.rangeslider;


import java.awt.Graphics;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JSlider;

public class RangeSlider extends JSlider {

	
	public void updateUI() {
		//TODO
	}
	
    public RangeSlider(int orientation, int extent, int min, int max, int value){
    	
         this.orientation = orientation;
         sliderModel = new DefaultBoundedRangeModel(value, extent, min, max);
         sliderModel.setExtent(0);
         sliderModel.addChangeListener(changeListener);
         updateUI();
     }

}
