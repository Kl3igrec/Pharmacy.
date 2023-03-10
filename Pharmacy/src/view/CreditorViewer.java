package view;

import domain.CreditCustomer;
import domain.Type;

import java.util.Scanner;

public class CreditorViewer {
    private controllers.CreditorController creditorController;
    private controllers.DrugController drugController;

    public CreditorViewer(controllers.CreditorController CreditorController, controllers.DrugController DrugController) {
        creditorController = CreditorController;
        drugController = DrugController;
    }

    public void menuDisplayCreditor() {
        System.out.println("""
                Pick an action you would like to do as a Creditor:\s
                """);
        System.out.println("""
                Options are to be inserted""");
    }

    public boolean intermediarMenu(String first, String second) {
        if (creditorController.getAll().contains(second) && creditorController.getAll().contains(first)) {
            return true;
        }
        return false;

    }

    public void menuCreditor() {
        Scanner creditorScanner = new Scanner(System.in);
        CreditorViewer creditorViewer = new CreditorViewer(creditorController, drugController);
        System.out.println("Insert your last name :");
        String lastName = creditorScanner.nextLine();
        System.out.println("Insert your first name :");
        String firstName = creditorScanner.nextLine();
        Type type = Type.ADULT;
        int id = 0;
        CreditCustomer customer = new CreditCustomer(firstName, lastName, type, id);
        if (!intermediarMenu(lastName, firstName)) {
            System.out.println("You are in need of an account");
            id = this.creditorController.getAll().size();
            customer.setID(this.debitorController.getAll().size());

            creditorController.add(customer);
        }

    }
}
