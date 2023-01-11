package view;

import controllers.CreditorController;
import controllers.DebitorController;
import controllers.DrugController;

import java.util.Scanner;

public class Viewer {//trebuie puse controllere

    private CreditorController CreditorController;
    private DrugController DrugController;
    private DebitorController DebitorController;

    public Viewer(controllers.CreditorController creditorController, controllers.DrugController drugController, controllers.DebitorController debitorController) {
        CreditorController = creditorController;
        DrugController = drugController;
        DebitorController = debitorController;
    }

    public void menuDisplay1() {
        System.out.println("\tWelcome to your Pharmacy\n Please select your position :\n1. Admin \n2. Creditor \n3. Debitor \n");
        System.out.print("Type in the number : ");
    }

    public void menu() {
        Scanner first = new Scanner(System.in);

        menuDisplay1();
        switch (first.nextInt()) {
            case 1:
                System.out.println("You are now an admin");
                AdminViewer AdminView = new AdminViewer(CreditorController, DrugController, DebitorController);
                AdminView.menuAdmin();
                break;
            case 2:
                System.out.println("Your are now a creditor");
                CreditorViewer creditorView = new CreditorViewer(CreditorController, DrugController);
                break;
            case 3:
                System.out.println("You are now a debitor");
                DebitorViewer debitorView = new DebitorViewer(DebitorController, DrugController);

                break;
        }
    }

    public void menuAdmin() {

    }
}
