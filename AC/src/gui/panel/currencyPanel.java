package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.alee.laf.table.WebTable;

import gui.model.currencyTableModel;
import util.GUIUtil;
import util.MyButton;

public class currencyPanel extends WorkingPanel{
	public static currencyPanel instance=new currencyPanel();
	
	public currencyTableModel huobi=new currencyTableModel();
	public WebTable cw=new WebTable(huobi);
	public MyButton ch=new MyButton("选择货币");
	
	public currencyPanel(){
		this.setLayout(new BorderLayout());
		GUIUtil.makeFace(cw);
		JScrollPane js=new JScrollPane(cw);
		this.add(js,BorderLayout.CENTER);
		this.add(submit(),BorderLayout.SOUTH);
		this.setBackground(Color.WHITE);
		
	}
	
	private Component submit(){
		JPanel p=new JPanel();
		p.setBackground(Color.WHITE);
		p.add(ch);
		
		return p;
	}
	public static void main(String args[]){
		JFrame m=new JFrame();
		m.setSize(400, 500);
		m.add(currencyPanel.instance);
		m.setVisible(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		GUIUtil.makeFace(cw);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
	

}
