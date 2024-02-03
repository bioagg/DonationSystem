import java.util.ArrayList;
public class Organization{
    private String name;
    private Admin admin;
    private int id;

    public ArrayList <Entity> entityList = new ArrayList <> ();
    public ArrayList <Donator> donatorList = new ArrayList <> ();
    public ArrayList <Beneficiary> beneficiaryList = new ArrayList <> ();
    public RequestDonationList currentDonations = new RequestDonationList();

    public Organization(String org){
        name = org;
    }

    public void setAdmin(Admin a1){
        admin = a1;
    }

    public Admin getAdmin(){
        return admin;
    }

    public void addEntity(Entity entity){
        try{
            for (Entity en : entityList){
                if (en.getID() == entity.getID()){
                    throw new OverQuantity("This Entity Already Exists.");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        entityList.add(entity);
    }

    public void removeEntity(Entity entity){
        if (admin.getIsAdmin()) entityList.remove(entity);
    }

    public void insertDonator(Donator d){
        try{
            for (Donator don : donatorList){
                if (don.getID() == d.getID()){
                    throw new SimilarityException("This Donator Already Exists.");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        donatorList.add(d);
    }

    public void removeDonator(Donator d){
        donatorList.remove(d);
    }

    public void insertBeneficiary(Beneficiary b){
        try{
            for (Beneficiary be : beneficiaryList){
                if (be.getID() == b.getID()){
                    throw new SimilarityException("This Beneficiary Already Exists.");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        beneficiaryList.add(b);
    }

    public void removeBeneficiary(Beneficiary b){
        beneficiaryList.remove(b);
    }

    public void listEntities(){
        System.out.println("The available entities are: Materials and Services.");
        System.out.println ("Materials: ");
        for (int i=0; i<entityList.size(); i++){
            if (!entityList.get(i).isService){
                System.out.println ("No." + (i+1) + entityList.get(i).getName());
            }
        }
        System.out.println();
        System.out.println ("Services: ");
        for (int i=0; i<entityList.size(); i++){
            if (entityList.get(i).isService){
                System.out.println ("No." + (i+1) + entityList.get(i).getName());
            }
        }
    }

    public void listMaterials(){
        System.out.println ("Materials: ");
        for (Entity e : entityList){
            if (!e.isService()){
                System.out.println (String.format("ID: %s Name: %s ", e.getID(), e.getName()));
            }
        }
    }

    public void listOrgMat(){
        System.out.println ("Materials: ");
        for (RequestDonation rd : currentDonations.getRdEntities()){
            if (!rd.getEntity().isService()){
                System.out.println (String.format("ID: %s Name: %s Quantity: %.2f", rd.getEntity().getID(), rd.getEntity().getName(), rd.getQuantity()));
            }
        }
    }

    public void listServices(){
        System.out.println ("Services: ");
        for (Entity e : entityList){
            if (e.isService()){
                System.out.println (String.format("ID: %s Name: %s ", e.getID(), e.getName()));
            }
        }
    }

    public void listOrgSer(){
        System.out.println ("Services: ");
        for (RequestDonation rd : currentDonations.getRdEntities()){
            if (rd.getEntity().isService()){
                System.out.println (String.format("ID: %s Name: %s Quantity: %.2f", rd.getEntity().getID(), rd.getEntity().getName(), rd.getQuantity()));
            }
        }
    }

    public void listBeneficiaries(){
        for (int i=0; i<beneficiaryList.size(); i++){
            System.out.println ("Beneficiary ID " + beneficiaryList.get(i).getID() + " Name: " + beneficiaryList.get(i).getName());

        }
    }

    public void listDonators(){
        for (int i=0; i<donatorList.size(); i++){
            System.out.println ("Donator ID " + donatorList.get(i).getID() + " Name: " + donatorList.get(i).getName());
        }
    }

    public RequestDonationList getCurrentDonations(){
        return currentDonations;
    }

    public void setID(int iD){
        id = iD;
    }

    public int getID(){
        return id;
    }

    public Beneficiary getBeneficiary(String phone){
        for (int i=0; i<beneficiaryList.size(); i++){
            if (phone.equals(beneficiaryList.get(i).getPhone())){
                return beneficiaryList.get(i);
            }
        }
        return null;
    }

    public Beneficiary getBeneficiaryById(int id){
        for(Beneficiary b : beneficiaryList){
            if (b.getID() == id){
                return b;
            }
        }
        return null;
    }

    public Donator getDonator(String phone){
        for (int i=0; i<donatorList.size(); i++){
            if (phone.equals(donatorList.get(i).getPhone())){
                return donatorList.get(i);
            }
        }
        return null;
    }

    public Donator getDonatorById(int id){
        for(Donator d : donatorList){
            if (d.getID() == id){
                return d;
            }
        }
        return null;
    }

    public String getOrgName(){
        return name;
    }

    public void setOrgName(String org){
        name = org;
    }

    public boolean isAvailable(RequestDonation r){
        for(RequestDonation l : currentDonations.getRdEntities()){
            if(r.getName().equals(l.getName()) && r.getQuantity() <= l.getQuantity()){
                return true;
            }
        }
        return false;
    }

    public Entity getEntityById(int id){
        for(Entity e : entityList){
            if (e.getID() == id){
                return e;
            }
        }return null;
    }

    public int getEntityId(int id){
        for(Entity e : entityList){
            if (e.getID() == id){
                return id;
            }
        }return 0;
    }
}
