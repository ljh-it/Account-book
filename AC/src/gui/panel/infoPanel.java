package gui.panel;

import java.awt.Color;

import com.alee.laf.label.WebLabel;

public class infoPanel extends WorkingPanel{
	
	public static infoPanel instance=new infoPanel();
	public WebLabel iw=new WebLabel("累得呀皮");
	public infoPanel(){	
		this.add(iw);
		this.setBackground(Color.white);
		
	}
	
	

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

}
