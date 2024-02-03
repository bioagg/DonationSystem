abstract public class User
{
    private String name;
    private String phone;
    private int id;

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setID(int ID){
        id = ID;
    }

    public int getID(){
        return id;
    }
}