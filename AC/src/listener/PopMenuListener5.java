package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Services.recordService;
import entity.Order;
import gui.panel.DetailsPanel;
import gui.panel.MainPanel1;


public class PopMenuListener5 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem jm=(JMenuItem) e.getSource();
		recordService rd=recordService.instance;
		DetailsPanel d=DetailsPanel.instance;
		
		if(jm==d.MenItem5){
			rd.order.setVertical(true);
		}
		if(jm==d.MenItem6){
			rd.order.setVertical(false);
		}
		if(jm==d.MenItem7){
			rd.order.setType(true);

		}
		if(jm==d.MenItem8){
			rd.order.setType(false);
		}
		d.pop3=d.createPopupMenu3();
		d.updateData(d.potision);
	}

}
