package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import Services.ConfigService;
import gui.panel.SpendDetail;
import gui.panel.backupPanel;
import gui.panel.generalPanel;
import util.GUIUtil;

public class ConfigListener implements ActionListener{
 
  
    public void actionPerformed(ActionEvent e) {
    	backupPanel p = backupPanel.instance;
    	

        String mysqlPath =p.jt.getText();
        if(0!=mysqlPath.length()){
            File commandFile = new File(mysqlPath,"bin/mysql");
            if(!commandFile.exists()){
                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
                p.jt.grabFocus();
                return;
            }
        }
        ///usr/local/mysql-5.7.20-macos10.12-x86_64/bin/mysqldump
        ConfigService cs= new ConfigService();
        cs.update(ConfigService.mysqlPath,mysqlPath);
         
        JOptionPane.showMessageDialog(p, "设置修改成功");
        
      
 
    }



 
}

