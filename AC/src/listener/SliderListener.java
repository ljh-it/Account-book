package listener;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.alee.extended.window.WebPopOver;

import DAO.expendDAO;
import DAO.incomeDAO;
import Services.recordService;
import gui.model.expendTableModel;
import gui.model.incomeTableModel;
import gui.panel.DetailsPanel;


public class SliderListener implements ChangeListener{
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		DetailsPanel d=DetailsPanel.instance;
		recordService rd=recordService.instance;
		JSlider js=(JSlider) e.getSource();
		int num=js.getValue();
		d.potision=num;
		d.updateData(num);


		
	}

}
