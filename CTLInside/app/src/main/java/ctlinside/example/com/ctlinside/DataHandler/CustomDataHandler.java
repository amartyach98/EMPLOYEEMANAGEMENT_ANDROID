package ctlinside.example.com.ctlinside.DataHandler;

import java.util.ArrayList;

public class CustomDataHandler {

    private String EmployeeName;
    private String EmployeeId;
    private String EmployeeDept;

    private ArrayList<CustomDataHandler> customPojo = new ArrayList<>();

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeDept() {
        return EmployeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        EmployeeDept = employeeDept;
    }

}

