package listener;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.alee.extended.window.PopOverDirection;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;

import gui.panel.DetailsPanel;

public class ButtonDialogListenerOrder implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DetailsPanel d=DetailsPanel.instance;
		d.pop3.show(d.wa, 0, 0);

	}
   
	
	

}
