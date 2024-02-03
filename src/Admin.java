public class Admin extends User
{
    private boolean isAdmin = true;

    public Admin(int id, String name, String phone){
        setName(name);
        setPhone(phone);
        setID(id);
    }

    public boolean getIsAdmin(){
        return isAdmin;
    }

    public String getphone(){
        return getPhone();
    }
}