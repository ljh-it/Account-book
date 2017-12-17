package gui.panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import com.alee.extended.image.WebImage;
import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.panel.SingleAlignPanel;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.button.WebButton;
import com.alee.laf.button.WebToggleButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.slider.WebSlider;
import com.alee.laf.text.WebTextField;
import com.alee.laf.toolbar.WebToolBar;

import DAO.expendDAO;
import DAO.incomeDAO;
import Services.recordService;
import entity.Order;
import entity.expend;
import entity.income;
import gui.model.expendTableModel;
import gui.model.incomeTableModel;
import listener.ButtonDialogListener;
import listener.ButtonDialogListenerOrder;
import listener.PopMenuListener1;
import listener.PopMenuListener2;
import listener.PopMenuListener5;
import listener.SearchListener;
import listener.SliderListener;
import listener.TableChangeListener;
import listener.TableOptionListener;
import listener.orderListener;
import util.GUIUtil;

public class DetailsPanel extends WorkingPanel{
	
	public static DetailsPanel instance=new DetailsPanel();
	public recordService rd=recordService.instance;
	public JPopupMenu pop1,pop2,pop3;
	public int potision=3;
    public JMenuItem MenItem1 = new JMenuItem();
    public JMenuItem MenItem2 = new JMenuItem();
    public JMenuItem MenItem3 = new JMenuItem();
    public JMenuItem MenItem4 = new JMenuItem();
    public JMenuItem MenItem5 = new JMenuItem();
    public JMenuItem MenItem6 = new JMenuItem();
    public JMenuItem MenItem7 = new JMenuItem();
    public JMenuItem MenItem8 = new JMenuItem();
	public expendTableModel exm=new expendTableModel();	
	public JTable j1=new JTable(exm);
	public incomeTableModel inm=new incomeTableModel();	
	public JTable j2=new JTable(inm);
	public JPanel k=new JPanel();
	public JPanel k2=new JPanel();
	public JPanel kj=new JPanel();
	public JToolBar tb=new JToolBar();
	public WebButton wb;
	public WebButton wa;
	public WebToggleButton wc;
	public WebToggleButton wd;
	public ButtonGroup include;
	public WebSlider slider1;
	public WebPopOver choose;
	public WebLabel l1;
	public JLabel title1;
	public JLabel title2;
    public String name1="  升序   ";
    public String name2="  降序   ";
    public String name3="  时间   ";
    public String name4="  金额   ";
    public WebTextField search = new WebTextField ( 12 );
    
	//public Order order=new Order();
    public CardLayout card=new CardLayout();
    
	public DetailsPanel(){
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		pop1=createPopupMenu1();
		pop2=createPopupMenu2();
		pop3=createPopupMenu3();
		//createPopupMenu3();
		choose=createPopOver();
	    GUIUtil.makeFace(j1);
	    GUIUtil.makeFace(j2);
	    j1.setShowGrid(false);
	    j2.setShowGrid(false);
		this.add(CenterPanel(kj),BorderLayout.CENTER);
		this.add(upPanel(),BorderLayout.NORTH);
		this.addListener();
	}
	
	private JPanel upPanel(){
		JPanel p=new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new BorderLayout());
		WebToolBar barw=new WebToolBar();
		WebToolBar bare=new WebToolBar();
		barw.setUndecorated(true);
		bare.setUndecorated(true);
		wb=new WebButton(" 筛选 ");
		wa=new WebButton(" 排序 ");  
		search.setInputPrompt ( "输入类别..." );
		search.setTrailingComponent ( new WebImage (  "/Users/lujuhong/Documents/workspace/AC/img/AC_search2.png"  ) );
	
		barw.add(wa);
		barw.add(wb);
		bare.add(search);
		search.addKeyListener(new SearchListener());
	
		p.add(barw,BorderLayout.WEST);
		p.add(bare,BorderLayout.EAST);
		//p.add(wa);
		
		
		return p;
	}


	private JPanel CenterPanel(JPanel kj){
		kj.setLayout(card);
		k.setLayout(new BorderLayout());
		title1=new JLabel("支出",JLabel.CENTER);
		title2=new JLabel("收入",JLabel.CENTER);
		k.add(title1,BorderLayout.NORTH);
        k.add(j1,BorderLayout.CENTER);
        k.setBackground(Color.WHITE);
        k2.setLayout(new BorderLayout());
        k2.add(title2,BorderLayout.NORTH);
        k2.add(j2,BorderLayout.CENTER);
        k2.setBackground(Color.WHITE);
        JScrollPane mainScroll1 = new JScrollPane(k);
        JScrollPane mainScroll2 = new JScrollPane(k2);       
        kj.add("1",mainScroll1);
        kj.add("2",mainScroll2);
        kj.setBackground(Color.WHITE);
		return kj;
	}
	private JPopupMenu createPopupMenu1() {  
		JPopupMenu m_popupMenu = new JPopupMenu();

        MenItem1.setText("  修改  ");  
        MenItem2.setText("  删除  "); 
        m_popupMenu.add(MenItem1); 
        m_popupMenu.add(MenItem2);
        return m_popupMenu;

	}	
	private WebPopOver createPopOver(){
		 WebPopOver p=new WebPopOver();
		 l1=new WebLabel("前7天    前30天    前90天     全部");	
		 //WebSlider slider1;
		 p.setModal ( true );
	     p.setMargin ( 10 );
	     p.setMovable ( false );
	     p.setLayout ( new VerticalFlowLayout () );
	     p.setCloseOnFocusLoss ( true );
	     slider1= new WebSlider ( WebSlider.HORIZONTAL );
	     slider1.setPaintTicks ( true );
	     slider1.setMinimum ( 0 );
	     slider1.setMaximum ( 3 );
	     slider1.setMajorTickSpacing (1);
	     slider1.setPaintLabels(false);
	     slider1.setPaintTrack(true);
	     slider1.setSnapToTicks(true);
	     
	     slider1.addChangeListener(new SliderListener());
		 wc=new WebToggleButton("支出");
		 wd=new WebToggleButton("收入");
		 wc.setActionCommand("E");
		 wd.setActionCommand("I");

		 include=new ButtonGroup();
		 include.add(wc);
		 include.add(wd);
	     p.add(slider1);
	     p.add(l1);
	     p.add(new WebLabel("类别:"));
	     p.add(wc);
	     p.add(wd);
	 	     
	     p.add ( new SingleAlignPanel ( new WebButton ( "✘ ", new ActionListener ()
        {
            @Override
            public void actionPerformed ( final ActionEvent e )
            {
                p.dispose();
            }

		
        } ).setUndecorated ( true ), SingleAlignPanel.RIGHT ).setMargin ( 10, 0, 0, 0 ) );
	     return p;
	}
	private JPopupMenu createPopupMenu2() {  
		JPopupMenu m_popupMenu = new JPopupMenu();

		MenItem3.setText("  修改  ");  
		MenItem4.setText("  删除  "); 
        m_popupMenu.add(MenItem3); 
        m_popupMenu.add(MenItem4);
        return m_popupMenu;

	}
	public JPopupMenu createPopupMenu3() {  
		JPopupMenu m_popupMenu = new JPopupMenu();
		if(rd.order.vertical){
			if(rd.order.type){
				name1=" o升序   ";
				name2="   降序   ";
				name3=" o时间   ";
				name4="   金额   ";
			}
			else{
				name1=" o升序   ";
				name2="   降序   ";
				name3="   时间   ";
				name4=" o金额   ";
			}
			
		}
		else{
			if(rd.order.type){
				name1="   升序   ";
				name2=" o降序   ";
				name3=" o时间   ";
				name4="   金额   ";
			}
			else{
				name1="   升序   ";
				name2=" o降序   ";
				name3="   时间   ";
				name4=" o金额   ";
			}
			
		}
		MenItem5.setText(name1);  
        MenItem6.setText(name2); 
        MenItem7.setText(name3);
        MenItem8.setText(name4);
        m_popupMenu.add(MenItem5);
        m_popupMenu.add(MenItem6);
        m_popupMenu.addSeparator ();
        m_popupMenu.add(MenItem7);
        m_popupMenu.add(MenItem8);
        return m_popupMenu;

	}

	public expend getSelectedExpend(){
		int i=j1.getSelectedRow();
		return exm.cs.get(i);
	}
	public income getSelectedIncome(){
		int i=j2.getSelectedRow();
		return inm.cs.get(i);
	}
	public expendTableModel getExpendTableModel(){
		
		return this.exm;
		
	}
	public incomeTableModel getIncomeTableModel(){
		return this.inm;
		
	}
	
	public static void main(String args[]){
		new showPanel(DetailsPanel.instance);
	}
	
	
	@Override

	public void updateData(){		
		exm.cs=recordService.instance.exs;
		inm.cs=recordService.instance.ins;
	    j1.updateUI();
	    j2.updateUI();
	    GUIUtil.makeFace(j1);
	    GUIUtil.makeFace(j2);
	    j1.setShowGrid(false);
	    j2.setShowGrid(false);

	}
	public void updateData(int i){
		switch(i){
		
		case 0: rd.listExSeven();
		        rd.listInSeven();
		        this.updateData();
		        break;
		case 1: rd.listExThirty();
		        rd.listInThirty();
		        this.updateData();
		        break;
		case 2: rd.listExNinety();
		        rd.listInNinety();
		        this.updateData();
		        break;
		case 3: rd.listEx();
		        rd.listIn();
		        this.updateData();
		        break;	
		
		}
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		ButtonDialogListener listener=new ButtonDialogListener();
		TableChangeListener tl=new TableChangeListener();
		wb.addActionListener(listener);
		ButtonDialogListenerOrder fg=new ButtonDialogListenerOrder();
		wa.addActionListener(fg);
		wc.addActionListener(tl);
		wd.addActionListener(tl);
		
		TableOptionListener tol1=new TableOptionListener(j1,pop1);
		TableOptionListener tol2=new TableOptionListener(j2,pop2);
		j1.addMouseListener(tol1);
		j2.addMouseListener(tol2);
		
		PopMenuListener1 p1=new PopMenuListener1();
		PopMenuListener2 p2=new PopMenuListener2();
		MenItem1.addActionListener(p1);
		MenItem2.addActionListener(p1);
		MenItem3.addActionListener(p2);
		MenItem4.addActionListener(p2);
		PopMenuListener5 p3=new PopMenuListener5();
		MenItem5.addActionListener(p3);
		MenItem6.addActionListener(p3);
		MenItem7.addActionListener(p3);
		MenItem8.addActionListener(p3);
		SearchListener p4=new SearchListener();
		search.addKeyListener(p4);
		
	}
	

}
