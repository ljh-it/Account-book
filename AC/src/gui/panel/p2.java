package gui.panel;


import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.alee.extended.date.WebCalendar;
import com.alee.extended.date.WebDateField;
import com.alee.extended.panel.GroupPanel;
import com.alee.extended.panel.GroupingType;
import com.alee.extended.window.TestFrame;
import com.alee.laf.toolbar.WhiteSpace;
import com.alee.*;
public class p2 extends JPanel{
	//public static p2 instance = new p2();
	
	public p2(){
		this.setLayout(new BorderLayout());
	    long times = 1412654676572L;
	    Date date = new Date(times);
	    
	    WebCalendar w=new WebCalendar ();
	    
	    
		//this.add(w,BorderLayout.NORTH);
	}
	public static void main(String args[]){
		//new showPanel(p2.instance);
//		p2 n=new p2();
//		
//		
//		
//		new showPanel(n);
		
		
		SwingUtilities.invokeLater ( new Runnable ()
        {
            public void run ()
            {
                // Initialize L&F here, before creating any UI
            	try {
					UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                final JTextArea textArea = new JTextArea ( "Simple text area" );
                final JScrollPane scrollPane = new JScrollPane ( textArea );
                scrollPane.setPreferredSize ( new Dimension ( 300, 150 ) );
                scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
                scrollPane.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );

                final JProgressBar progressBar = new JProgressBar ();
                progressBar.setIndeterminate ( true );

                final JButton ok = new JButton ( "Ok" );
                final JButton cancel = new JButton ( "Cancel" );

                TestFrame.show ( new GroupPanel ( GroupingType.fillFirst, 5, false, scrollPane, progressBar,
                        new GroupPanel ( GroupingType.fillFirst, 5, new WhiteSpace (), ok, cancel ) ), 5 );
            }
        } );
	}

}
