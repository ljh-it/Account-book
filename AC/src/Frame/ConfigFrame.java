package Frame;

import javax.swing.JFrame;

import gui.panel.ToolsPanel;
import gui.panel.recordPanel;

public class ConfigFrame extends JFrame{
	
	public static ConfigFrame instance=new ConfigFrame();
	
	public ConfigFrame(){
		this.setSize(510, 420);
		this.setContentPane(ToolsPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String args[]){
		instance.setVisible(true);
	}
	

}
