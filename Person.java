import java.util.Calendar;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private byte gender;
    private java.util.Calendar birthDate;
    private byte maritalStatus;
    private boolean hasDriverLicence;



    public Person(){}
    public Person(int id, String firstName, String lastName, String gender
                  , Calendar birthDate, String maritalStatus, String hasDriverLicence){
        setHasDriverLicence(hasDriverLicence);
        setGender(gender);
        setMaritalStatus(maritalStatus);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;


    }




    public void setGender(String gender){
        if (gender.length() >=3){
        if(gender.equals("Woman")){
            this.gender = 1;
        }else if (gender.equals("Man")){
            this.gender = 2;
        }
    }else{
            try {
                throw new Exception("Gender cannot be less than 3 symbols..");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }}

    public String getGender(){
        if (this.gender == 1){
            return "Woman";
        }else
            return "Man";
        }


    public void setMaritalStatus(String status){

        if (status.length()>=3){
        if(status.equals("Single")){
            this.maritalStatus = 1;
        }else if (status.equals("Married")){
            this.maritalStatus = 2;
        }
    }else try {
            throw new Exception("Marital status cannot be less than 3 symbols..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getMaritalStatus(){
        if (this.maritalStatus == 1){
            return "Single";
        }else
            return "Married";

    }
    public void setHasDriverLicence(String info){
        if (info.length()>=2){
        if(info.equals("Yes")){
            this.hasDriverLicence = true;
        }else if (info.equals("No")){
            this.hasDriverLicence = false;
        }
    }else try {
                throw new Exception("Driver licence info cannot be less than 2 symbols..");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public String getHasDriverLicence(){
        if (this.hasDriverLicence){
            return "Yes";
        }else
            return "No";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0){
        this.id = id;
    }else
        try {
            throw new Exception("Id cannot be negative..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() >= 3){
        this.firstName = firstName;
    }else try {
            throw new Exception("First name cannot be less than 3 symbols..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() >= 3){
            this.lastName = lastName;
        }else try {
            throw new Exception("Last name cannot be less than 3 symbols..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
    public String calendarToString(Calendar c){
        String MM = String.valueOf(c.get(Calendar.MONTH )+1);

        String DD = String.valueOf(c.get(Calendar.DATE));

        String YYYY = String.valueOf(c.get(Calendar.YEAR));

        return (DD + "/" + MM + "/" + YYYY);
    }


    public String toString() {
        return "Person Info [" +
                "id=" + id +
                ", firstName=" + firstName  +
                ", lastName=" + lastName  +
                ", gender=" + getGender() +
                ']';
    }
    public String toStringFull(){
        return "Person [" +
                "id=" + id +
                ", firstName=" + firstName  +
                ", lastName=" + lastName  +
                ", gender=" + getGender() +
                ", birthDate=" + calendarToString(birthDate) +
                ", maritalStatus=" + getMaritalStatus() +
                ", hasDriverLicence=" + getHasDriverLicence() +
                ']';
    }




}
