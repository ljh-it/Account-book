package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Services.recordService;
import entity.Category;
import gui.panel.budgePanel;
import gui.panel.setBudgePanel;
import util.GUIUtil;

public class setBudgeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setBudgePanel sb=setBudgePanel.instance;
		if(sb.cbModel.cs.size()==0){
            JOptionPane.showMessageDialog(sb, "暂无消费分类，无法添加，请先增加消费分类");
            //MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
         
        if(!GUIUtil.checkZero(sb.tfSpend,"收入金额"))
            return;
        float spend = Float.parseFloat(sb.tfSpend.getText());
        Category c = sb.getSelectedCategory();
        String comment = sb.tfComment.getText();
        
        new recordService().addSB(spend, c, comment);
        JOptionPane.showMessageDialog(sb, "添加成功");
		
		sb.updateData();
		budgePanel.instance.updateData();
		
	}

}
