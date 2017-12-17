package Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import DAO.incomeDAO;
import entity.income;
import util.DateUtil;

public class reportOutService {
	
	  public int getDayEarn(Date d,List<income> monthRawData){
	        int dayEarn = 0;
	        for (income in : monthRawData) {
	            if(in.date.equals(d))
	                dayEarn+=in.earn;
	        }
	        return dayEarn;
	    }
	         
	
	    public List<income> listThisMonthRecords() {
	        incomeDAO dao= new incomeDAO();
	        List<income> monthRawData= dao.listThisMonth();
	        List<income> result= new ArrayList<>();
	        Date monthBegin = DateUtil.monthBegin();
	        int monthTotalDay = DateUtil.thisMonthTotalDay();
	        Calendar c = Calendar.getInstance();
	        for (int i = 0; i < monthTotalDay; i++) {
	            income r = new income();
	            c.setTime(monthBegin);
	            c.add(Calendar.DATE, i);
	            Date eachDayOfThisMonth=c.getTime() ;
	            int dayEarn = getDayEarn(eachDayOfThisMonth,monthRawData);
	            r.earn=dayEarn;
	            result.add(r);
	        }
	        return result;
	 
	    }
	

}
