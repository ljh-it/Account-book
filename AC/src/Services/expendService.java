package Services;

import java.util.List;

import DAO.expendDAO;
import entity.expend;
import gui.page.DetailPage;
import util.DateUtil;

public class expendService {
    public DetailPage getSpendPage() {
        expendDAO edao = new expendDAO();
        // 本月数据
        
        List<expend> thisMonthRecords = edao.listThisMonth();
        // 今日数据
        List<expend> toDayRecords = edao.listToday();
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
 
        // 统计本月消费
        for (expend ex : thisMonthRecords) {
            monthSpend += ex.getMoney();
        }
 
        // 统计今日消费
        for (expend ex : toDayRecords) {
            todaySpend += ex.getMoney();
        }
        // 计算日均消费
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
