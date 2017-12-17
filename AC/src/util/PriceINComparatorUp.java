package util;

import java.util.Comparator;

import entity.income;

public class PriceINComparatorUp implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		income i1=(income) o1;
		income i2=(income) o2;
		return new Float(i1.earn).compareTo(new Float(i2.earn));
	}

}
