import java.util.Calendar;

public class Employee extends Person {
    private double salary;
    private java.util.Calendar hireDate;
    private Department department;
    public int numberOfEmployees;

    public Employee(int id, String firstName, String lastName, String gender
            , Calendar birthDate, String maritalStatus, String hasDriverLicence,
            double salary, Calendar hireDate, Department department){

        super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence);
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
        numberOfEmployees++;



    }
    public Employee(Person person ,double salary, Calendar hireDate, Department department){
        super(person.getId(),person.getFirstName(),person.getLastName(),person.getGender(),
                person.getBirthDate(),person.getMaritalStatus(),person.getHasDriverLicence());
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
        numberOfEmployees++;

    }

    public Employee() {
    }

    public double raiseSalary(double percent){
        salary *= (1+percent);
        return salary;

    }
    public double raiseSalary(int amount){
        salary += amount;
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0){
            this.salary = salary;
    }  else try {
            throw new Exception("Salary cannot be negative.. ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        if (numberOfEmployees >= 0 ){

        this.numberOfEmployees = numberOfEmployees;
    }  else try {
            throw new Exception("numberOfEmployees cannot be negative..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String calendarToString(Calendar c){
        String MM = String.valueOf(c.get(Calendar.MONTH )+1);

        String DD = String.valueOf(c.get(Calendar.DATE));

        String YYYY = String.valueOf(c.get(Calendar.YEAR));

        return (DD + "/" + MM + "/" + YYYY);
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n                                Employee Info [" +
                "salary=" + salary +
                ", hireDate=" + calendarToString(hireDate) +
                ']';
    }
}
