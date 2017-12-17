package gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAO.CategoryDAO;
import Services.recordService;
import entity.Budge;
import entity.Category;
import entity.expend;

public class BudgeTableModel extends AbstractTableModel {
	
	String[] columnNames = new String[] { "分类","描述","金额"};
	public List<Budge> bu=recordService.instance.bus;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return bu.size();
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
		Budge b=bu.get(rowIndex);
		Category c=new CategoryDAO().get(b.C_id);
		if(columnIndex==0) return c.type;
		if(columnIndex==1) return b.comment;
		if(columnIndex==2) return b.spend;
		return null;
	}

}
