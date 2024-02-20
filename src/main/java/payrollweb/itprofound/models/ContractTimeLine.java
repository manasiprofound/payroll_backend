package payrollweb.itprofound.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contractTimeLine")
public class ContractTimeLine {
	        @Id
	        private Long employeeId;
	        
	        private Long assignmentId;
	        
	        private String timelineContact;

			private Date calendar;
	        
	        private  int  monthlyHoursWorked;


	        public ContractTimeLine() {
	        	
	        }

	        public ContractTimeLine(Long employeeId, Long assignmentId, String timelineContact,Date calendar, int monthlyHoursWorked) {
	            this.employeeId = employeeId;
	            this.assignmentId = assignmentId;
	            this.timelineContact = timelineContact;
	            this.calendar = calendar;
	            this.monthlyHoursWorked = monthlyHoursWorked;
	        }

	        
	        public Long getEmployeeId() {
	            return employeeId;
	        }

	        public void setEmployeeId(Long employeeId) {
	            this.employeeId = employeeId;
	        }

	        public Long getAssignmentId() {
	            return assignmentId;
	        }

	        public void setAssignmentId(Long assignmentId) {
	            this.assignmentId = assignmentId;
	        }

	        public String getTimelineContact() {
	            return timelineContact;
	        }

	        public void setTimelineContact(String timelineContact) {
	            this.timelineContact = timelineContact;
	        }

	    	public void setCalendar(Date calendar) {
				this.calendar = calendar;
			}

			public Date getCalendar() {
				return calendar;
			}


	        public int getMonthlyHoursWorked() {
	            return monthlyHoursWorked;
	        }

	        public void setMonthlyHoursWorked(int monthlyHoursWorked) {
	            this.monthlyHoursWorked = monthlyHoursWorked;
	        }
	    

}
