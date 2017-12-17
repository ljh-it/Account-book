package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;

import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.panel.SingleAlignPanel;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.slider.WebSlider;

import gui.panel.DetailsPanel;




public class ButtonDialogListener implements ActionListener {


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	  DetailsPanel.instance.choose.show ( ( WebButton ) e.getSource () );
	            		
	}

}
