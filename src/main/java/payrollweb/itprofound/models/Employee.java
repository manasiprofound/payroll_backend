package payrollweb.itprofound.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
	
    @Id
    private long employeeId;
    
    private String employeeName;
    
    private String client;
    
    private String vendor;
    
    private long assignmentId;
    
    private String status;
    
    private String contractTimeline;


    public Employee() {
    }

    public Employee(long employeeId, String employeeName, String client, String vendor,
                    long assignmentId, String status, String contractTimeline) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.client = client;
        this.vendor = vendor;
        this.assignmentId = assignmentId;
        this.status = status;
        this.contractTimeline = contractTimeline;
    }


    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContractTimeline() {
        return contractTimeline;
    }

    public void setContractTimeline(String contractTimeline) {
        this.contractTimeline = contractTimeline;
    }
}











