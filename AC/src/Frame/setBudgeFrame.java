package Frame;

import javax.swing.JFrame;

import gui.panel.recordPanel;
import gui.panel.setBudgePanel;

public class setBudgeFrame extends JFrame{
	public static setBudgeFrame instance=new setBudgeFrame();
	public setBudgeFrame(){
	    this.setSize(420,250);
	    this.setTitle("预算");
	    this.setContentPane(setBudgePanel.instance);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String args[]){
		instance.setVisible(true);
	}

}
