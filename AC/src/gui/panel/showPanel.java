package gui.panel;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import util.CenterPanel;

public class showPanel extends JPanel{
	public showPanel(Component p) {
	        JFrame f = new JFrame();
	        f.setSize(800,550);
	        f.setLocationRelativeTo(null);
	        f.add(p);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);

	    }
		

}
