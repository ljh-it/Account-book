package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;

public class MyButton extends JButton implements MouseListener {
	 private Shape shape = null;
	// private Color click = new Color(0, 0, 113);// 按下时的颜色
	 //private Color quit = new Color(232, 231, 244);// 离开时颜色
	 public MyButton(String s) {
	  super(s);
	  this.setBorderPainted(false);
	  addMouseListener(this);
	  //setContentAreaFilled(false);// 是否显示外围矩形区域 选否
	 }
	 public MyButton() {
	  super();
	  this.setBorderPainted(false);
	  addMouseListener(this);
	 }
	 public MyButton(String text, Icon icon) {
	  super(text, icon);
	  addMouseListener(this);
	 }
	 public MyButton(Icon icon) {
	  super(icon);
	  addMouseListener(this);
	 }
//	 public void setColor(Color c, Color q) {
//	  click = c;
//	  quit = q;
//	 }
	 public void mouseClicked(MouseEvent e) {
	 // System.out.println("mouseClicked");
	  
	 }
	 public void mousePressed(MouseEvent e) {
	 // System.out.println("mousePressed");
	  
	 }
	 public void mouseReleased(MouseEvent e) {
	  //System.out.println("mouseReleased");
	  this.setBorderPainted(false);
	 }
	 public void mouseExited(MouseEvent e) {
	 // System.out.println("mouseExited");
	  this.setBorderPainted(false);
	  
	  
	 }
	 public void mouseEntered(MouseEvent e) {
	  //System.out.println("mouseEntered");
	  this.setBorderPainted(true);
	 }
//	 public void paintComponent(Graphics g) {
//	  //如果按下则为ＣＬＩＣＫ色 否则为 ＱＵＩＴ色
//	  if (getModel().isArmed()) {
//	   g.setColor(click);
//	  } else {
//	   g.setColor(quit);
//	  }
//	  //填充圆角矩形区域 也可以为其它的图形
////	  g
////	    .fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
////	      20, 20);
////	  //必须放在最后 否则画不出来
//	  super.paintComponent(g);
//	 }
//	 public void paintBorder(Graphics g) {
//	  //画边界区域
//	  g.setColor(click);
//	  g
//	    .drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
//	      20, 20);
//	 }
	 public boolean contains(int x, int y) {
	  //判断点（x,y）是否在按钮内
	  if (shape == null || !(shape.getBounds().equals(getBounds()))) {
	   shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(),
	     20, 20);
	  }
	  return shape.contains(x, y);
	 }
	 

	 public static void main(String[] argv) {
	  JFrame f = new JFrame();
	  f.setSize(400, 300);
	  MyButton btn = new MyButton("button");
	 // WebButton s=new WebButton("wfew");
	//  s.setBorderPainted(false);
	  Icon login= new ImageIcon("/Users/lujuhong/Documents/workspace/hutubill/img/icons8-brief.png");
	   Icon exit = new ImageIcon("Exit.png");
	   btn.setIcon(login);
	  f.getContentPane().add(btn, BorderLayout.NORTH);
	 // f.getContentPane().add(s, BorderLayout.CENTER);
	  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  f.setVisible(true);
	 }
	}