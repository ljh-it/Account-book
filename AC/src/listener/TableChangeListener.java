package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToggleButton;

import gui.panel.DetailsPanel;

public class TableChangeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DetailsPanel d=DetailsPanel.instance;
		JToggleButton b=(JToggleButton) e.getSource();
		if(b==d.wc){
			d.card.show(d.kj,"1");
		}
		if(b==d.wd){
			d.card.show(d.kj,"2");
		}
		
		
		
	}

}
