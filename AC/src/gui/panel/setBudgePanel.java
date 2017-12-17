package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.alee.laf.button.WebButton;

import Services.CategoryService;
import entity.Category;
import gui.model.CategoryComboBoxModel;
import listener.setBudgeListener;

public class setBudgePanel extends WorkingPanel{
	public static setBudgePanel instance=new setBudgePanel();
    JLabel JMoney = new JLabel("金额");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    public JTextField tfSpend = new JTextField("0");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public WebButton b=new WebButton("保存");
	public setBudgePanel(){
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		JMoney.setHorizontalAlignment(JLabel.CENTER);
		lCategory.setHorizontalAlignment(JLabel.CENTER);
		lComment.setHorizontalAlignment(JLabel.CENTER);
		this.add(head(),BorderLayout.NORTH);
		this.add(center(),BorderLayout.CENTER);
		this.add(Submit(),BorderLayout.SOUTH);
		addListener();
	}
	private Component head(){
		JPanel p=new JPanel();
		p.setBackground(Color.WHITE);
		return p;
	}
	private Component center(){
		
		JPanel p=new JPanel();	
		p.setBackground(Color.WHITE);
		int gap = 40;
		p.setLayout(new GridLayout(4,2,5,20));    
	    p.add(JMoney);
	    p.add(tfSpend);
	    p.add(lCategory);
	    p.add(cbCategory);
	    p.add(lComment);
	    p.add(tfComment);
	  
		return p;
	}
	private Component Submit(){
		JPanel p=new JPanel();
		p.setBackground(Color.WHITE);
		p.add(b);
		return p;
	}
	 public Category getSelectedCategory(){
	        return (Category) cbCategory.getSelectedItem();
	    }
	
	
	public static void main(String args[]){
		new showPanel(setBudgePanel.instance);

		 
		
	}
	public void resetInput(){
	        tfSpend.setText("0");
	        tfComment.setText("");
	        if(0!=cbModel.cs.size())
	            cbCategory.setSelectedIndex(0);
	        //datepick.setDate(new Date());
	    } 

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
	    cbModel.cs = new CategoryService().list();
        cbCategory.updateUI();
        resetInput();
        tfSpend.grabFocus();
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		setBudgeListener sbl=new setBudgeListener();
		b.addActionListener(sbl);
	}

}
