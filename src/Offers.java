public class Offers extends RequestDonationList{
    public void commit(Organization o){
        int i = getRdEntities().size();
        while (i != 0){
            o.currentDonations.add(getRdEntities().get(i-1), o);
            getRdEntities().remove(i-1);
            i -= 1;
        }
    }
}
