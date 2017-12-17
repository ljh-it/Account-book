package entity;

public class Budge {
	public int b_id;
	public int C_id;
	public float spend;
	public String comment;
	public int getId() {
	        return b_id;
	    }
	public void setId(int id) {
	        this.b_id = id;
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
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

}
