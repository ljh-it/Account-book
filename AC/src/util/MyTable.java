package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

public class MyTable extends JTable{
	
	    private JPopupMenu m_popupMenu = new JPopupMenu();
        private JMenuItem MenItem1 = new JMenuItem();
        private JMenuItem MenItem2 = new JMenuItem();
	public MyTable(){
		createPopupMenu();
		this.addMouseListener(new java.awt.event.MouseAdapter() {  
            public void mouseClicked(MouseEvent evt) {  
                jTable1MouseClicked(evt);  
            }  
});  
	}
	private void createPopupMenu() {  
		 

        MenItem1.setText("  修改  ");  
        MenItem2.setText("  删除  ");
        MenItem1.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {  
                //该操作需要做的事  
            }  
        });  
        MenItem2.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {  
                //该操作需要做的事  
            }  
        });  
        m_popupMenu.add(MenItem1); 
        m_popupMenu.add(MenItem2);
        
    }
	private void jTable1MouseClicked(MouseEvent evt) {  
		  
	       mouseRightButtonClick(evt);  
	}  
	private void mouseRightButtonClick(MouseEvent evt) {  
	       //判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键  
	       if (evt.getButton() == MouseEvent.BUTTON3) {  
	           //通过点击位置找到点击为表格中的行  
	           int focusedRowIndex = this.rowAtPoint(evt.getPoint());  
	           if (focusedRowIndex == -1) {  
	               return;  
	           }  
	           //将表格所选项设为当前右键点击的行  
	           this.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);  
	           //弹出菜单  
	           m_popupMenu.show(this, evt.getX(), evt.getY());  
	       }  
	  
	   }  
	
	

}
