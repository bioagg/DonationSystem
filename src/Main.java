public class Main
{
    public static void main (String [] args)
    {
        Organization org = new Organization("myOrg");
        Entity milk = new Material(1, "Milk" , 5, 5, 5);
        Entity sugar = new Material(2, "Sugar" , 5, 5, 5);
        Entity rice = new Material(3, "Rice" , 5, 5, 5);
        org.addEntity(milk);
        org.addEntity(sugar);
        org.addEntity(rice);
        Entity medicalSupport = new Service(4, "MedicalSupport");
        Entity nurserySupport = new Service(5, "NurserySupport");
        Entity babysitting = new Service(6, "Babysitting");
        org.addEntity(medicalSupport);
        org.addEntity(nurserySupport);
        org.addEntity(babysitting);
        Admin ad = new Admin(1, "Maria" ,"6955555555");
        org.setAdmin(ad);
        Beneficiary b1 = new Beneficiary(1, "Kostas", "6944444444", 4);
        org.insertBeneficiary(b1);
        Beneficiary b2 = new Beneficiary(2, "Giorgos" , "698888888", 1);
        org.insertBeneficiary(b2);
        Donator d1 = new Donator(1, "Takis", "697777777");
        org.insertDonator(d1);
        Menu m1 = new Menu();
        m1.start(org, m1);
        System.out.println(ad.getphone() + ad.getIsAdmin());

    }
}










