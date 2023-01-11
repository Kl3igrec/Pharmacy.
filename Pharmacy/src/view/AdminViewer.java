package view;

import domain.CreditCustomer;
import domain.Type;

import java.util.Arrays;
import java.util.Scanner;

public class AdminViewer {
    private controllers.CreditorController creditorController;
    private controllers.DrugController drugController;
    private controllers.DebitorController debitorController;

    public AdminViewer(controllers.CreditorController CreditorController, controllers.DrugController DrugController, controllers.DebitorController DebitorController) {
        creditorController = CreditorController;
        drugController = DrugController;
        debitorController = DebitorController;
    }

    public void menuDisplayAdmin() {
        System.out.println("""
                Pick an action you would like to do as an Admin:\s
                """);
        System.out.println("""
                1. Add Creditor manually\s
                2. Delete Creditor manually
                3. Add Debitor manually
                4. Delete Debitor manually
                5. Show all Drugs sorted by name
                6. Show all Drugs sorted by price
                7. Show all Drugs sorted by quantity
                0. Exit
                """);
    }

    public void menuAdmin() {
        Scanner adminScanner = new Scanner(System.in);
        AdminViewer adminViewer = new AdminViewer(creditorController, drugController, debitorController);
        String name = null;
        String lastName = null;
        Type type = null;
        int id = 0;
        //CreditCustomer client =new CreditCustomer(name,lastName,type,id);
        boolean ok = true;
        //AdminViewer AdminView=new AdminViewer(CreditorController,DrugController,DebitorController);
        while (ok) {
            menuDisplayAdmin();
            switch (adminScanner.nextInt()) {
                case 1:
                    System.out.println("You've selected to enter a New Creditor manually");
                    System.out.println("Select a name: ");
                    name = adminScanner.next();
                    System.out.println("Select a last name: ");
                    lastName = adminScanner.next();
                    type = Type.SENIOR;

                    System.out.println(" Id will be automatically selected \n ");
                    id = this.creditorController.getAll().size();
                    adminViewer.creditorController.add(new CreditCustomer(name, lastName, type, id));
                    break;
                case 2:
                    System.out.println("You've selected to delete a Creditor manually");
                    System.out.println(Arrays.toString(creditorController.getAll().toString().split("}, ")));
                    System.out.println("Select the id : ");
                    int indexCreditor = adminScanner.nextInt();
                    creditorController.getAll().remove(indexCreditor - 1);
                    break;
                case 3:
                    System.out.println("You've selected to enter a New Debitor manually");

                    System.out.println("Select a name: ");
                    name = adminScanner.next();
                    System.out.println("Select a last name: ");
                    lastName = adminScanner.next();
                    int number = adminScanner.nextInt();
                    if (number == 0)
                        type = Type.CHILD;
                    else if (number == 1) {
                        type = Type.ADULT;
                    } else if (number == 2) {
                        type = Type.SENIOR;
                    }
                    System.out.println(" Id will be automatically selected \n ");
                    id = this.creditorController.getAll().size();
                    adminViewer.creditorController.add(new CreditCustomer(name, lastName, type, id));

                    break;
                case 4:
                    System.out.println("You've selected to delete a Debitor manually");
                    System.out.println(Arrays.toString(creditorController.getAll().toString().split("}, ")));
                    System.out.println("Select the id : ");
                    int indexDebitor = adminScanner.nextInt();
                    creditorController.getAll().remove(indexDebitor - 1);
                    break;
                case 5:
                    System.out.println("You've selected to see all Drugs sorted by name");
                    System.out.println(this.drugController.sortedByName());
                    break;
                case 6:
                    System.out.println("You've selected to see all Drugs sorted by price");
                    System.out.println(this.drugController.sortedByPrice());
                    break;
                case 7:
                    System.out.println("You've selected to see all Drugs sorted by quantity");
                    System.out.println(this.drugController.sortedByQuantity());

                    break;
                case 0:
                    ok = false;

            }
        }
    }
}
