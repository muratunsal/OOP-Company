import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee{
    private ArrayList<Project> projects;
    public static int numberOfDevelopers;

    public Developer(int id, String firstName, String lastName, String gender
            , Calendar birthDate, String maritalStatus, String hasDriverLicence,
                     double salary, Calendar hireDate, Department department, double pScore,ArrayList<Project> p){
        super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence,salary,hireDate,department,pScore);
        projects = p;
        numberOfDevelopers++;

    }
    public Developer(RegularEmployee re, ArrayList<Project> p){
        super(re.getId(),re.getFirstName(),re.getLastName(),re.getGender(),re.getBirthDate(),
                re.getMaritalStatus(),re.getHasDriverLicence(),re.getSalary(),re.getHireDate(),re.getDepartment(),re.getPerformanceScore());
        projects = p;

}

    public Developer() {

    }

    public boolean addProject(Project s){
        projects.add(s);
        return true;
    }
    public boolean removeProject(Project s){
        if (projects.contains(s)){
        projects.remove(s);
        return true;}
        else
            return false;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public static int getNumberOfDevelopers() {
        return numberOfDevelopers;
    }

    public static void setNumberOfDevelopers(int numberOfDevelopers) {
        if (numberOfDevelopers >= 0){
        Developer.numberOfDevelopers = numberOfDevelopers;
    }else try {
            throw new Exception("numberOfDevelopers cannot be negative.. ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return super.toString()+
                "\n                                " +projects.toString() ;
    }
}
