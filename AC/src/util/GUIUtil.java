package util;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

import com.alee.laf.WebLookAndFeel;
 
public class GUIUtil {
    private static String imageFolder = "/Users/lujuhong/Documents/workspace/AC/img";
 
    public static void setImageIcon(JButton b, String fileName) {
        Icon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        //b.setPreferredSize(new Dimension(61, 81));
          b.setHorizontalAlignment(JButton.LEFT);

    }
    public static void loadIcon(String fileName){
    	Icon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
    	
    }
 
    public static void setColor(Color color, JComponent... cs) {
        for (JComponent c : cs) {
            c.setForeground(color);
        }
    }
 
 
    public static void showPanel(JPanel p,double strechRate) {
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strechRate);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }
     
    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }   
 
    public static boolean checkNumber(JTextField tf, String input) {
        if (!checkEmpty(tf, input))
            return false;
        String text = tf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e1) {
        	JOptionPane.showMessageDialog(null, input + " 需要是整数");
            tf.grabFocus();
            return false;
        }
    }
 
    public static boolean checkZero(JTextField tf, String input) {
        if (!checkNumber(tf, input))
            return false;
        String text = tf.getText().trim();
 
        if (0 == Integer.parseInt(text)) {
        	JOptionPane.showMessageDialog(null, input + " 不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }
 
    public static boolean checkEmpty(JTextField tf, String input) {
        String text = tf.getText().trim();
        if (0 == text.length()) {
        	JOptionPane.showMessageDialog(null, input + " 不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
 
    }
 
    public static int getInt(JTextField tf) {
        return Integer.parseInt(tf.getText());
    }
 
    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    }
    public static void makeFace(JTable table) {
        try
        {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer()
            {
              public Component getTableCellRendererComponent(JTable table,
                  Object value, boolean isSelected, boolean hasFocus,
                  int row, int column)
              {
                if(row%2 == 0)
                  setBackground(Color.white); //设置奇数行底色
                else if(row%2 == 1)
                  setBackground(new Color(236,245,254));  //设置偶数行底色
                return super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column); }
            };
                for(int i = 0; i < table.getColumnCount(); i++) {
                  table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
          }
                table.setShowHorizontalLines(false);
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
}
}