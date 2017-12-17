package gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAO.CategoryDAO;
import DAO.expendDAO;
import DAO.incomeDAO;
import Services.recordService;
import entity.Category;
import entity.expend;
import entity.income;

public class incomeTableModel extends AbstractTableModel{
	
	String[] columnNames = new String[] { "时间","描述","分类","金额"};
	public List<income> cs=recordService.instance.ins;
//	public incomeTableModel(List<income> cs){
//		this.cs=cs;
//	}

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
		
		income s=cs.get(rowIndex);
		Category c= new CategoryDAO().get(s.C_id);
		if(columnIndex==0)
			return s.date;
		if(columnIndex==1)
			return s.comment;
		if(columnIndex==2)
			return c.type;
		if(columnIndex==3)
			return s.earn;
		return null;
	}

}
