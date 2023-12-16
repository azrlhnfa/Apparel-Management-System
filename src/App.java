import javax.swing.JOptionPane;
import java.util.Scanner;

public class App {

    static FileApparel fileApparel = new FileApparel();
    public static void main(String[] args) {
        LinkedList  apparels = new LinkedList()

        while (true) {
            String[] userOptions = {"Employee", "Customer", "Exit"};
            int userChoice = JOptionPane.showOptionDialog(
                    null,
                    "Welcome to MASBRO APPAREL SHOP\nWho are you?",
                    "User Selection",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    userOptions,
                    userOptions[0]
            );

            if (userChoice == 0) {
                handleEmployeeOptions(apparels, fileApparel);
            } else if (userChoice == 1) {
                // Add logic for customer operations
            } else {
                break; // Exit the program
            }
        }
    }

    private static void handleEmployeeOptions(LinkedList apparels, FileApparel fileApparel) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=======WELCOME! WHAT DO YOU WANT TO DO?=======");
            System.out.println("1. ADD NEW APPAREL");
            System.out.println("2. REMOVE APPAREL");
            System.out.println("3. EXIT");

            int empInput = sc.nextInt();
            sc.nextLine();

            switch (empInput) {
                case 1:
                    addNewApparel(sc, apparels, fileApparel);
                    break;
                case 2:
                    removeApparel(sc, apparels, fileApparel);
                    break;
                case 3:
                    return; // Exit the employee menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewApparel(Scanner sc, LinkedList apparels, FileApparel fileApparel) {

        System.out.println("Enter itemCode:");
        String c = sc.nextLine();
        System.out.println("Enter Name:");
        String n = sc.nextLine();
        System.out.println("Enter Brand:");
        String b = sc.nextLine();
        System.out.println("Enter Size:");
        String s = sc.nextLine();
        System.out.println("Enter Quantity:");
        int q = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Price:");
        double p = sc.nextDouble();
        sc.nextLine();
        ApparelItem app = new ApparelItem(c, n, b, q, p, s);
        
        apparels.insertAtBack(app);
        fileApparel.updateApparel(apparels);
    }

    private static void removeApparel(Scanner sc, LinkedList apparels, FileApparel fileApparel) {
        fileApparel.loadApparel();
        System.out.println("Please Enter Apparel You Want to Remove");
        String item = sc.nextLine();

        // Iterate through the list to find and remove the matching item
        apparels.removeIf(apparelItem -> ((ApparelItem) apparelItem).getItemCode().equalsIgnoreCase(item));

        fileApparel.updateApparel(apparels);
        System.out.println("Apparel removed successfully.");
    }
}

    
