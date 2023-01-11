package domain;

import java.util.List;

public class DebitCustomer extends Customer {
    private List<Drug> drugList;

    // private float totalBudget;
    public DebitCustomer(String firstName, String lastName, Type type, int ID, float totalBudget) {
        super(firstName, lastName, type, ID);
        //this.totalBudget = totalBudget;
    }

    public DebitCustomer(String firstName, String lastName, Type type, int ID) {
        super(firstName, lastName, type, ID);
    }


}
