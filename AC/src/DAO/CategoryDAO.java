package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import util.DBUtil;

public class CategoryDAO {

   public int getTotal() {
       int total = 0;
       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

           String sql = "select count(*) from category";

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

   public void add(Category category) {

       String sql = "insert into category values(null,?)";
       try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

           ps.setString(1, category.type);

           ps.execute();

           ResultSet rs = ps.getGeneratedKeys();
           if (rs.next()) {
               int id = rs.getInt(1);
               category.C_id = id;
           }
       } catch (SQLException e) {

           e.printStackTrace();
       }
   }

   public void update(Category category) {

       String sql = "update category set type= ? where C_id = ?";  //
       try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

           ps.setString(1, category.type);
           ps.setInt(2, category.C_id);

           ps.execute();

       } catch (SQLException e) {

           e.printStackTrace();
       }

   }

   public void delete(int id) {

       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

           String sql = "delete from category where C_id = " + id;//

           s.execute(sql);

       } catch (SQLException e) {

           e.printStackTrace();
       }
   }

   public Category get(int id) {
       Category category = null;

       try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

           String sql = "select * from category where C_id = " + id;//

           ResultSet rs = s.executeQuery(sql);

           if (rs.next()) {
               category = new Category();
               String name = rs.getString(2);
               category.type = name;
               category.C_id = id;
           }

       } catch (SQLException e) {

           e.printStackTrace();
       }
       return category;
   }

   public List<Category> list() {
       return list(0, Short.MAX_VALUE);
   }

   public List<Category> list(int start, int count) {
       List<Category> categorys = new ArrayList<Category>();

       String sql = "select * from category order by C_id desc limit ?,? ";//

       try (Connection c = DBUtil.getConnection(); 
    		   PreparedStatement ps = c.prepareStatement(sql);) {

           ps.setInt(1, start);
           ps.setInt(2, count);

           ResultSet rs = ps.executeQuery();

           while (rs.next()) {
               Category category = new Category();
               int id = rs.getInt(1);
               String name = rs.getString(2);
               category.C_id = id;
               category.type = name;
               categorys.add(category);
           }
       } catch (SQLException e) {

           e.printStackTrace();
       }
       return categorys;
   }

}