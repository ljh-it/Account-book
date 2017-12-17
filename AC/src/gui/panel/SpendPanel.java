package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;

import util.GUIUtil;

public class SpendPanel extends WorkingPanel{
	
	static{
		GUIUtil.useLNF();
	}
	public static SpendPanel instance = new SpendPanel();
	public SpendDetail sp = new SpendDetail();
	public SpendPanel(){
		this.setLayout(new BorderLayout());

	    this.add(center2(),BorderLayout.CENTER);
		this.add(south(),BorderLayout.SOUTH);
		//this.add(center2());

		
	}
	
	private Component center2(){
		    
	    	sp.setBackground(Color.white);
			return sp;
	    	
	    }
	  private JPanel south(){
	    	JPanel p = new JPanel();
	    	String[] headers = { "Header 1", "Header 2", "Header 3", "Header 4", "Header 5", "Header 6" };
	        String[][] data = { { "1", "2", "3", "4", "5", "6" }, { "7", "8", "9", "10", "11", "12" }, { "13", "14", "15", "16", "17", "18" },
	                { "19", "20", "21", "22", "23", "24" }, { "25", "26", "27", "28", "29", "30" }, { "31", "32", "33", "34", "35", "36" },
	                { "37", "38", "39", "40", "41", "42" }, { "43", "44", "45", "46", "47", "48" }, { "49", "50", "51", "52", "53", "54" } };

	        // Static table
	        WebTable table = new WebTable (data, headers);
	        
	        table.setEditable ( false );
	        table.setAutoResizeMode ( WebTable.AUTO_RESIZE_OFF );
	        table.setRowSelectionAllowed ( false );
	        table.setColumnSelectionAllowed ( true );
	        table.setPreferredScrollableViewportSize ( new Dimension ( 450, 150 ) );
	        JScrollPane j=new JScrollPane(table);
	       // table.getColumnModel().getColumn(0).setPreferredWidth(10);  设置列宽度
	        //j.setViewportView(t);
	       // j.add(table);
	         p.add(j);
	   
			return p;
	    	
	    }  
	
	 
	 public static void main(String args[]){

		 GUIUtil.showPanel(SpendPanel.instance);
		 
	 }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
	 
	

}
