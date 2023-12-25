public class EmployeeInfo {
    String iD, name;
    String phoneNo;
    double salary, worksHour;
    boolean salaryPaidStatus;

    public EmployeeInfo(String iD, String name,String phoneNo, double worksHour, double salary, boolean salaryPaidStatus) {
        this.iD = iD;
        this.name = name;
        this.salary = salary;
        this.phoneNo = phoneNo;
        this.worksHour = worksHour;
        this.salaryPaidStatus = false;
    }
    public EmployeeInfo(String iD, String name,String phoneNo, double worksHour) {
        this.iD = iD;
        this.name = name;
        this.phoneNo = phoneNo;
        this.worksHour = worksHour;
    }

    public EmployeeInfo(String iD, String name) {
        this.iD = iD;
        this.name = name;
    }

    public String getID() {
        return iD;
    }

     public String getName() {
        return name;
    }

     public String getPhoneNo() {
        return phoneNo;
    }

     public double getSalary() {
        return salary;
    }

     public double getWorksHour() {
        return worksHour;
    }

    public boolean isSalaryPaid() {
        return salaryPaidStatus;
    }

    @Override
public String toString() {
    return "EmployeeInfo{" +
           "iD='" + iD + '\'' +
           ", name='" + name + '\'' +
           ", phoneNo='" + phoneNo + '\'' +
           ", salary=" + salary +
           ", worksHour=" + worksHour +
           '}';
}

public boolean addEmployee(EmployeeInfo employee, LinkedList employees) {

    boolean found = false;
    Object data = employees.getFirst();

    while (data != null) {
        EmployeeInfo temp = (EmployeeInfo) data;

        if (temp.getID().equals(employee.getID())) {
            if (temp.getName().equals(employee.getName())) {
                found = true;
            }
        }
        data = employees.getNext();
    }
    if (found) {
        System.out.println("Data Already Exist!!");
        return false;
    }

    employees.insertAtBack(employee);
    return true;
}

public boolean removeEmployee(EmployeeInfo employee, LinkedList employees) {

    boolean found = false;
    Object data = employees.getFirst();

    while (data != null) {
        EmployeeInfo temp = (EmployeeInfo) data;

        if (temp.getID().equals(employee.getID())) {
            if (temp.getName().equals(employee.getName())) {
                found = true;
                break;
            }
        }
        data = employees.getNext();
    }
    if (found) {
        employees.remove(data);
        return true;
    }
    System.out.println("Data Doesn't Exist!!");
    return false;
}
// New method to calculate salary
public double calculateSalary() {
    // You can customize the salary calculation logic based on your requirements
    // For example, you can multiply the worked hours by an hourly rate
    double hourlyRate = 10.0; // Set your hourly rate
    double calculatedSalary = worksHour * hourlyRate;

    // Mark the salary as paid
    

    return calculatedSalary;
}

// New method to update salary paid status
public void updateSalaryPaidStatus(boolean status) {
    salaryPaidStatus = status;
}
}

