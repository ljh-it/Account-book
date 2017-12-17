package util;
 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class DateUtil {
    static long millisecondsOfOneDay = 1000*60*60*24;   
 
    public static java.sql.Date util2sql(java.util.Date d){
        return  new java.sql.Date(d.getTime());
    }
     
    /**
     * ��ȡ���죬���Ұ�ʱ���֣���ͺ��붼��0. ��Ϊͨ�����ڿؼ���ȡ�������ڣ�����û��ʱ����ͺ���ġ�
     * @return
     */
    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
         
    }
    
    public static Date lastSevenDay(){
    	  Calendar c = Calendar.getInstance();
    	  //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    	  c.add(Calendar.DATE, -7);
    	 return c.getTime();
    }
    public static Date lastThirtyDay(){
     	  Calendar c = Calendar.getInstance();
    	  //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    	  c.add(Calendar.DATE, -30);
    	 return c.getTime();
    	
    }
    public static Date lastNinetyDay(){
    	  Calendar c = Calendar.getInstance();
    	  //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    	  c.add(Calendar.DATE, -90);
    	 return c.getTime();
    }
 
    /**
     * ��ȡ�³���ʹ��Calendar��ȡ���µ�һ�졣 ��ͳ������һ����Ϣ��ʱ�򣬲鿴���µ��������ݣ���ʵ���Ǵ����ݿ���ȥ�Ѵӱ��µ�һ�쵽���һ������ݲ�������ٽ��м�ͳ�ƣ�������Ҫһ����ȡ���µ�һ��ķ�����
     * @return
     */
 
    public static Date monthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
         
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
         
        return c.getTime();
    }
     
    /**
     * ��ȡ�³�
     * @return
     */
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
         
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONDAY, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }
 
    /**
     * ��ȡ����һ���ж�����
     * @return
     */
    public static int thisMonthTotalDay(){
         
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();
 
        return (int) ((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondsOfOneDay) +1;
    }
     
    /**
     *��ȡ���»�ʣ������ 
     * @return
     */
     
    public static int thisMonthLeftDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        return (int) ((lastDayMilliSeconds-toDayMilliSeconds)/millisecondsOfOneDay) +1;
    }   
     
    public static void main(String[] args) {
        System.out.println(DateUtil.today());
        System.out.println(DateUtil.monthBegin());
        System.out.println(DateUtil.monthEnd());
        System.out.println(thisMonthLeftDay());
        System.out.println(thisMonthTotalDay());
        System.out.println(lastSevenDay());
        System.out.println(lastThirtyDay());
        System.out.println(lastNinetyDay());
    }
}