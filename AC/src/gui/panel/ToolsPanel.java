package gui.panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.alee.laf.button.WebButton;
import com.alee.laf.toolbar.WebToolBar;


import listener.setingsListener;
import util.CenterPanel;
import util.GBC;
import util.GUIUtil;
import util.MyButton;
public class ToolsPanel extends WorkingPanel{
	public static ToolsPanel instance = new ToolsPanel();
	public WebToolBar cb = new WebToolBar();
	
	public WebButton sort=new WebButton();
	public WebButton currency=new WebButton();
	public WebButton backup=new WebButton();
	public WebButton general=new WebButton();
	public WebButton info=new WebButton();
	public CenterPanel center=new  CenterPanel(1);;
	public ToolsPanel(){
		this.setLayout(new BorderLayout());
		//center=
		this.setBackground(Color.WHITE);
		center.setBackground(Color.white);
		//center.show(categoryPanel.instance);
		
		this.add(HeadTPanel(),BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
		//center.show(categoryPanel.instance);
		addListener();

	}
	private Component HeadTPanel(){
		
		JPanel p=new JPanel();
		p.setBackground(Color.WHITE);
		cb.setFloatable(false);
		
		GUIUtil.setImageIcon(sort, "AC_category.png");
		GUIUtil.setImageIcon(currency,"AC_currency.png");
		GUIUtil.setImageIcon(backup,"AC_icloud.png");
		GUIUtil.setImageIcon(general,"AC_toolsetting.png");
		GUIUtil.setImageIcon(info,"AC_morehelp.png");
		sort.setUndecorated(true);
		currency.setUndecorated(true);
		backup.setUndecorated(true);
		general.setUndecorated(true);
		info.setUndecorated(true);
		cb.setUndecorated(true);
		cb.add(sort);
		cb.add(currency);
		cb.add(backup);
		cb.add(general);
		cb.add(info);		
		p.add(cb);		
		return p;
		
	}



		

	public static void main(String args[]){
		JFrame s=new JFrame();
		ToolsPanel ss=new ToolsPanel();
		//s.setLayout(new GridBagLayout());
		//s.add(ss,BorderLayout.CENTER);
		s.add(ss);
		s.setBounds(200,100,510,420);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		setingsListener listener = new setingsListener();
		sort.addActionListener(listener);
		currency.addActionListener(listener);
		backup.addActionListener(listener);
		general.addActionListener(listener);
		info.addActionListener(listener);
		
	}

}
