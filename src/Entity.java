abstract public class Entity
{
    private String name;
    private String description;
    private int id;
    public boolean isService;
    public String getEntityInfo()
    {
        return "Name is: " + this.name + " Description is: " + this.description + " Id is: " + id;
    }
    abstract String getDetails();
    public String to_string()
    {
        return "The Info Of the Entity: " + this.getEntityInfo() + "The Details of the Material/Service: " + this.getDetails();
    }

    public boolean isService()
    {
        return isService;
    }

    public void setIsService(boolean x)
    {
        isService = x;
    }
    public int getID()
    {
        return id;
    }
    public void setID(int ID)
    {
        id = ID;
    }
    public void setName(String name1)
    {
        name = name1;
    }
    public String getName()
    {
        return name;
    }
    public double getLevel1()
    {
        return 0;
    }
    public double getLevel2()
    {
        return 0;
    }
    public double getLevel3()
    {
        return 0;
    }
}
