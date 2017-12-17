package Services;

import java.util.Collections;
import java.util.List;

import DAO.CategoryDAO;

import entity.Category;


public class CategoryService {
	CategoryDAO cdao =new CategoryDAO();
	public List<Category> list(){
		List<Category> cs= cdao.list();
//		for(Category c :cs){
//			List<Record> rs=rdao.list(c.id);
//			c.recordNumber=rs.size();
//		}
//		Collections.sort(cs,(c1,c2) ->c2.recordNumber-c1.recordNumber);//归并排序		
		return cs;	
		
	}
	public void add(String name){
		Category c=new Category();
		c.setName(name);
		cdao.add(c);
		
	}
	public void update(int id,String name){
		Category c=new Category();
		c.setName(name);
		c.setId(id);
		cdao.update(c);
		
	}
	public void delete(int id){
		cdao.delete(id);
	}
		   

}
