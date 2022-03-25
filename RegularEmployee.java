import java.util.Calendar;

public class RegularEmployee extends Employee{
    private double performanceScore;
    private double bonus;

    public RegularEmployee(int id, String firstName, String lastName, String gender
            , Calendar birthDate, String maritalStatus, String hasDriverLicence,
                           double salary, Calendar hireDate, Department department,double performanceScore){
        super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence,salary,hireDate,department);
        this.performanceScore = performanceScore;

    }
    public RegularEmployee(Employee employee,double perfScore){
         super(employee.getId(),employee.getFirstName(), employee.getLastName(),employee.getGender(),
                employee.getBirthDate(),employee.getMaritalStatus(),employee.getHasDriverLicence(),employee.getSalary(),
                employee.getHireDate(),employee.getDepartment());
        this.performanceScore = perfScore;

    }

    public RegularEmployee() {
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        if (performanceScore >= 0){
        this.performanceScore = performanceScore;
    }else try {
            throw new Exception("performanceScore cannot be negative.. ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus >= 0){
        this.bonus = bonus;
    }else try {
            throw new Exception("Bonus cannot be negative.. ");
        } catch (Exception e) {
            e.printStackTrace();
        }}

    @Override
    public String toString() {
        return super.toString() +
                "\n                                RegularEmployee Info [" +
                "performanceScore=" + performanceScore +
                ", bonus=" + bonus +
                ']';
    }
}
