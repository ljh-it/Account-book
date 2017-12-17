package entity;

public class Category {
    public int C_id;
    public String type;
     
    public int recordNumber;
     
//    public int getRecordNumber() {
//        return recordNumber;
//    }
//    public void setRecordNumber(int recordNumber) {
//        this.recordNumber = recordNumber;
//    }
    public int getId() {
        return C_id;
    }
    public void setId(int id) {
        this.C_id = id;
    }
    public String getName() {
        return type;
    }
    public void setName(String name) {
        this.type = name;
    }
     
    public String toString(){
        return type;
    }

}
