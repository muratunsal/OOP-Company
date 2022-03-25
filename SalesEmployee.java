import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee {
        private ArrayList<Product> sales;
        public static int numberOfSalesEmployees;

        public SalesEmployee(int id, String firstName, String lastName, String gender
                , Calendar birthDate, String maritalStatus, String hasDriverLicence,
                             double salary, Calendar hireDate, Department department, double pScore, ArrayList<Product> s){
            super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence,salary,hireDate,department,pScore);
            sales = s;
            numberOfSalesEmployees++;

        }
        public SalesEmployee(RegularEmployee re, ArrayList<Product> s){
            super(re.getId(),re.getFirstName(),re.getLastName(),re.getGender(),re.getBirthDate(),
                    re.getMaritalStatus(),re.getHasDriverLicence(),re.getSalary(),re.getHireDate(),re.getDepartment(),re.getPerformanceScore());
            sales = s;
        }

    public SalesEmployee() {

    }

    public boolean addSale(Product s){
            sales.add(s);
        return true;
        }
        public boolean removeSale(Product s){
            if (sales.contains(s)){
                sales.remove(s);
                return true;}
            else
                return false;
        }

    public ArrayList<Product> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Product> sales) {
        this.sales = sales;
    }

    public static int getNumberOfSalesEmployees() {
        return numberOfSalesEmployees;
    }

    public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
            if (numberOfSalesEmployees >= 0) {
                SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
            } else try {
                throw new Exception("numberOfSalesEmployees cannot be negative.. ");
            } catch (Exception e) {
                e.printStackTrace();
            }}
    public double getTotalSalePrice(ArrayList<Product> sales){
           double sum = 0;
        for (Product sale : sales) {
            sum += sale.getPrice();
        }
return sum;
    }
    @Override
    public String toString() {
        return  super.toString()+
                "\n                                "+
                sales.toString();
    }

}
