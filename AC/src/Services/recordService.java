package Services;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import DAO.BudgeDAO;
import DAO.expendDAO;
import DAO.incomeDAO;
import entity.Budge;
import entity.Category;
import entity.Order;
import entity.expend;
import entity.income;
import gui.panel.DetailsPanel;
import gui.panel.MainPanel1;
import util.DateExComparatorDown;
import util.DateExComparatorUp;
import util.DateInComparatorDown;
import util.DateInComparatorUp;
import util.PriceEXComparatorDown;
import util.PriceEXComparatorUp;
import util.PriceINComparatorDown;
import util.PriceINComparatorUp;

public class recordService {
	
	
	public static recordService instance=new recordService(); 
	public Order order=new Order();
	expendDAO exd=new expendDAO();
	incomeDAO ind=new incomeDAO();
	BudgeDAO bud=new BudgeDAO();
	public List<expend> exs;
	public List<income> ins;
	public List<Budge> bus;
	
	public recordService(){
		listEx();
		listIn();
		listBu();
	}
	public void listExCID(int C_id){
		List<expend> exs=exd.list(C_id);
		this.exs=exs;
		listExFormat();
	}
	public void listInCID(int C_id){
		List<income> ins=ind.list(C_id);
		this.ins=ins;
		listInFormat();
	}
	public void listEx(){
		List<expend> exs=exd.list();		
		this.exs=exs;
		listExFormat();		
	}
	public void listIn(){
		List<income> ins=ind.list();
		this.ins=ins;
		listInFormat();
		
	}
	public void listBu(){
		List<Budge> bus=bud.list();
		this.bus=bus;
		
	}
	public void listExSeven(){
		List<expend> exs=exd.listLastSevenday();		
		this.exs=exs;
		listExFormat();
	}
	

	public void listInSeven(){
		List<income> ins=ind.listLastSevenday();
		this.ins=ins;
		listInFormat();
	}
	
	public void listExThirty(){
		List<expend> exs=exd.listLastThirtyday();		
		this.exs=exs;
		listExFormat();
	}
	public void listInThirty(){
		List<income> ins=ind.listLastThirtyday();
		this.ins=ins;
		listInFormat();
	}
	public void listExNinety(){
		List<expend> exs=exd.listLastNinetyday();
		this.exs=exs;
		listExFormat();
	}
	public void listInNinety(){
		List<income> ins=ind.listLastNinetyday();
		this.ins=ins;
		listInFormat();
	}
	
	
	
	public void addEx(float spend,Category c,String comment,Date date){
		expend ex=new expend();
		ex.spend=spend;
		ex.C_id=c.C_id;
		ex.comment=comment;
		ex.date=date;
		
		exd.add(ex);
		
	}
	public void deleteEx(int id){
		exd.delete(id);
	}
	public void deleteIn(int id){
		ind.delete(id);
	}
	public void addIn(float earn,Category c,String comment,Date date){
		income in=new income();
		in.earn=earn;
		in.C_id=c.C_id;
		in.comment=comment;
		in.date=date;
		
		ind.add(in);
		
	}
	public void addSB(float spend,Category c,String comment){
		Budge b=new Budge();
		b.spend=spend;
		b.C_id=c.C_id;
		b.comment=comment;
		bud.add(b);
		
	}
	public void deleteSB(int id){
		bud.delete(id);
	}
	public void updateSB(float spend,Category c ,String comment,int b_id){
		Budge b=new Budge();
		b.b_id=b_id;
		b.spend=spend;
		b.C_id=c.C_id;
		b.comment=comment;
		bud.update(b);
	}
	
	public void updateEx(float spend,Category c,String comment,Date date,int e_id){
		expend eee=new expend();
		eee.e_id=e_id;
		eee.spend=spend;
		eee.C_id=c.C_id;
		eee.comment=comment;
		eee.date=date;
		exd.update(eee);
	}
	public void updateIn(float earn,Category c,String comment,Date date,int i_id){
		income eee=new income();
		eee.i_id=i_id;
		eee.earn=earn;
		eee.C_id=c.C_id;
		eee.comment=comment;
		eee.date=date;
		ind.update(eee);
	}

	
	public void listExFormat(){
		if(order.vertical) {
			if(order.type){
				Collections.sort(this.exs,new DateExComparatorUp());
			}
			else{
				Collections.sort(this.exs,new PriceEXComparatorUp());
			}
		}
		
		else {
			if(order.type){
				Collections.sort(this.exs,new DateExComparatorDown());
			}
			else{
				Collections.sort(this.exs,new PriceEXComparatorDown());
			}
			
		}
		
	}
	
	public void listInFormat(){
		if(order.vertical) {
			if(order.type){
				Collections.sort(this.ins,new DateInComparatorUp());
			}
			else{
				Collections.sort(this.ins,new PriceINComparatorUp());
			}
		}
		
		else {
			if(order.type){
				Collections.sort(this.ins,new DateInComparatorDown());
			}
			else{
				Collections.sort(this.ins,new PriceINComparatorDown());
			}
			
		}
	}


}
