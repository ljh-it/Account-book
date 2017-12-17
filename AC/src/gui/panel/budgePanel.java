package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.panel.SingleAlignPanel;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;

import Services.recordService;
import entity.Budge;
import entity.expend;
import gui.model.BudgeTableModel;
import listener.ButtonDialogListener;
import listener.PopMenuListener4;
import listener.TableOptionListener;
import util.GUIUtil;

public class budgePanel extends WorkingPanel{
	public static budgePanel instance =new budgePanel();
	public JLabel jl=new JLabel("预算");
	public TextField tx=new TextField(15);
	public BudgeTableModel bumodel=new BudgeTableModel();
	public JTable butable=new JTable(bumodel);
	public JScrollPane sp=new JScrollPane(butable);
	public JPopupMenu pop;
    public JMenuItem Mupdate = new JMenuItem();
    public JMenuItem Madd = new JMenuItem();
    public JMenuItem Mdelete = new JMenuItem();
	JPanel j=new JPanel();
			
	 WebPopOver popOver = new WebPopOver (j);
	public budgePanel(){
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		j.add(jl);
		j.setBackground(Color.WHITE);
		pop=createPopupMenu();
		GUIUtil.makeFace(butable);
		butable.setShowGrid(false);
		this.add(j,BorderLayout.NORTH);
		this.add(sp,BorderLayout.CENTER);
		addListener();

	}
	private JPopupMenu createPopupMenu() {  
		JPopupMenu m_popupMenu = new JPopupMenu();

        Mupdate.setText("  修改  ");  
        Madd.setText("  添加消费  "); 
        Mdelete.setText("  删除  ");
        m_popupMenu.add(Mupdate); 
        m_popupMenu.add(Madd);
        m_popupMenu.add(Mdelete);
        return m_popupMenu;

	}
	public Budge getSelectedBudge(){
		int i=butable.getSelectedRow();
		return bumodel.bu.get(i);
	}
	public static void main(String args[]){
		new showPanel(budgePanel.instance);
	}
	

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		recordService.instance.listBu();
		bumodel.bu=recordService.instance.bus;
		butable.updateUI();
		GUIUtil.makeFace(butable);
		butable.setShowGrid(false);
	  
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		TableOptionListener tbo=new TableOptionListener(butable,pop);
		PopMenuListener4 poplistener=new PopMenuListener4();
		butable.addMouseListener(tbo);
		Mupdate.addActionListener(poplistener);
		Madd.addActionListener(poplistener);
		Mdelete.addActionListener(poplistener);
		
		
	}

}
