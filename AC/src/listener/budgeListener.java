package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Services.ConfigService;
import gui.panel.SpendDetail;
import gui.panel.generalPanel;
import util.GUIUtil;

public class budgeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    	generalPanel p = generalPanel.instance;
    	SpendDetail s=SpendDetail.instance;
        if(!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
            return;
        ConfigService cs= new ConfigService();
        cs.update(ConfigService.budget,p.tfBudget.getText());
        JOptionPane.showMessageDialog(p, "预算修改成功");
        
        s.updateData();
				
	}

}
