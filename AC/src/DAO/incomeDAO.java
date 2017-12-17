package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import entity.expend;
import entity.income;
import util.DBUtil;
import util.DateUtil;

public class incomeDAO {
	 public int getTotal() {
	       int total = 0;
	       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

	           String sql = "select count(*) from income";

	           ResultSet rs = s.executeQuery(sql);
	           while (rs.next()) {
	               total = rs.getInt(1);
	           }

	           System.out.println("total:" + total);

	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	       return total;
	   }

	   public void add(income in) {

	       String sql = "insert into income values(null,?,?,?,?)";
	       try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
               
	    	   ps.setFloat(1, in.earn);
	           ps.setInt(2, in.C_id);	           
	           ps.setString(3, in.comment);
	           ps.setDate(4, DateUtil.util2sql(in.date));

	           ps.execute();

	           ResultSet rs = ps.getGeneratedKeys();
	           if (rs.next()) {
	               int id = rs.getInt(1);
	               in.i_id = id;
	           }
	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	   }

	   public void update(income in) {

	       String sql = "update income set earn= ? ,C_id= ? ,comment= ? ,date = ? where i_id = ?";  //
	       try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

	    	   ps.setFloat(1, in.earn);
	           ps.setInt(2, in.C_id);
	           ps.setString(3, in.comment);
	           ps.setDate(4, DateUtil.util2sql(in.date));
	           ps.setInt(5, in.i_id);
	           ps.execute();

	       } catch (SQLException e) {

	           e.printStackTrace();
	       }

	   }

	   public void delete(int id) {

	       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

	           String sql = "delete from income where i_id = " + id;//

	           s.execute(sql);

	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	   }

	   public income get(int id) {
	       income in = null;

	       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

	           String sql = "select * from income where i_id = " + id;//

	           ResultSet rs = s.executeQuery(sql);

	           if (rs.next()) {
	               in = new income();
	               float earn=rs.getFloat("earn");
	               int C_id=rs.getInt("C_id");
	               String comment=rs.getString("comment");
	               Date date=rs.getDate("date");
	               in.earn=earn;
	               in.C_id=C_id;
	               in.comment=comment;
	               in.date=date;

	           }

	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	       return in;
	   }

	   public List<income> list() {
	       return list(0, Short.MAX_VALUE);
	   }

	   public List<income> list(int start, int count) {
	       List<income> ins = new ArrayList<income>();

	       String sql = "select * from income order by i_id desc limit ?,? ";//

	       try (Connection c = DBUtil.getConnection(); 
	    		   PreparedStatement ps = c.prepareStatement(sql);) {

	           ps.setInt(1, start);
	           ps.setInt(2, count);

	           ResultSet rs = ps.executeQuery();

	           while (rs.next()) {
	               income in = new income();
	               int i_id=rs.getInt("i_id");
	               float earn=rs.getFloat("earn");
	               int C_id=rs.getInt("C_id");
	               String comment=rs.getString("comment");
	               Date date=rs.getDate("date");
	               in.i_id=i_id;
	               in.earn=earn;
	               in.C_id=C_id;
	               in.comment=comment;
	               in.date=date;	               
	               ins.add(in);
	           }
	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	       return ins;
	   }
	   public List<income> list(int C_id){
		   
		   
		   List<income> ins = new ArrayList<income>();
		   
	        String sql = "select * from income where C_id = ?";
	  
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setInt(1, C_id);
	  
	            ResultSet rs = ps.executeQuery();
	  
	            while (rs.next()) {
	                income in = new income();
	                int i_id = rs.getInt("i_id");
	                float earn = rs.getFloat("earn");
	                 
	                String comment = rs.getString("comment");
	                Date date = rs.getDate("date");
	                
	                in.i_id = i_id;
	                in.earn=earn;
	                in.C_id=C_id;
	                in.comment=comment;
	                in.date=date;
	               
	                ins.add(in);
	            }
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return ins;
		   
	   }
	   
	   
	    public List<income> listToday(){
	        return list(DateUtil.today());
	    }
	    public List<income> listLastSevenday(){
	    	return list(DateUtil.lastSevenDay(),DateUtil.today());
	    }
	    public List<income> listLastThirtyday(){
	    	return list(DateUtil.lastThirtyDay(),DateUtil.today());
	    }
	    public List<income> listLastNinetyday(){
	    	return list(DateUtil.lastNinetyDay(),DateUtil.today());
	    }
	    public List<income> list(Date day) {
	        List<income> ins = new ArrayList<income>();
	        String sql = "select * from income where date =?";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	            ps.setDate(1, DateUtil.util2sql(day));
	 
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                income in = new income();
	                int i_id = rs.getInt("i_id");
	                int C_id = rs.getInt("C_id");
	                float earn = rs.getFloat("earn");
	                 
	                String comment = rs.getString("comment");
	                Date date = rs.getDate("date");
	                
	                in.i_id = i_id; 
	                in.earn=earn;
	                in.C_id=C_id;
	                in.comment=comment;
	                in.date=date;
	                
	                ins.add(in);
	            }
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return ins;
	    }            
	    public List<income> listThisMonth(){
	        return list(DateUtil.monthBegin(),DateUtil.monthEnd());
	    }
	   
	    public List<income> list(Date start, Date end) {
	        List<income> ins = new ArrayList<income>();
	        String sql = "select * from income where date >=? and date <= ?";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	            ps.setDate(1, DateUtil.util2sql(start));
	            ps.setDate(2, DateUtil.util2sql(end));
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                 income in = new income();
	                 int i_id = rs.getInt("i_id");
	                 float earn = rs.getFloat("earn");
	                 int C_id = rs.getInt("C_id");
	                 String comment = rs.getString("comment");
	                 Date date = rs.getDate("date");
	                 in.i_id = i_id;
	                 in.earn=earn;
	                 in.C_id=C_id;
	                 in.comment=comment;
	                 in.date=date;
	                 
	                 ins.add(in);
	            }
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return ins;
	    }        
	   


}
