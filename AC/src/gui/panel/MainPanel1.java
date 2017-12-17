package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.alee.extended.image.WebImage;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.toolbar.ToolbarStyle;
import com.alee.laf.toolbar.WebToolBar;
import com.alee.managers.language.data.TooltipWay;
import com.alee.managers.tooltip.TooltipManager;

import entity.Order;
import listener.PopMenuListener3;
import listener.ToolBarListener;
import util.CenterPanel;
import util.GBC;
import util.GUIUtil;
import util.MyButton;

public class MainPanel1 extends WorkingPanel{
	public static MainPanel1 instance = new MainPanel1();
	
	public WebButton b1=new WebButton("");	
	public WebButton b2=new WebButton("  明细");
	public WebButton b3=new WebButton("  账户");
	public WebButton b4=new WebButton("  预算");
	public WebButton b5=new WebButton("  报表");
	public WebButton b6=new WebButton("");
	public WebButton b7=new WebButton("");
	public JPopupMenu pop;
    public JMenuItem MenItem1 = new JMenuItem();
    public JMenuItem MenItem2 = new JMenuItem();
    public WebToolBar aut = new WebToolBar ( WebToolBar.VERTICAL );
	public CenterPanel workingPanel;
	public Order order=new Order();

	public MainPanel1(){
       
		this.setLayout(new BorderLayout());
        workingPanel = new CenterPanel(1);
        workingPanel.setBackground(Color.WHITE);
        this.add(center(), BorderLayout.CENTER);
  
        this.add(south(), BorderLayout.SOUTH);
        addListener();
		
	}
	private JPopupMenu createPopupMenu() {  
		JPopupMenu m_popupMenu = new JPopupMenu();

        MenItem1.setText("  消费  ");  
        MenItem2.setText("  预算  "); 
        m_popupMenu.add(MenItem1); 
        m_popupMenu.add(MenItem2);
        return m_popupMenu;

	}

	private JPanel center() {
    	JPanel p = new JPanel();  
    	p.setBackground(Color.WHITE);
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(workingPanel,BorderLayout.CENTER);
        return p;
    }
    

    private Component west() {
    	
    	JPanel p = new JPanel();
    	p.setBackground(Color.white);       
        aut.setBackground(Color.white);
        aut.setFloatable ( false );
        aut.addSeparator();
        aut.setUndecorated ( true );
        
		GUIUtil.setImageIcon(b1, "AC_face3.png");
		GUIUtil.setImageIcon(b2, "AC_details.png");
        GUIUtil.setImageIcon(b3, "AC_user.png");
        GUIUtil.setImageIcon(b4, "AC_budge.png");
        GUIUtil.setImageIcon(b5, "AC_chart.png");
        GUIUtil.setImageIcon(b6, "AC_add.png");
        GUIUtil.setImageIcon(b7, "AC_setting.png");
        b1.setUndecorated ( true );
        b2.setUndecorated ( true );
        b3.setUndecorated ( true );
        b4.setUndecorated ( true );
        b5.setUndecorated ( true );
        //b1.setPreferredSize(new Dimension(45,45));
        b2.setPreferredSize(new Dimension(200,45));
        b3.setPreferredSize(new Dimension(200,45));
        b4.setPreferredSize(new Dimension(200,45));
        b5.setPreferredSize(new Dimension(200,45));
         
        aut.add(b1);
        aut.add(b2);
        aut.add(b3);
        aut.add(b4);
        aut.add(b5);
        p.add(aut);             
		return p;
    	
    }
    private JPanel south(){
    	JPanel p = new JPanel();
    	p.setBackground(Color.white); 
    	p.setLayout(new BorderLayout());
        WebToolBar aut = new WebToolBar ( WebToolBar.HORIZONTAL );
        aut.setUndecorated ( true );
        aut.setFloatable ( false );
        aut.setToolbarStyle ( ToolbarStyle.attached);
        aut.setComponentOrientation ( ComponentOrientation.LEFT_TO_RIGHT);
        pop=createPopupMenu();
        b6.setPreferredSize(new Dimension(35,30));
        b6.setBorderPainted(false);
        b7.setPreferredSize(new Dimension(35,30));
        b7.setBorderPainted(false);
        b6.setUndecorated ( true );
        b7.setUndecorated ( true );
        aut.add(b6);
        aut.add(b7);
        p.add(aut);

		return p;
    	
    }
    

    public static void main(String args[]){
    	    	 
	 new showPanel(MainPanel1.instance);
   	   	
    }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
        ToolBarListener listener = new ToolBarListener();
        PopMenuListener3 poplistener=new PopMenuListener3();
        b2.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        b6.addActionListener(listener);
        MenItem1.addActionListener(poplistener);
        MenItem2.addActionListener(poplistener);
        b7.addActionListener(listener);

	}
	
	

}
