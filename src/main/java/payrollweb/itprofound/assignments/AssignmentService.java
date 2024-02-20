package payrollweb.itprofound.assignments;

import java.util.List;
import payrollweb.itprofound.models.Assignment;

public interface AssignmentService {

	        Assignment createAssignment(Assignment assignment);
	        
	        List<Assignment> getAllAssignments();
	        
	        Assignment getAssignmentById(long id);
	        
	        Assignment updateAssignment(long id, Assignment updatedAssignment);
	        
	        void deleteAssignment(long id);
	        
	        Assignment saveAssignment(Assignment assignment);

}
