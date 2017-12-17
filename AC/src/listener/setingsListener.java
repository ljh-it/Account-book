package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.panel.ToolsPanel;
import gui.panel.backupPanel;
import gui.panel.categoryPanel;
import gui.panel.currencyPanel;
import gui.panel.generalPanel;
import gui.panel.infoPanel;
import gui.panel.recordPanel;

public class setingsListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ToolsPanel t1=ToolsPanel.instance;
		
		JButton b = (JButton) e.getSource();
		
		if(b==t1.sort)
			t1.center.show(categoryPanel.instance);
		if(b==t1.currency)
			t1.center.show(currencyPanel.instance);
		if(b==t1.backup)
			t1.center.show(backupPanel.instance);
		if(b==t1.general)
			t1.center.show(generalPanel.instance);
		if(b==t1.info)
			t1.center.show(infoPanel.instance);
		
		
	}

}
