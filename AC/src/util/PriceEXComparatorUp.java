package util;

import java.util.Comparator;

import entity.expend;

public class PriceEXComparatorUp implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		expend e1=(expend) o1;
		expend e2=(expend) o2;
		
		return new Float(e1.spend).compareTo ( new Float(e2.spend)); 
	}

}
