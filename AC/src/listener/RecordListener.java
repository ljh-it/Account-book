package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import com.alee.laf.button.WebButton;
import com.alee.laf.button.WebToggleButton;

import Services.recordService;
import entity.Category;
import gui.panel.DetailsPanel;
import gui.panel.SpendDetail;
import gui.panel.recordPanel;
import gui.panel.reportPanel;
import util.GUIUtil;

public class RecordListener implements ActionListener{
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		recordPanel r=recordPanel.instance;
		SpendDetail s=SpendDetail.instance;
		reportPanel re=reportPanel.instance;
		DetailsPanel de=DetailsPanel.instance;
		try{
		String option=r.textGroup.getSelection().getActionCommand();
		
		if(option=="收入"){
			
			 if(r.cbModel.cs.size()==0){
		            JOptionPane.showMessageDialog(r, "暂无消费分类，无法添加，请先增加消费分类");
		            //MainPanel.instance.workingPanel.show(CategoryPanel.instance);
		            return;
		        }
		         
		        if(!GUIUtil.checkZero(r.tfSpend,"收入金额"))
		            return;
		        float earn = Float.parseFloat(r.tfSpend.getText());
		        Category c = r.getSelectedCategory();
		        String comment = r.tfComment.getText();
		        Date d = r.datepick.getDate();
		        new recordService().addIn(earn, c, comment, d);
		        JOptionPane.showMessageDialog(r, "添加成功");
			
			
		}
		else if(option=="支出"){
			 if(r.cbModel.cs.size()==0){
		            JOptionPane.showMessageDialog(r, "暂无消费分类，无法添加，请先增加消费分类");
		            //MainPanel.instance.workingPanel.show(CategoryPanel.instance);
		            return;
		        }
		         
		        if(!GUIUtil.checkZero(r.tfSpend,"消费金额"))
		            return;
		        float spend = Float.parseFloat(r.tfSpend.getText());
		        Category c1 = r.getSelectedCategory();
		        String comment1 = r.tfComment.getText();
		        Date d1 = r.datepick.getDate();
		        new recordService().addEx(spend, c1, comment1, d1);
		        JOptionPane.showMessageDialog(r, "添加成功");
					
	  }
		}catch (NullPointerException oe){
			JOptionPane.showMessageDialog(r, "请选择收入或支出");
			return ;
		}
		
			
		
		
		r.updateData();
		s.updateData();
		re.updateData();
		de.updateData(de.potision);

  }
	
}
		
		
	


