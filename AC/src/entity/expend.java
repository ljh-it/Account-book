package entity;

import java.util.Date;

public class expend {
	public int e_id;
	public int C_id;
	public float spend;
	public String comment;
	public Date date;
	
    public int getId() {
        return e_id;
    }
    public void setId(int id) {
        this.e_id = id;
    }
    public float getMoney(){
    	return this.spend;
    }
    public void setMoney(float spend){
        this.spend=spend;
    }
    public int getType(){
    	return this.C_id;
    }
    public void setType(int C_id){
    	this.C_id=C_id;
    }
    public Date getDate(){
    	return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
		

}
