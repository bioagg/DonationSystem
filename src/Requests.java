public class Requests extends RequestDonationList{
    public boolean validRequestDonation(Beneficiary b, double q){
        for (RequestDonation r : getRdEntities()){
            if(!r.isValid(b, q)){
                return false;
            }
        }
        return true;
    }

    public void add(Organization o1, RequestDonation rd, Beneficiary b){
        double q = 0;
        try{
            if(o1.isAvailable(rd)){
                if(validRequestDonation(b, q)){
                    add(rd, o1);
                    System.out.println("The Request Has Been Succesfully Submitted.");
                }else throw new LevelException("You are not permitted to ask for this quantity");
            }
            else throw new OverQuantity("The organization doesn't have that much quantity");
        }catch (Exception m) {
            System.out.println(m.getMessage());
        }
    }

    public void modify(Organization o1, RequestDonation rd, Beneficiary b, double q){
        try{
            if(o1.isAvailable(rd)){
                if(validRequestDonation(b, q)){
                    modify(rd, q);
                    System.out.println("The Quantity of The Requested Item Has Changed.");
                }else throw new LevelException("You are not permitted to ask for this quantity");
            }else throw new OverQuantity("The organization doesn't have that much quantity");
        }catch (Exception m){
            System.out.println(m.getMessage());
        }
    }

    public boolean commit(Organization o1, Beneficiary b){
        try{
            for(RequestDonation rd : b.getRequestsList().getRdEntities()){
                double q = 0;
                if(o1.isAvailable(rd)){
                    if(validRequestDonation(b, q)){
                        for(RequestDonation rd1 : o1.currentDonations.getRdEntities()){
                            b.addReceived(rd, o1);
                            b.getRequestsList().emptyList();
                            if(rd1.getName().equals(rd.getName())){
                                rd1.removeQuantity(rd.getQuantity());
                            }
                        }
                        System.out.println("Your Changes Have Been Saved!");
                        return true;
                    }else throw new LevelException("You are not permitted to ask for this quantity");
                }else throw new OverQuantity("The organization doesn't have that much quantity");
            }return true;
        }catch (Exception m){
            System.out.println(m.getMessage());
            return false;
        }
    }
}