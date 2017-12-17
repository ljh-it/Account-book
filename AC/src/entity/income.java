package entity;

import java.util.Date;

public class income {
	public int i_id;
	public int C_id;
	public float earn;
	public String comment;
	public Date date;
	
    public int getId() {
        return i_id;
    }
    public void setId(int id) {
        this.i_id = id;
    }
    public float getMoney(){
    	return this.earn;
    }
    public void setMoney(float earn){
        this.earn=earn;
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
