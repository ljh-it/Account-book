package util;

import java.util.Comparator;

import entity.expend;

public class DateExComparatorDown implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		expend e1=(expend) o2;
		expend e2=(expend) o1;
		return e1.date.compareTo(e2.date);
	}

}
