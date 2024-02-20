package payrollweb.itprofound.models;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "itprofound_audit")
public class Audit {

	private String employeeId;
    
    private String employeeName;
    
	private String client;
	
    private String vendor;
    
    private String assignmentId;
    
    private String status;
    
    private String contractTimeline;
    		
    private String period;
    	    
    private String action;
    	    	
    private String task;

    private String milestone;

    private int weeklyHours;

    private int totalHours;
    

    private String timelineContact;

    //private Calendar calendar; 

    private Map<String, Integer> monthlyHoursWorked;
    
    

    public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
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

	public String getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(String assignmentId) {
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

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public int getWeeklyHours() {
		return weeklyHours;
	}

	public void setWeeklyHours(int weeklyHours) {
		this.weeklyHours = weeklyHours;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public String getTimelineContact() {
		return timelineContact;
	}

	public void setTimelineContact(String timelineContact) {
		this.timelineContact = timelineContact;
	}

	public Map<String, Integer> getMonthlyHoursWorked() {
		return monthlyHoursWorked;
	}

	public void setMonthlyHoursWorked(Map<String, Integer> monthlyHoursWorked) {
		this.monthlyHoursWorked = monthlyHoursWorked;
	}

		
}
