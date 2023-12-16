public class EmployeeInfo {
    String iD, name;
    String phoneNo;
    double salary, worksHour;

    public EmployeeInfo(String iD, String name,String phoneNo, double worksHour, double salary) {
        this.iD = iD;
        this.name = name;
        this.salary = salary;
        this.phoneNo = phoneNo;
        this.worksHour = worksHour;
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
}
