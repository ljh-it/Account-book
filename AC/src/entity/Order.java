package entity;

public class Order {
	
	public boolean vertical;	
	public boolean type;
	public Order(){
		this.vertical=false;		
		this.type=false;
	}
	public void setVertical(boolean s){
		this.vertical=s;
	}
	public void setType(boolean s){
		this.type=s;
	}

}
