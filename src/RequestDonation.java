public class RequestDonation
{
    private Entity entity;
    private double quantity;
    private int id;

    public RequestDonation (Entity e, double q){
        entity = e;
        quantity = q;
    }

    public void setQuantity(double q){
        quantity = q;
    }

    public void removeQuantity(double q){
        quantity -= q;
    }

    public double getQuantity(){
        return quantity;
    }

    public String getName(){
        return entity.getName();
    }

    public int getEntityID(){
        return entity.getID();
    }

    public Entity getEntity(){
        return entity;
    }

    public int getID(){
        return id;
    }

    public void setID(int i){
        id = i;
    }

    public boolean isValid(Beneficiary b, double q){
        if(entity.isService()){
            return true;
        }else {
            if(b.getnoPersons() == 1){
                return (b.getReceivedList().getTotalQuantity(entity.getName(), b, q) <= entity.getLevel1());
            }
            else if(b.getnoPersons() <=4){
                return (b.getReceivedList().getTotalQuantity(entity.getName(), b, q) <= entity.getLevel2());
            }
            else if(b.getnoPersons() >= 5){
                return (b.getReceivedList().getTotalQuantity(entity.getName(), b, q) <= entity.getLevel3());
            }
            return false;
        }
    }

}