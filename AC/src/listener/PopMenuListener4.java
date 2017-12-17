package listener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.panel.GroupPanel;
import com.alee.extended.panel.GroupingType;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebTextField;

import DAO.CategoryDAO;
import Services.recordService;
import entity.Budge;
import entity.Category;
import entity.income;
import gui.model.CategoryComboBoxModel;
import gui.panel.DetailsPanel;
import gui.panel.SpendDetail;
import gui.panel.budgePanel;
import gui.panel.reportPanel;

public class PopMenuListener4 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		budgePanel bp=budgePanel.instance;
		CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
		JComboBox<Category> cbCategory = new JComboBox<>(cbModel);

		JMenuItem jm=(JMenuItem) e.getSource();
		if(jm==bp.Mupdate){
		    Budge bu=bp.getSelectedBudge();
		    Category ca=new CategoryDAO().get(bu.C_id);
		    WebTextField money=new WebTextField(String.valueOf(bu.spend),15);
		    WebTextField comment=new WebTextField(bu.comment,15);
		    WebPopOver popOver = new WebPopOver ();
		    popOver.setLayout ( new GridLayout(5,2));
            popOver.setModal ( true );
            popOver.setMovable ( false );
            popOver.setCloseOnFocusLoss ( true );
            popOver.setMargin ( 10 );
            
            //popOver.setLayout ( new VerticalFlowLayout () );      
            WebLabel titleLabel = new WebLabel ( "Pop-over dialog", WebLabel.CENTER );
            WebButton updateButton=new WebButton("√",new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					float spend = Float.parseFloat(money.getText());
					Category c = (Category) cbCategory.getSelectedItem();
					String comments = comment.getText();				
					new recordService().updateSB(spend, c, comments,bu.b_id);
					bp.updateData();
					popOver.dispose ();
				}
            	 
             }).setUndecorated ( true );
            WebButton closeButton = new WebButton ( "x", new ActionListener ()
            {
                @Override
                public void actionPerformed (ActionEvent e )
                {
                    popOver.dispose ();
                }
            } ).setUndecorated ( true );
            //popOver.add ( new GroupPanel ( GroupingType.fillMiddle, 4, titleLabel, closeButton ).setMargin ( 0, 0, 10, 0 ) );
            popOver.add ( new WebLabel ( "金额:" ) );
            popOver.add (money);
            popOver.add ( new WebLabel ( "分类：" ) );
            popOver.add ( cbCategory);
            cbCategory.setSelectedIndex(getComboxId(cbModel,ca));
            popOver.add ( new WebLabel ( "备注:" ) );
            popOver.add ( comment);
            popOver.add(updateButton);
            popOver.add(closeButton);
            popOver.show (bp.jl);

		}
		if(jm==bp.Madd){
		    Budge bua=bp.getSelectedBudge();
		    Category ca=new CategoryDAO().get(bua.C_id);
		    float spend=bua.spend;
		    String comment=bua.comment;
		    Date d=new Date();
		    if (bua.spend==0)  
		    	JOptionPane.showMessageDialog(bp, "消费金额不能为零");
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(bp, "确认要添加？"))
                return;
	        new recordService().addEx(spend, ca, comment, d);
	        JOptionPane.showMessageDialog(bp, "添加成功");
	        DetailsPanel.instance.updateData(DetailsPanel.instance.potision);
	        SpendDetail.instance.updateData();
	        reportPanel.instance.updateData();
							
		}
		if(jm==bp.Mdelete){
			Budge c=bp.getSelectedBudge();
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(bp, "确认要删除？"))
                return;
            int id = c.b_id;
            new recordService().deleteSB(id);
			
		}
		bp.updateData();
		
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
