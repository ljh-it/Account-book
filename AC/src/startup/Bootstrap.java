package startup;

import javax.swing.SwingUtilities;
import Frame.MainFrame;
import gui.panel.ChartPanel;
import gui.panel.MainPanel1;

import util.GUIUtil;

public class Bootstrap {
	public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();
 
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel1.instance.workingPanel.show(ChartPanel.instance);
            }
        });
    }

}
