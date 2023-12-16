import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FileEmployee {
    private LinkedList employees;
    private final String fileName = "employee_data.txt";

    public LinkedList loadEmployee() {
        employees = new LinkedList();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line, ":");
                if (token.countTokens() == 5) {
                    String iD = token.nextToken();
                    String name = token.nextToken();
                    String phoneNo = token.nextToken();
                    double worksHour = Double.parseDouble(token.nextToken());
                    double salary = Double.parseDouble(token.nextToken());

                    EmployeeInfo emp = new EmployeeInfo(iD, name, phoneNo, worksHour, salary);
                    employees.insertAtBack(emp);
                }
            }
            System.out.println("Employee data loaded successfully.");
        }catch (IOException | NumberFormatException e) {
            e.printStackTrace();
    } 
    return employees;
    }

    public void updateEmployee(LinkedList employees) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            Object data = employees.getFirst();
            while (data != null) {
                EmployeeInfo employee = (EmployeeInfo) data;
                writer.println(employee.getID() + ":" + employee.getName() + ":"
                               + employee.getPhoneNo() + ":" + employee.getWorksHour() + ":"
                               + employee.getSalary());
                data = employees.getNext();

            }
            System.out.println("Employee data updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
           
        
    }    
}