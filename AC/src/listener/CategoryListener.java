package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Services.CategoryService;
import entity.Category;
import gui.panel.categoryPanel;
import gui.panel.recordPanel;
import gui.panel.setBudgePanel;

public class CategoryListener implements ActionListener{
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		categoryPanel p=categoryPanel.instance;
		recordPanel r=recordPanel.instance;
		JButton b=(JButton) e.getSource();
		
		if(b==p.bAdd){
		    String name = JOptionPane.showInputDialog(null);
            if ( name.length()==0) {
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }
 
            new CategoryService().add(name);
		}
		
		 if (b == p.bEdit) {
	            Category c = p.getSelectedCategory();
	            int id = c.C_id;
	            String name = JOptionPane.showInputDialog("修改分类名称", c.type);
	            if (name.length()==0) {
	                JOptionPane.showMessageDialog(p, "分类名称不能为空");
	                return;
	            }
	 
	            new CategoryService().update(id, name);
	        }
	        if (b == p.bDelete) {
	            Category c = p.getSelectedCategory();
	            if (c.recordNumber!=0) {
	                JOptionPane.showMessageDialog(p, "本分类下有消费记录存在，不能删除");
	                return;
	            }
	            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确认要删除？"))
	                return;
	 
	            int id = c.C_id;
	            new CategoryService().delete(id);
	        }
		
		p.updateData();
		r.updateData();
		setBudgePanel.instance.updateData();
	}

}
