package ctlinside.example.com.ctlinside.DataHandler;

import java.util.ArrayList;

public class LeaveCustomDataHandler {

    private String empname;
    private String leavereason;
    private String date;

    private ArrayList<LeaveCustomDataHandler> customPojo = new ArrayList<>();

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getLeavereason() {
        return leavereason;
    }

    public void setLeavereason(String leavereason) {
        this.leavereason = leavereason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
