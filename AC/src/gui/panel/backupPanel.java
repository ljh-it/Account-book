package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Services.ConfigService;
import listener.BackupListener;
import listener.ConfigListener;
import listener.RecoverListener;

public class backupPanel extends WorkingPanel{
	public static backupPanel instance =new backupPanel();
	
	
	
	public JLabel mysql=new JLabel("Mysql安装目录：");
	
	public String path=new ConfigService().getmysqlPath();
	public JTextField jt=new JTextField(path,19);
	
	public JButton sets=new JButton("设置");
	public JButton backup=new JButton("备份");
    public JButton recover=new JButton("还原");
	public backupPanel(){
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.add(back(),BorderLayout.NORTH);
		this.add(center(),BorderLayout.CENTER);
		addListener();
		
	}
	public Component back(){
		JPanel p=new JPanel();
		p.setBackground(Color.white);
		p.add(mysql);
		
		p.add(jt);
		p.add(sets);
		return p;
	}
	
	public Component center(){
		JPanel p=new JPanel();
		p.setBackground(Color.white);
		p.add(backup);
		p.add(recover);
		
		return p;
	}
	
	public static void main(String args[]){
		new showPanel(new backupPanel());
		
	}
	
	

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		BackupListener bk=new BackupListener();
		RecoverListener rc=new RecoverListener();
		ConfigListener cf=new ConfigListener();
		backup.addActionListener(bk);
		recover.addActionListener(rc);
		sets.addActionListener(cf);
	}

}
