package gui.panel;

import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import gui.model.CategoryTableModel;

public class p1 {
	
   
	
public static void main(String args[]){
	
	JFrame j=new JFrame();
	j.setSize(500, 500);
	CategoryTableModel ctm = new CategoryTableModel();
	JTable t =new JTable(ctm);
    JScrollPane sp =new JScrollPane(t);
    JPanel pSubmit = new JPanel();
	j.setContentPane(sp);
	j.setVisible(true);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	     System.out.println("Success loading Mysql Driver!");
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = (Connection) DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/Bill","root","735139542");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

	      System.out.println("Success connect Mysql server!");
	      Statement stmt = (Statement) connect.createStatement();
	      ResultSet rs = (ResultSet) stmt.executeQuery("select * from test");
	                                                              //user 为你表的名称
	while (rs.next()) {
	        System.out.println(rs.getString("password"));
	      }
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
	  }
	
}


