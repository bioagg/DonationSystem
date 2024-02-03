class Donator extends User
{
    private Offers offersList = new Offers();

    public Donator(int id, String name, String phone){
        setName(name);
        setPhone(phone);
        setID(id);
    }

    public void add(RequestDonation rd, Organization o){
        offersList.add(rd, o);
    }

    public void remove(RequestDonation rd){
        offersList.remove(rd);
    }

    public Offers getOffersList(){
        return offersList;
    }

    //Η μέθοδος listOffers, μετά από έλεγχο για το αν η offersList είναι άδεια:
    //-	Αν δεν είναι άδεια, εκτυπώνει τα περιεχόμενα του αντικειμένου offersList του Donator που την καλεί
    public boolean listOffers(){
        if (offersList.getRdEntities().isEmpty()){
            System.out.println("The offersList is empty");
            return false;
        }
        for (RequestDonation rd : offersList.getRdEntities()){
            System.out.println(String.format("ID: %d Name: %s Quantity: %.2f Type: %s", rd.getID(), rd.getName(), rd.getQuantity(),
                    rd.getEntity().isService() ? "Service" : "Material"));
        }
        return true;
    }
}