package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import com.alee.laf.button.WebButton;
import com.alee.laf.table.WebTable;
import com.alee.laf.toolbar.WebToolBar;

import Services.CategoryService;
import entity.Category;
import gui.model.CategoryTableModel;

import listener.CategoryListener;
import util.ColorUtil;
import util.GUIUtil;
import util.MyButton;

public class categoryPanel extends WorkingPanel{
	
	public static categoryPanel instance = new categoryPanel();
	public WebButton bAdd = new WebButton("新增");
    public WebButton bEdit = new WebButton("编辑");
    public WebButton bDelete = new WebButton("删除");
    public WebToolBar ba=new WebToolBar();
     
    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t =new JTable(ctm);
     
    public categoryPanel() {
 
        JScrollPane sp =new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.setBackground(Color.WHITE);
        ba.setFloatable(false);
        ba.add(bAdd);
        
        ba.add(bEdit);
        ba.add(bDelete);
        ba.setUndecorated(true);
        pSubmit.add(ba);
        GUIUtil.makeFace(t);
        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);
        this.setBackground(Color.WHITE);
        addListener();
    }
    public static void main(String[] args) {
        GUIUtil.showPanel(categoryPanel.instance);
    }
    
    
    public Category getSelectedCategory() {
        int index = t.getSelectedRow();
        return ctm.cs.get(index);
    }
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		ctm.cs=new CategoryService().list();
		t.updateUI();
		GUIUtil.makeFace(t);
		t.getSelectionModel().setSelectionInterval(0, 0);
		 if(0==ctm.cs.size()){
	            bEdit.setEnabled(false);
	            bDelete.setEnabled(false);
	        }
	        else{
	            bEdit.setEnabled(true);
	            bDelete.setEnabled(true);
	     }

	}
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		CategoryListener listener = new CategoryListener();
		bAdd.addActionListener(listener);
		bEdit.addActionListener(listener);
		bDelete.addActionListener(listener);
	}
	

}
