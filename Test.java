//Murat Unsal 150121516


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));

        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();

        while (input.hasNext()) {
            switch (input.next()) {
                case "Department":
                    int id = input.nextInt();
                    String departmentName = input.next();

                    Department newDepartment = new Department(id, departmentName);
                    departments.add(newDepartment);
                    break;
                case "Project":
                    String projectName = input.next();
                    Calendar calendar = Calendar.getInstance();

                    String dateUnsplitted = input.next();
                    int month = Integer.parseInt(dateUnsplitted.substring(3, 5));
                    calendar.set(Calendar.MONTH, month - 1);
                    int day = Integer.parseInt(dateUnsplitted.substring(0, 2));
                    calendar.set(Calendar.DATE, day);
                    int year = Integer.parseInt(dateUnsplitted.substring(6, 10));
                    calendar.set(Calendar.YEAR, year);

                    String state = input.next();

                    Project newProject = new Project(projectName, calendar, state);
                    projects.add(newProject);
                    break;
                case "Product":
                    String productName = input.next();

                    calendar = Calendar.getInstance();
                    dateUnsplitted = input.next();
                    month = Integer.parseInt(dateUnsplitted.substring(3, 5));
                    calendar.set(Calendar.MONTH, month - 1);
                    day = Integer.parseInt(dateUnsplitted.substring(0, 2));
                    calendar.set(Calendar.DATE, day);
                    year = Integer.parseInt(dateUnsplitted.substring(6, 10));
                    calendar.set(Calendar.YEAR, year);

                    double price = input.nextDouble();

                    Product newProduct = new Product(productName, calendar, price);
                    products.add(newProduct);

                    break;
                case "Person":
                    String firstName = input.next();
                    String lastName = input.next();
                    id = input.nextInt();
                    String gender = input.next();

                    calendar = Calendar.getInstance();
                    dateUnsplitted = input.next();
                    month = Integer.parseInt(dateUnsplitted.substring(3, 5));
                    calendar.set(Calendar.MONTH, month - 1);
                    day = Integer.parseInt(dateUnsplitted.substring(0, 2));
                    calendar.set(Calendar.DATE, day);
                    year = Integer.parseInt(dateUnsplitted.substring(6, 10));
                    calendar.set(Calendar.YEAR, year);

                    String maritalStatus = input.next();
                    String hasDriverLicence = input.next();

                    Person newPerson = new Person(id, firstName, lastName, gender, calendar, maritalStatus, hasDriverLicence);
                    people.add(newPerson);

                    break;
                case "Employee":
                    id = input.nextInt();
                    Person empPerson ;
                    double salary = input.nextDouble();

                    calendar = Calendar.getInstance();
                    dateUnsplitted = input.next();
                    month = Integer.parseInt(dateUnsplitted.substring(3, 5));
                    calendar.set(Calendar.MONTH, month - 1);
                    day = Integer.parseInt(dateUnsplitted.substring(0, 2));
                    calendar.set(Calendar.DATE, day);
                    year = Integer.parseInt(dateUnsplitted.substring(6, 10));
                    calendar.set(Calendar.YEAR, year);

                    String department = input.next();

                    Department empDepartment = new Department();
                    for (Department value: departments) {
                        if (Objects.equals(value.getDepartmentName(), department)) {
                            empDepartment = value;
                            break;
                        }
                    }

                    for (int i = 0; i<people.size(); i++) {
                        if (people.get(i).getId() == id) {
                            empPerson = people.get(i);
                            Employee newEmployee = new Employee(empPerson, salary, calendar, empDepartment);
                            people.set(i, newEmployee);
                            break;
                        }
                    }

                    break;
                case "Manager":
                    Employee managerEmp;
                    double bonusBudget;
                    id = input.nextInt();

                    bonusBudget = input.nextDouble();

                    for (int i = 0; i<people.size(); i++) {
                        if (people.get(i) instanceof Employee) {
                            if (people.get(i).getId() == id) {
                                managerEmp = (Employee) people.get(i);
                                Manager newManager = new Manager(managerEmp, bonusBudget);
                                people.set(i, newManager);
                                break;
                            }
                        }
                    }
                    break;
                case "RegularEmployee":
                    id = input.nextInt();
                    Employee regularEmp;

                    double perfScore = input.nextDouble();

                    for (int i = 0; i<people.size(); i++) {
                        if (people.get(i) instanceof Employee) {
                            if (people.get(i).getId() == id) {
                                regularEmp = (Employee) people.get(i);
                                RegularEmployee newRegularEmp = new RegularEmployee(regularEmp, perfScore);
                                people.set(i, newRegularEmp);
                                break;
                            }
                        }
                    }

                    break;
                case "SalesEmployee":
                    id = input.nextInt();
                    RegularEmployee salesEmp;

                    SalesEmployee newSalesEmp = new SalesEmployee();
                    ArrayList<Product> salesEmpProducts = new ArrayList<>();
                    for (int i = 0; i<people.size(); i++) {
                        if (people.get(i) instanceof RegularEmployee) {
                            if (people.get(i).getId() == id) {

                                salesEmp = (RegularEmployee) people.get(i);
                                newSalesEmp = new SalesEmployee(salesEmp, salesEmpProducts);
                                people.set(i, newSalesEmp);
                                break;
                            }
                        }
                    }

                    String line = input.nextLine();
                    String[] splitted = line.split(" ");

                    for (String value: splitted) {
                        for (Product product: products) {
                            if (Objects.equals(product.getProductName(), value)) {
                                newSalesEmp.addSale(product);
                            }
                        }
                    }
                    break;
                case "Developer":
                    id = input.nextInt();
                    RegularEmployee developerEmp;

                    ArrayList<Project> developerProjects = new ArrayList<>();
                    Developer newDeveloper = new Developer();
                    for (int i = 0; i<people.size(); i++) {
                        if (people.get(i) instanceof RegularEmployee) {
                            if (people.get(i).getId() == id) {
                                developerEmp = (RegularEmployee) people.get(i);
                                newDeveloper = new Developer(developerEmp, developerProjects);
                                people.set(i, newDeveloper);
                                break;
                            }
                        }
                    }

                    line = input.nextLine();
                    splitted = line.split(" ");
                    for (String s: splitted) {
                        for (Project project: projects) {
                            if (Objects.equals(project.getProjectName(), s)) {
                                newDeveloper.addProject(project);
                            }
                        }
                    }
                    break;
                case "Customer":
                    id = input.nextInt();
                    Person customerPerson;
                    ArrayList<Product> customerProducts = new ArrayList<>();
                    line = input.nextLine();
                    splitted = line.split(" ");
                    for (String s: splitted) {
                        for (Product product: products) {
                            if (Objects.equals(product.getProductName(), s)) {
                                customerProducts.add(product);
                            }
                        }
                    }
                    for (int i = 0; i<people.size(); i++) {
                        if (people.get(i).getId() == id) {
                            customerPerson = people.get(i);
                            Customer newCustomer = new Customer(customerPerson, customerProducts);
                            people.set(i, newCustomer);
                            break;
                        }
                    }

                    break;
                default:
                    break;
            }
        }
        managerMethod(people);
        for (Person person: people) {
            if (person instanceof Manager) {
                ((Manager) person).raiseSalary(0.2);
            }
        }
        for (Person person: people) {
            if (person instanceof RegularEmployee && !(person instanceof Developer) && !(person instanceof SalesEmployee)) {
                ((RegularEmployee) person).raiseSalary(0.3);
            }
        }
        for (Person person: people) {
            if (person instanceof Developer) {
                ((Developer) person).raiseSalary(0.23);
            }
        }
        for (Person person: people) {
            if (person instanceof SalesEmployee) {
                ((SalesEmployee) person).raiseSalary(0.18);
            }
        }
        double maxSale = 0;
        for (Person person : people) {
            if (person instanceof SalesEmployee) {
                if (((SalesEmployee) person).getTotalSalePrice(((SalesEmployee) person).getSales()) > maxSale) {
                    maxSale = ((SalesEmployee) person).getTotalSalePrice(((SalesEmployee) person).getSales());
                }
            }
            if (person instanceof SalesEmployee) {
                if ((((SalesEmployee) person).getTotalSalePrice(((SalesEmployee) person).getSales())) == maxSale) {
                    ((SalesEmployee) person).raiseSalary(1000);
                }
            }

        }

        printFile(departments, people);
        printConsole(departments, people);
    }

    public static void managerMethod
            (ArrayList<Person> people) {
        //This method sets all managers regular employees then distributes bonus budget to them...
        for (int i = 0; i<people.size(); i++) {
            ArrayList<RegularEmployee> managersRegularEmp = new ArrayList<>();
            if (people.get(i) instanceof Manager) {
                for (Person person: people) {
                    if (person instanceof RegularEmployee) {
                        if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), ((RegularEmployee) person).getDepartment().getDepartmentName())) {
                            managersRegularEmp.add((RegularEmployee) person);
                        }
                    }
                }
                ((Manager) people.get(i)).setRegularEmployees(managersRegularEmp);
                ((Manager) people.get(i)).distributeBonusBudget();

            }
        }
    }
    public static String getPersonInfo(int id, ArrayList<Person> arrayList) {
        String PersonInfo = null;
        for (Person person: arrayList) {
            if (person.getId() == id) {
                PersonInfo = person.toString();
            }
        }
        return PersonInfo;
    }
    public static void printConsole(ArrayList<Department> departments, ArrayList<Person> people) {
        for (Department department: departments) {
            if (department.getDepartmentId() == 1) {
                System.out.println("************************************************");
            } else {
                System.out.println("\n************************************************");
            }
            System.out.println(department);
            for (int i = 0; i<people.size(); i++) {
                if (people.get(i) instanceof Manager) {
                    if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), department.getDepartmentName())) {
                        System.out.println("        "+people.get(i));
                    }
                    int c = 0;
                    for (int k = 0; k<((Manager) people.get(i)).getRegularEmployees().size(); k++) {
                        if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), department.getDepartmentName())) {
                            int id = ((Manager) people.get(i)).getRegularEmployees().get(k).getId();
                            if (((Manager) people.get(i)).getRegularEmployees().get(k) instanceof Developer) {
                                System.out.println("                        " + (c + 1) + ". Developer");
                                System.out.println("                                " + getPersonInfo(id, people));
                                c++;
                            }
                        }
                    }
                    for (int k = 0; k<((Manager) people.get(i)).getRegularEmployees().size(); k++) {
                        if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), department.getDepartmentName())) {
                            int id = ((Manager) people.get(i)).getRegularEmployees().get(k).getId();
                            if (((Manager) people.get(i)).getRegularEmployees().get(k) instanceof SalesEmployee) {
                                System.out.println("                        " + (c + 1) + ". SalesEmployee");
                                System.out.println("                                " + getPersonInfo(id, people));
                                c++;
                            }
                        }
                    }
                    for (int k = 0; k<((Manager) people.get(i)).getRegularEmployees().size(); k++) {
                        if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), department.getDepartmentName())) {
                            int id = ((Manager) people.get(i)).getRegularEmployees().get(k).getId();
                            if ((!(((Manager) people.get(i)).getRegularEmployees().get(k) instanceof SalesEmployee)) && (!(((Manager) people.get(i)).getRegularEmployees().get(k) instanceof Developer))) {
                                System.out.println("                        " + (c + 1) + ". RegularEmployee");
                                System.out.println("                                " + getPersonInfo(id, people));
                                c++;
                            }
                        }

                    }
                }

            }

        }
        System.out.println("\n\n\n" +
                "**********************CUSTOMERS************************");
        for (Person value: people) {
            if (value instanceof Customer) {
                System.out.println(value);
            }
        }
        System.out.println("\n\n" +
                "**********************PEOPLE************************");
        for (Person person: people) {
            if ((!(person instanceof Employee)) && (!(person instanceof Customer))) {
                System.out.println(person.toStringFull());
            }
        }
    }

    public static void printFile(ArrayList<Department> departments, ArrayList<Person> people) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(new File("output.txt"));
        for (Department department: departments) {
            if (department.getDepartmentId() == 1) {
                output.println("************************************************");
            } else {
                output.println("\n************************************************");
            }
            output.println(department);
            for (int i = 0; i<people.size(); i++) {
                if (people.get(i) instanceof Manager) {
                    if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), department.getDepartmentName())) {
                        output.println("        "+people.get(i));
                    }
                    int c = 0;
                    for (int k = 0; k<((Manager) people.get(i)).getRegularEmployees().size(); k++) {
                        if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), department.getDepartmentName())) {
                            int id = ((Manager) people.get(i)).getRegularEmployees().get(k).getId();
                            if (((Manager) people.get(i)).getRegularEmployees().get(k) instanceof Developer) {
                                output.println("                        " + (c + 1) + ". Developer");
                                output.println("                                " + getPersonInfo(id, people));
                                c++;
                            }
                        }
                    }
                    for (int k = 0; k<((Manager) people.get(i)).getRegularEmployees().size(); k++) {
                        if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), department.getDepartmentName())) {
                            int id = ((Manager) people.get(i)).getRegularEmployees().get(k).getId();
                            if (((Manager) people.get(i)).getRegularEmployees().get(k) instanceof SalesEmployee) {
                                output.println("                        " + (c + 1) + ". SalesEmployee");
                                output.println("                                " + getPersonInfo(id, people));
                                c++;
                            }
                        }
                    }
                    for (int k = 0; k<((Manager) people.get(i)).getRegularEmployees().size(); k++) {
                        if (Objects.equals(((Manager) people.get(i)).getDepartment().getDepartmentName(), department.getDepartmentName())) {
                            int id = ((Manager) people.get(i)).getRegularEmployees().get(k).getId();
                            if ((!(((Manager) people.get(i)).getRegularEmployees().get(k) instanceof SalesEmployee)) && (!(((Manager) people.get(i)).getRegularEmployees().get(k) instanceof Developer))) {
                                output.println("                        " + (c + 1) + ". RegularEmployee");
                                output.println("                                " + getPersonInfo(id, people));
                                c++;
                            }
                        }

                    }
                }

            }

        }
        output.println("\n\n\n" +
                "**********************CUSTOMERS************************");
        for (Person value: people) {
            if (value instanceof Customer) {
                output.println(value);
            }
        }
        output.println("\n\n" +
                "**********************PEOPLE************************");
        for (Person person: people) {
            if ((!(person instanceof Employee)) && (!(person instanceof Customer))) {
                output.println(person.toStringFull());
            }
        }
        output.close();
    }
}