package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Budge;
import entity.expend;
import util.DBUtil;
import util.DateUtil;

public class BudgeDAO {
	 public int getTotal() {
	       int total = 0;
	       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

	           String sql = "select count(*) from Budge";

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

	   public void add(Budge bu) {

	       String sql = "insert into Budge values(null,?,?,?)";
	       try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
             
	    	   ps.setFloat(1, bu.spend);
	           ps.setInt(2, bu.C_id);	           
	           ps.setString(3, bu.comment);
	           //ps.setDate(4, DateUtil.util2sql(ex.date));

	           ps.execute();

	           ResultSet rs = ps.getGeneratedKeys();
	           if (rs.next()) {
	               int id = rs.getInt(1);
	               bu.b_id = id;
	           }
	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	   }

	   public void update(Budge bu) {

	       String sql = "update Budge set spend= ? ,C_id= ? ,comment= ? where b_id = ?";  //
	       try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

	    	   ps.setFloat(1, bu.spend);
	           ps.setInt(2, bu.C_id);
	           ps.setString(3, bu.comment);
	           //ps.setDate(4, DateUtil.util2sql(ex.date));
	           ps.setInt(4, bu.b_id);
	           ps.execute();

	       } catch (SQLException e) {

	           e.printStackTrace();
	       }

	   }

	   public void delete(int id) {

	       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

	           String sql = "delete from Budge where b_id = " + id;//

	           s.execute(sql);

	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	   }

	   public Budge get(int id) {
	       Budge bu = null;

	       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

	           String sql = "select * from Budge where b_id = " + id;//

	           ResultSet rs = s.executeQuery(sql);

	           if (rs.next()) {
	               bu = new Budge();
	               float spend=rs.getFloat("spend");
	               int C_id=rs.getInt("C_id");
	               String comment=rs.getString("comment");
	               //Date date=rs.getDate("date");
	               bu.spend=spend;
	               bu.C_id=C_id;
	               bu.comment=comment;
	              // ex.date=date;

	           }

	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	       return bu;
	   }

	   public List<Budge> list() {
	       return list(0, Short.MAX_VALUE);
	   }
	   
	

	   public List<Budge> list(int start, int count) {
	       List<Budge> bus = new ArrayList<Budge>();

	       String sql = "select * from Budge order by b_id desc limit ?,? ";//

	       try (Connection c = DBUtil.getConnection(); 
	    		   PreparedStatement ps = c.prepareStatement(sql);) {

	           ps.setInt(1, start);
	           ps.setInt(2, count);

	           ResultSet rs = ps.executeQuery();

	           while (rs.next()) {
	               Budge bu = new Budge();
	               int b_id=rs.getInt("b_id");
	               float spend=rs.getFloat("spend");
	               int C_id=rs.getInt("C_id");
	               String comment=rs.getString("comment");
	              
	               bu.b_id=b_id;
	               bu.spend=spend;
	               bu.C_id=C_id;
	               bu.comment=comment;
	              	               
	               bus.add(bu);
	           }
	       } catch (SQLException e) {

	           e.printStackTrace();
	       }
	       return bus;
	   }
	   public List<Budge> list(int C_id){
		   
		   
		   List<Budge> bus = new ArrayList<Budge>();
		   
	        String sql = "select * from Budge where C_id = ?";
	  
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setInt(1, C_id);
	  
	            ResultSet rs = ps.executeQuery();
	  
	            while (rs.next()) {
	                Budge bu = new Budge();
	                int b_id = rs.getInt("b_id");
	                float spend = rs.getFloat("spend");
	                 
	                 String comment = rs.getString("comment");
	                // Date date = rs.getDate("date");
	                  
	                 bu.spend=spend;
	                 bu.C_id=C_id;
	                 bu.comment=comment;
	                 //ex.date=date;
	                 bu.b_id = b_id;
	                 bus.add(bu);
	            }
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return bus;
		   
	   }
	   
	   
//	    public List<expend> listToday(){
//	        return list(DateUtil.today());
//	    }
//	    
//	    public List<Budge> list(Date day) {
//	        List<expend> exs = new ArrayList<expend>();
//	        String sql = "select * from expend where date =?";
//	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
//	            ps.setDate(1, DateUtil.util2sql(day));
//	 
//	            ResultSet rs = ps.executeQuery();
//	            while (rs.next()) {
//	                expend ex = new expend();
//	                int e_id = rs.getInt("e_id");
//	                int C_id = rs.getInt("C_id");
//	                float spend = rs.getFloat("spend");
//	                 
//	                String comment = rs.getString("comment");
//	                Date date = rs.getDate("date");
//	                
//	                ex.e_id = e_id; 
//	                ex.spend=spend;
//	                ex.C_id=C_id;
//	                ex.comment=comment;
//	                ex.date=date;
//	                
//	                exs.add(ex);
//	            }
//	        } catch (SQLException e) {
//	  
//	            e.printStackTrace();
//	        }
//	        return exs;
//	    }            
//	    public List<expend> listThisMonth(){
//	        return list(DateUtil.monthBegin(),DateUtil.monthEnd());
//	    }
//	    
//	    public List<expend> listLastSevenday(){
//	    	return list(DateUtil.lastSevenDay(),DateUtil.today());
//	    }
//	    public List<expend> listLastThirtyday(){
//	    	return list(DateUtil.lastThirtyDay(),DateUtil.today());
//	    }
//	    public List<expend> listLastNinetyday(){
//	    	return list(DateUtil.lastNinetyDay(),DateUtil.today());
//	    }
//	   
//	    public List<expend> list(Date start, Date end) {
//	        List<expend> exs = new ArrayList<expend>();
//	        String sql = "select * from expend where date >=? and date <= ?";
//	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
//	            ps.setDate(1, DateUtil.util2sql(start));
//	            ps.setDate(2, DateUtil.util2sql(end));
//	            ResultSet rs = ps.executeQuery();
//	            while (rs.next()) {
//	                 expend ex = new expend();
//	                 int e_id = rs.getInt("e_id");
//	                 float spend = rs.getFloat("spend");
//	                 int C_id = rs.getInt("C_id");
//	                 String comment = rs.getString("comment");
//	                 Date date = rs.getDate("date");
//	                 ex.e_id = e_id;
//	                 ex.spend=spend;
//	                 ex.C_id=C_id;
//	                 ex.comment=comment;
//	                 ex.date=date;
//	                 
//	                 exs.add(ex);
//	            }
//	        } catch (SQLException e) {
//	  
//	            e.printStackTrace();
//	        }
//	        return exs;
//	    }  

}
