package entity;

public class currency {
	public int Cy_id;	
	public String Cy_name;
	public float rate;
	
	
    public int getId() {
        return Cy_id;
    }
    public void setId(int id) {
        this.Cy_id = id;
    }
    public String getName() {
        return Cy_name;
    }
    public void setName(String name) {
        this.Cy_name = name;
    }
	

}
