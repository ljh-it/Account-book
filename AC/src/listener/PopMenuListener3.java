package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Frame.RecordFrame;
import Frame.setBudgeFrame;
import gui.panel.MainPanel1;

public class PopMenuListener3 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainPanel1 m=MainPanel1.instance;
		JMenuItem jm=(JMenuItem) e.getSource();
		if(jm==m.MenItem1){
			
			RecordFrame.instance.main(null);
		}
		if(jm==m.MenItem2){
			setBudgeFrame.instance.main(null);
		}
		
		
		
		
	}

}
