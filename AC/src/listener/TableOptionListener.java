package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import gui.panel.DetailsPanel;
import gui.panel.WorkingPanel;

public class TableOptionListener implements MouseListener{

	
	public JTable j;
	public JPopupMenu pop;
	
	public TableOptionListener(JTable j,JPopupMenu pop){
		this.j=j;
		this.pop=pop;
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		mouseRightButtonClick(e,j);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void jTable1MouseClicked(MouseEvent evt,JTable t)  {  
		  
	       mouseRightButtonClick(evt,t);  
	}  
	private void mouseRightButtonClick(MouseEvent evt,JTable t) {
		    //DetailsPanel d=DetailsPanel.instance;
	       //判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键  
	       if (evt.getButton() == MouseEvent.BUTTON3) {  
	           //通过点击位置找到点击为表格中的行  
	           int focusedRowIndex = t.rowAtPoint(evt.getPoint());	   
	           if (focusedRowIndex == -1) {  
	               return;  
	           }  
	           //将表格所选项设为当前右键点击的行  
	           t.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);  	       
	           //弹出菜单  
	           pop.show(t, evt.getX(), evt.getY());
	         
	       }  
	  
	   }  

}
