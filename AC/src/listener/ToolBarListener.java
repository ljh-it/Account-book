package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingWorker;

import Frame.ConfigFrame;
import Frame.RecordFrame;
import gui.panel.ChartPanel;
import gui.panel.DetailsPanel;

import gui.panel.MainPanel1;
import gui.panel.SpendDetail;
import gui.panel.SpendPanel;
import gui.panel.ToolsPanel;
import gui.panel.budgePanel;
import gui.panel.categoryPanel;
import gui.panel.reportPanel;
import util.ColorUtil;

public class ToolBarListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        MainPanel1 p = MainPanel1.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.b2)
            p.workingPanel.show(DetailsPanel.instance);
        if (b == p.b4)
        	p.workingPanel.show(budgePanel.instance);
        if (b == p.b5){
            p.workingPanel.show(ChartPanel.instance);

            new SwingWorker() {

                
                protected Object doInBackground() throws Exception {
                    for (int i = 0; i < SpendDetail.instance.spend.usagePercentage; i++) {
                    	SpendDetail.instance.bar.setProgress(i + 1);
                    	SpendDetail.instance.bar.setForegroundColor(ColorUtil.getByPercentage(i + 1));
                        try {
                            Thread.sleep(8);
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    return null;
                }

            }.execute();
        }
        if (b == p.b6)
        	p.pop.show(p.b6, 0, 0);
        if (b == p.b7)
        	ConfigFrame.instance.main(null);

 
    }


}


