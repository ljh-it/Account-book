package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.expendDAO;
import DAO.incomeDAO;
import gui.panel.DetailsPanel;

public class orderListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DetailsPanel d=DetailsPanel.instance;
		d.updateData();
		
		
	}
	

}
