package payrollweb.itprofound.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dashboards")
public class DashBoard {
    @Id
	private long assignmentId;
	
    private String period;
    
    private String status;
    
    private String action;
    
	private long employeeId;
	
	
	
    public long getEmployeeId() {
		return employeeId;
	}
    
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	public long getAssignmentId() {
		return assignmentId;
	}
	
	public void setAssignmentId(long assignmentId) {
		this.assignmentId = assignmentId;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}

}
