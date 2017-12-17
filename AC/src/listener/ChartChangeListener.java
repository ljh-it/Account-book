package listener;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;

import gui.panel.ChartPanel;

public class ChartChangeListener implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		ChartPanel c=ChartPanel.instance;
		JRadioButton j=(JRadioButton) e.getSource();
//		String option=c.include.getSelection().getActionCommand();
		if(j==c.r1)
			c.card.show(c.mainPanel,"1");
		if(j==c.r2)
			c.card.show(c.mainPanel,"2");
		  
		
		
	}
	

}
