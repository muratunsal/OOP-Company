import java.util.Calendar;

public class Project {
    private String projectName;
    private java.util.Calendar startDate;
    private boolean state;

    public Project(String pName, Calendar startDate, String state){
        projectName = pName;
        this.startDate = startDate;
        setState(state);
    }

    public void setState(String state){
        if(state.equals("Open")){
            this.state = true;
        }else if (state.equals("Close")){
            this.state = false;
        }

    }
    public String getState(){
        if (this.state){
            return "Open";
        }else
            return "Close";

    }
    public void close(){
        if ((this.state)){
            this.state = false;
        }
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        if (projectName.length() >= 3){
        this.projectName = projectName;
    }else try {
            throw new Exception("projectName cannot be less than 3 symbols..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    public String calendarToString(Calendar c){
        String MM = String.valueOf(c.get(Calendar.MONTH )+1);

        String DD = String.valueOf(c.get(Calendar.DATE));

        String YYYY = String.valueOf(c.get(Calendar.YEAR));

        return (DD + "/" + MM + "/" + YYYY);
    }


    @Override
    public String toString() {
        return "Project [" +
                "projectName=" + projectName +
                ", startDate=" + calendarToString(startDate) +
                ", state=" + state +
                ']';


    }
}

