package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Services.ConfigService;
import listener.ConfigListener;
import listener.budgeListener;
import util.ColorUtil;
import util.GUIUtil;

public class generalPanel extends WorkingPanel {
	public static generalPanel instance=new generalPanel();
	public JLabel jl=new JLabel("通用设置");
	 
    JLabel lBudget = new JLabel("本月总预算(￥)");
    public int ss=new ConfigService().getIntBudget();
    public JTextField tfBudget = new JTextField(String.valueOf(ss),15);
      
    JButton bSubmit = new JButton("更新");
 
    public generalPanel() {
       
        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        pInput.setBackground(Color.white);
        pSubmit.setBackground(Color.white);
        pInput.add(lBudget);
        pInput.add(tfBudget);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
         
        pSubmit.add(bSubmit);
        this.add(pSubmit,BorderLayout.CENTER);
        addListener();
         
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(generalPanel.instance);
    }
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		budgeListener l =new budgeListener();
	      bSubmit.addActionListener(l);
	}

}
