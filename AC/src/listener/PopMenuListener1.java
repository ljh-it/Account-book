package listener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebTextField;

import DAO.CategoryDAO;
import Services.CategoryService;
import Services.recordService;
import entity.Category;
import entity.expend;
import gui.model.CategoryComboBoxModel;
import gui.panel.DetailsPanel;
import gui.panel.SpendDetail;
import gui.panel.reportPanel;

public class PopMenuListener1 implements ActionListener{
	
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 DetailsPanel d=DetailsPanel.instance;
		 CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
		 JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
		 JXDatePicker datepick = new JXDatePicker(new Date());
		 expend ex;
		 Category ca;
		 WebTextField money;
		 WebTextField comment;
		
		JMenuItem jm=(JMenuItem) e.getSource();

		if(jm==d.MenItem1){
                    ex=d.getSelectedExpend();
                    ca=new CategoryDAO().get(ex.C_id);
			       	money=new WebTextField(String.valueOf(ex.spend),15);
			       	comment=new WebTextField(ex.comment,15);
	                WebPopOver popOver = new WebPopOver ();
	                popOver.setLayout ( new GridLayout(5,2));
	          
	                popOver.setMargin ( 10 );
	                popOver.setModal ( true );
	                
	                popOver.setMovable ( false );
	                popOver.setCloseOnFocusLoss ( true );
	                
	                
	                //WebImage icon = new WebImage ( WebLookAndFeel.getIcon ( 16 ) );
	                 WebLabel titleLabel = new WebLabel ( "Pop-over dialog", WebLabel.CENTER );
	                 
	                 WebButton updateButton=new WebButton("√",new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							float spend = Float.parseFloat(money.getText());
							Category c = (Category) cbCategory.getSelectedItem();
							String comments = comment.getText();
							Date ds = datepick.getDate();
							new recordService().updateEx(spend, c, comments, ds,ex.e_id);
							d.updateData(d.potision);
						}
	                	 
	                 }).setUndecorated ( true );
	                 WebButton closeButton = new WebButton ( "×",new ActionListener ()
	                {
	                   
	                    public void actionPerformed ( final ActionEvent e )
	                    {
	                        popOver.dispose ();
	                    }
	                } ).setUndecorated ( true );

	                popOver.add ( new WebLabel ( "金额:" ) );
	                popOver.add (money);
	                popOver.add ( new WebLabel ( "分类：" ) );
	                popOver.add ( cbCategory);
	                cbCategory.setSelectedIndex(getComboxId(cbModel,ca));
	                
	                popOver.add ( new WebLabel ( "备注:" ) );
	                popOver.add ( comment);
	                
	                popOver.add ( new WebLabel ( "时间:" ) );
	                popOver.add ( datepick);
	                datepick.setDate(ex.date);
	                popOver.add(updateButton);
	                popOver.add(closeButton);	                	                
	                popOver.show (d.title1);
	                
	            
	      

			
		}
		if(jm==d.MenItem2){
			expend c=d.getSelectedExpend();
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(d, "确认要删除？"))
                return;
            int id = c.e_id;
            new recordService().deleteEx(id);
		}
		
		d.updateData(d.potision);
		SpendDetail.instance.updateData();
		reportPanel.instance.updateData();
	}
	
	public int getComboxId(CategoryComboBoxModel cbModel,Category c){
		int i;
		for(i=0;i<cbModel.getSize();i++){
			if(cbModel.getElementAt(i).C_id==c.C_id){
				return i;
			}
		
		}
		return 0;


	}

}
