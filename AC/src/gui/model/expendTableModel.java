package gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAO.CategoryDAO;
import DAO.expendDAO;
import Services.CategoryService;
import Services.recordService;
import entity.Category;
import entity.expend;

public class expendTableModel extends AbstractTableModel{
	String[] columnNames = new String[] { "时间","描述","分类","金额"};
	public List<expend> cs=recordService.instance.exs;
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return cs.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	public String getColumnName(int columnIndex) {
	         
	        return columnNames[columnIndex];
	  }
	  
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	        return false;
	    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		expend s=cs.get(rowIndex);
		Category c= new CategoryDAO().get(s.C_id);
		if(columnIndex==0)
			return s.date;
		if(columnIndex==1)
			return s.comment;
		if(columnIndex==2)
			return c.type;
		if(columnIndex==3)
			return s.spend;
		
		return null;
	}

}
