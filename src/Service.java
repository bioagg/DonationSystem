public class Service extends Entity
{
    public Service (int id, String name){
        setName(name);
        setID(id);
        setIsService(true);
    }

    public String getDetails(){
        return "This is a Service";
    }
}