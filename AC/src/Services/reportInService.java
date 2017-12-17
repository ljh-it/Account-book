package Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import DAO.expendDAO;
import entity.expend;
import util.DateUtil;

public class reportInService {
	
	
	  public int getDaySpend(Date d,List<expend> monthRawData){
	        int daySpend = 0;
	        for (expend ex : monthRawData) {
	            if(ex.date.equals(d))
	                daySpend+=ex.spend;
	        }
	        return daySpend;
	    }
	         
	
	    public List<expend> listThisMonthRecords() {
	        expendDAO dao= new expendDAO();
	        List<expend> monthRawData= dao.listThisMonth();
	        List<expend> result= new ArrayList<>();
	        Date monthBegin = DateUtil.monthBegin();
	        int monthTotalDay = DateUtil.thisMonthTotalDay();
	        Calendar c = Calendar.getInstance();
	        for (int i = 0; i < monthTotalDay; i++) {
	            expend r = new expend();
	            c.setTime(monthBegin);
	            c.add(Calendar.DATE, i);
	            Date eachDayOfThisMonth=c.getTime() ;
	            int daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
	            r.spend=daySpend;
	            result.add(r);
	        }
	        return result;
	 
	    }
	

}
