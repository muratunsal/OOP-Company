public class Department {
    private int departmentId;
    private String departmentName;

    public Department(int departmentId, String departmentName){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Department() {

    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId){

            if (departmentId >= 0)
                this.departmentId = departmentId;
            else
                try {
                    throw new Exception("DepartmentId cannot be negative ...");
                } catch (Exception e) {
                    e.printStackTrace();
                }


    }
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName.length() >=3){
        this.departmentName = departmentName;
    }else try {
                throw new Exception("departmentName cannot be less than 3 symbols.. ");
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    @Override
    public String toString() {
        return "Department " +
                "[departmentId=" + departmentId +
                ", departmentName=" + departmentName +"]";

    }
}
