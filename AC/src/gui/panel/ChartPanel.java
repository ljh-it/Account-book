package gui.panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import listener.ChartChangeListener;
import util.GUIUtil;

public class ChartPanel extends WorkingPanel{
	
	public static ChartPanel instance=new ChartPanel();
	public JRadioButton r1,r2;
	public ButtonGroup include;
	public JPanel mainPanel=new JPanel();
	public CardLayout card=new CardLayout();
	public ChartPanel(){
		this.SetMainPanel();
		this.setLayout(new BorderLayout());
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(choosePanel(), BorderLayout.SOUTH);
		addListener();
		
		
	}
	private void SetMainPanel(){
		
		mainPanel.setLayout(card);
		mainPanel.add("1",SpendDetail.instance);
		mainPanel.add("2",reportPanel.instance);
				
		
		
	}
	private JPanel choosePanel(){
		JPanel p=new JPanel();
		p.setBackground(Color.WHITE);
		r1=new JRadioButton("");
		r2=new JRadioButton("");
		r1.setActionCommand("A");
		r2.setActionCommand("B");
		include=new ButtonGroup();
		include.add(r1);
		include.add(r2);
		p.add(r1);
		p.add(r2);
		
		return p;
	}
	
    public static void main(String[] args) {
       new showPanel(ChartPanel.instance);
    }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		ChartChangeListener listener=new ChartChangeListener();
		r1.addItemListener(listener);
		r2.addItemListener(listener);
		
	}

}
