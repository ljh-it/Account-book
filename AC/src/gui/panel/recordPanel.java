package gui.panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import org.jdesktop.swingx.JXDatePicker;

import com.alee.extended.panel.WebButtonGroup;
import com.alee.laf.button.WebButton;
import com.alee.laf.button.WebToggleButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebTextField;

import Services.CategoryService;
import entity.Category;
import gui.model.CategoryComboBoxModel;
import listener.RecordListener;
import util.GBC;

public class recordPanel extends WorkingPanel{
	public static recordPanel instance = new recordPanel();

  
    JLabel JMoney = new JLabel("金额");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");
    public JTextField tfSpend = new JTextField("0");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());
    public JToggleButton left = new JToggleButton ( "收入" );
    public JToggleButton right = new JToggleButton ( "支出" );
    public ButtonGroup textGroup = new ButtonGroup ();
    public WebButton b=new WebButton("保存");
    
	public recordPanel(){
		JMoney.setHorizontalAlignment(JLabel.CENTER);
		lCategory.setHorizontalAlignment(JLabel.CENTER);
		lComment.setHorizontalAlignment(JLabel.CENTER);
		lDate.setHorizontalAlignment(JLabel.CENTER);
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.add(kind(),BorderLayout.NORTH);
		this.add(center(),BorderLayout.CENTER);
		this.add(Submit(),BorderLayout.SOUTH);	
		addListener();
		
	}
	
	private Component kind(){
		JPanel p=new JPanel();
		p.setBackground(Color.WHITE);
		left.setActionCommand("收入");
		right.setActionCommand("支出");	
		textGroup.add(left);
		textGroup.add(right);
		p.add(left);
		p.add(right);

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
	    p.add(lDate);
	    p.add(datepick);	  
		return p;
	}
	
	private Component Submit(){
		JPanel p=new JPanel();
		p.setBackground(Color.WHITE);
		p.add(b);
		return p;
	}
	
    public void resetInput(){
        tfSpend.setText("0");
        tfComment.setText("");
        if(0!=cbModel.cs.size())
            cbCategory.setSelectedIndex(0);
        datepick.setDate(new Date());
    } 

	
	 public Category getSelectedCategory(){
	        return (Category) cbCategory.getSelectedItem();
	    }
	public static void main(String args[]){
		new showPanel(recordPanel.instance);

		 
		
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
		
		RecordListener listener =new RecordListener();
		b.addActionListener(listener);
		//right.addActionListener(listener);
		
		
	}

}
