package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Services.reportInService;
import entity.expend;
import util.ChartUtil;
import util.GUIUtil;

public class reportPanel extends WorkingPanel {
	public static reportPanel instance = new reportPanel();
	 
    public JLabel l = new JLabel();
 
    public reportPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        List<expend> rs = new reportInService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 500, 300);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
        addListener();
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(reportPanel.instance);
    }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
        List<expend> rs = new reportInService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 500, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

}
