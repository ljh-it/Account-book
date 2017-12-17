package entity;

public class User {
	public String u_id;
	public String password;
	public Category uc;
	public expend ue;
	public income ui;
	
	public String getId(){
		return this.u_id;

	}
	public void setId(String u_id){
		this.u_id=u_id;
			
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public Category getCategory(){
		return this.uc;
	}
	public void setCategory(Category uc){
		this.uc=uc;
	}
	public expend getExpend(){
		return this.ue;
		
	}
	public void setExpend(expend ue){
		this.ue=ue;
	}
	public income getIncome(){
		return this.ui;
	}
	public void setIncome(income ui){
		this.ui=ui;
	}

}
