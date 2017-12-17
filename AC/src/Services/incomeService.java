package Services;

import java.util.List;

import DAO.expendDAO;
import DAO.incomeDAO;
import entity.expend;
import entity.income;
import gui.page.DetailPage;
import util.DateUtil;

public class incomeService {
	 public DetailPage getSpendPage() {
	        incomeDAO idao = new incomeDAO();
	        // 本月数据
	        
	        List<income> thisMonthRecords = idao.listThisMonth();
	        // 今日数据
	        List<income> toDayRecords = idao.listToday();
	        // 本月总天数
	        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();
	 
	        int monthSpend = 0;
	        int todaySpend = 0;
	        int avgSpendPerDay = 0;
	        int monthAvailable = 0;
	        int dayAvgAvailable = 0;
	        int monthLeftDay = 0;
	        int usagePercentage = 0;
	 
	        // 预算
	        int monthBudget =new ConfigService().getIntBudget();
	 
	        // 统计本月收入
	        for (income in : thisMonthRecords) {
	            monthSpend += in.getMoney();
	        }
	 
	        // 统计今日收入
	        for (income in : toDayRecords) {
	            todaySpend += in.getMoney();
	        }
	        // 计算日均收入
	        avgSpendPerDay = monthSpend / thisMonthTotalDay;
	        // 计算本月剩余
	        monthAvailable = monthBudget - monthSpend;
	 
	        // 距离月末
	        monthLeftDay = DateUtil.thisMonthLeftDay();
	 
	        // 计算日均可用
	        dayAvgAvailable = monthAvailable / monthLeftDay;
	 
	        // 计算使用比例
	        usagePercentage = monthSpend * 100 / monthBudget;
	 
	        // 根据这些信息，生成SpendPage对象
	 
	        return new DetailPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
	                usagePercentage);
	    }
		

}
