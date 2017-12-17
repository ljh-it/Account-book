package Frame;

import javax.swing.JFrame;


import gui.panel.recordPanel;

public class RecordFrame extends JFrame{
	public static RecordFrame instance = new RecordFrame();
	
	public RecordFrame(){
		
	    this.setSize(420,250);
	    this.setTitle("记账");
	    this.setContentPane(recordPanel.instance);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]){
		instance.setVisible(true);
	}

}