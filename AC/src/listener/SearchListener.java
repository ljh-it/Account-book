package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;


import Services.CategoryService;
import Services.recordService;
import entity.Category;
import gui.panel.DetailsPanel;

public class SearchListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		// TODO Auto-generated method stub
		DetailsPanel d=DetailsPanel.instance;
		//if(e.getSource()==d.search){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			
			String type=d.search.getText();
			if(d.search.getText().trim().equals("")){
				recordService.instance.listEx();
				recordService.instance.listIn();
			}
			else{
			int id=getCategoryId(type);

				recordService.instance.listExCID(id);
				recordService.instance.listInCID(id);			
			}				
		}
		d.updateData();
		}
	//}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public int getCategoryId(String type){
		
		List<Category> cas=new CategoryService().list();
		for(Category c :cas){
			if(c.type.equalsIgnoreCase(type))
				return c.C_id;
		}
		return 0;
		
	}

}
