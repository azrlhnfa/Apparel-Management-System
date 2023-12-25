import javax.swing.JOptionPane;
import java.util.Scanner;

public class App {

    static FileApparel apparelData = null;
    static Scanner sc = new Scanner(System.in);
    static LinkedList apparels = null;
    static FileEmployee empData = null;
    static LinkedList employees = null;
    static LinkedList cart = new LinkedList(); // Added this line
    public static void main(String[] args) {
        apparelData = new FileApparel("apparels_data.txt");
        apparels = apparelData.loadApparel();
        empData = new FileEmployee("employee_data.txt");
        employees = empData.loadEmployee();
        while (true) {
            String[] userOptions = {"Manager", "Employee", "Customer", "Exit"};
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
                managerLogin();
            } 
            else if (userChoice == 1) {
                 employeeLogin();
            } 
            else if (userChoice == 2) {
                handleCustomerOptions();
            }
            else if (userChoice == 3) {
                JOptionPane.showMessageDialog(null, "THANK YOU FOR YOUR COOPERATION. PLEASE COME AGAIN.");
                break;
            }
            else {
                System.out.println("Invalid Input. Please Try Again.");
            }
        }
    }

    static String managerName = "Syahmi";
    static int password = 12345678;
    private static void managerLogin() {
        while (true) {
            System.out.println("Please Enter Your Username :");
            String username = sc.nextLine();
            System.out.println("Please Enter Password :");
            int pswd = sc.nextInt();
            sc.nextLine();

            if (username.equals(managerName)) {
                if (pswd == password) {
                    handleManagerOptions();
                    break;
                }
            }
        }
    }

    private static void employeeLogin() {
        while (true) {
            System.out.println("PLease Enter Employee Username :");
            String username = sc.nextLine();
            System.out.println("PLease Enter Employee ID :");
            String password = sc.nextLine();

            EmployeeInfo emp = null;
            boolean found = false;

            Object data = employees.getFirst();
            while (data!= null) {
                emp = (EmployeeInfo) data;

                if (username.equals(emp.getName())) {
                    if (password.equals(emp.getID())) {
                        found = true;
                        break;
                    }
                }
                data = employees.getNext();
            }
            if (found) {
                handleEmployeeOptions(emp);
                break;
            }
            else{
                System.out.println("Invalid credentials, please try again.");
            }
        }
    }

    private static void handleManagerOptions() {

         while (true) {
            System.out.println("=======WELCOME! WHAT DO YOU WANT TO DO?=======");
            System.out.println("1. ADD NEW EMPLOYEE");
            System.out.println("2. REMOVE EMPLOYEE");
            System.out.println("3. PAY EMPLOYEE SALARY");
            System.out.println("4. VIEW SALESREPORT");
            System.out.println("5. LOG OUT");

            int mngrInput = sc.nextInt();
            sc.nextLine();

            if (mngrInput == 1) {
                
                System.out.println("Register EmployeeID :");
                String empID = sc.nextLine();
                System.out.println("Register Employee Name :");
                String empName = sc.nextLine();
                System.out.println("Register Employee PhoneNo :");
                String phoneNo = sc.nextLine();
                System.out.println("Register Employee WorksHour :");
                double empWorksHour = sc.nextDouble();
                sc.nextLine();
            
                EmployeeInfo employee = new EmployeeInfo(empID, empName, phoneNo, empWorksHour);
                boolean added = employee.addEmployee(employee, employees);
           
                if (added) {
                    empData.updateEmployee(employees);
                }
            }
            else if (mngrInput == 2) {
            
                System.out.println("Please Enter EmployeeID That You Want To Fired :");
                String empID = sc.nextLine();
                System.out.println("Please Enter Employee Name That You Want To Fired : ");
                String enpName = sc.nextLine();

                EmployeeInfo employee = new EmployeeInfo(empID, enpName);
                boolean removed = employee.removeEmployee(employee, employees);

                if (removed) {
                    empData.updateEmployee(employees);
                }
            }
            else if (mngrInput == 3) {
                System.out.println("Enter Employee ID to Pay Salary:");
                String empID = sc.nextLine();
            
                EmployeeInfo employee = findEmployeeById(empID);
            
                if (employee != null) {
                    if (!employee.isSalaryPaid()) {
                        double salaryToPay = employee.calculateSalary(); // Calculate and mark as paid
            
                        // Update employee's salary or perform any necessary actions
                        employee.updateSalaryPaidStatus(true);
            
                        // Save the updated employee data to the file
                        empData.updateEmployee(employees);
            
                        System.out.println("Salary paid successfully: $" + salaryToPay);
                    } else {
                        System.out.println("Employee with ID " + empID + " has already been paid.");
                    }
                } else {
                    System.out.println("Employee not found with ID: " + empID);
                }
            }
            else if (mngrInput == 4) {
                // view salesreport
            }
            else if (mngrInput == 5) {
                JOptionPane.showMessageDialog(null, "BYE.");
                break;
            }
            else
            System.out.println("Invalid Input, PLease Try Again!");
        }
    }

    private static void handleEmployeeOptions(EmployeeInfo emp) {
       

        while (true) {
            System.out.println("=======WELCOME! WHAT DO YOU WANT TO DO?=======");
            System.out.println("1. ADD NEW APPAREL");
            System.out.println("2. REMOVE APPAREL");
            System.out.println("3. UPDATE EXISTING APPAREL");
            System.out.println("4. EXIT");

            int empInput = sc.nextInt();
            sc.nextLine();

            if (empInput == 1) {
                System.out.println("Enter itemCode:");
                String itemCode = sc.nextLine();
                System.out.println("Enter Name:");
                String itemName = sc.nextLine();
                System.out.println("Enter Brand:");
                String itemBrand = sc.nextLine();
                System.out.println("Enter Size:");
                String itemSize = sc.nextLine();
                System.out.println("Enter Quantity:");
                int itemQuantity = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Price:");
                double itemPrice = sc.nextDouble();
                sc.nextLine();

                ApparelItem apparel = new ApparelItem(itemCode, itemName, itemBrand, itemQuantity, itemPrice, itemSize);
                boolean added = apparel.addApparel(apparel, apparels);

                if (added) {
                    apparelData.updateApparel(apparels);
                }
            }
            else if (empInput == 2) {
                System.out.println("Enter itemCode:");
                String itemCode = sc.nextLine();

                ApparelItem apparel = new ApparelItem(itemCode);
                boolean removed = apparel.removeApparel(apparel, apparels);

                if (removed) {
                    apparelData.updateApparel(apparels);
                }
            }
            else if (empInput == 3) {
                // update quantity for existing apparel
            }
            else if (empInput == 4) {
                JOptionPane.showMessageDialog(null, "BYE.");
                break;
            }
            else
             System.out.println("Invalid Input, PLease Try Again!");
        }
    }

    private static void handleCustomerOptions() {
        while (true) {
            System.out.println("=======WELCOME TO MASBRO APPAREL SHOP OUR HONONED CUSTOMER!=======");
            System.out.println("=======================HOW CAN WE HELP YOU?=======================");
            System.out.println("1. SEARCH APPAREL");
            System.out.println("2. VIEW CART");
            System.out.println("3. VIEW ORDER RECEIPT");
            System.out.println("4. LOG OUT");

            int custInput = sc.nextInt();
            sc.nextLine();

            if (custInput == 1) {
                searchApparel();/* ask customer to insert what apparel they want.Example, cust masuk hoodie pastu papar hoodie sajo
                   pastu tanyo nk place order slalu ko atau nk wak masuk dlm cart dulu. kalu order slalu, gi bahagian payment.
                   kalu masuk dlm cart, break gi custOption balik*/
            }
            else if (custInput == 2) {
                displayCart();/* Display cart. Wak so LinkedList cart yg hold apparelitem value. 
                    Ask cust nk place order atau x. Aq x explore lagi hokni nanti aq update balik.*/
            }
            else if (custInput == 3) {
                displayReceipt();/* Display order receipt kalu dio order slalu atau dio letok dlm cart dulu pastu bru dio byr */
            }
            else if (custInput == 4) {
                JOptionPane.showMessageDialog(null, "BYE.");
            }
            else
                System.out.println("Invalid Input, Please Try Again!");
        }
            
    }


    private static EmployeeInfo findEmployeeById(String empID) {
        Object data = employees.getFirst();
        while (data != null) {
            EmployeeInfo emp = (EmployeeInfo) data;
            if (empID.equals(emp.getID())) {
                return emp;
            }
            data = employees.getNext();
        }
        return null; // Employee not found
    }
    private static void searchApparel() {
        

        System.out.println("Enter the keyword to search for apparel:");
        String keyword = sc.nextLine();

        LinkedList searchResults = searchApparelByKeyWord(keyword);

        if (!searchResults.isEmpty()) {
            System.out.println("Search Results:");
            displayApparelList(searchResults);

            System.out.println("Do you want to place order or insert it to cart first?");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                placeOrder();
            } else if (choice == 2) {
                insertToCart(searchResults);
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("No matching apparel found.");
        }
    }

    private static LinkedList searchApparelByKeyWord(String keyword) {
        LinkedList results = new LinkedList();
        Object data = apparels.getFirst();

        while (data != null) {
            ApparelItem apparel = (ApparelItem) data;

            if (apparel.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.insertAtBack(apparel);
            }

            data = apparels.getNext();
        }

        return results;
    }

    private static void displayApparelList(LinkedList apparelList) {
        Object data = apparelList.getFirst();

        while (data != null) {
            ApparelItem apparel = (ApparelItem) data;
            apparel.displayDetails();
            data = apparelList.getNext();
        }
    }

    private static void insertToCart(LinkedList cartItems) {
        Object data = cartItems.getFirst();

        while (data != null) {
            ApparelItem apparel = (ApparelItem) data;
            System.out.println("How many quantity you want to purchase?");
            int quantity = sc.nextInt();
            apparel.setQuantity(quantity);
            cart.insertAtBack(apparel);
            data = cartItems.getNext();

            
        }

        System.out.println("Items inserted into the cart successfully!");
    }

    private static void displayCart() {
        System.out.println("Cart Items:");
        displayApparelList(cart);
    }

    private static void displayReceipt() {
        // Implement the logic to display order receipt
        // You can update your receipt display logic here
        // ...
        System.out.println("Order Receipt:");
        displayApparelList(cart);
    }

    private static void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add items to the cart before placing an order.");
            return;
        }

        double totalOrderAmount = calculateTotalOrderAmount();
        System.out.println("Total Order Amount: $" + totalOrderAmount);

        // Prompt the user for the quantity to order for each item in the cart

        // Implement any additional order processing logic here

        // For example, you can update the inventory, store the order details, etc.

        // Clear the cart after placing the order
        cart = new LinkedList();
        System.out.println("Order placed successfully! Cart cleared.");

        // You can also update any data files or databases here
        // ...

        // Display a confirmation message to the user
        JOptionPane.showMessageDialog(null, "Order placed successfully! Total amount: $" + totalOrderAmount);
    }
    private static double calculateTotalOrderAmount() {
        double totalAmount = 0.0;

        Object data = cart.getFirst();
        while (data != null) {
            ApparelItem apparel = (ApparelItem) data;
            totalAmount = apparel.getQuantity()*apparel.getPrice();
            data = cart.getNext();
        }

        return totalAmount;
    }

}

    
