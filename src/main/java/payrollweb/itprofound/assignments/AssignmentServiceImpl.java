package payrollweb.itprofound.assignments;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollweb.itprofound.exception.ResourceNotFoundException;
import payrollweb.itprofound.models.Assignment;

@Service
public class AssignmentServiceImpl implements AssignmentService{

	        @Autowired
	        private AssignmentRepository assignmentRepository;

	        @Override
	        public Assignment createAssignment(Assignment assignment) {
	            return assignmentRepository.save(assignment);
	        }

	        @Override
	        public Assignment getAssignmentById(long id) {
	            return assignmentRepository.findById(id)
	                    .orElseThrow(() -> new ResourceNotFoundException("Assignment not found with id " + id));
	        }

	        @Override
	        public List<Assignment> getAllAssignments() {
	            return assignmentRepository.findAll();
	        }

	        @Override
	        public Assignment updateAssignment(long id, Assignment updatedAssignment) {
	            Assignment existingAssignment = getAssignmentById(id);
	            existingAssignment.setTask(updatedAssignment.getTask());
	            existingAssignment.setMilestone(updatedAssignment.getMilestone());
	            existingAssignment.setWeeklyHours(updatedAssignment.getWeeklyHours());
	            existingAssignment.setTotalHours(updatedAssignment.getTotalHours());
	            return assignmentRepository.save(existingAssignment);
	        }

	        @Override
	        public void deleteAssignment(long id) {
	            assignmentRepository.deleteById(id);
	        }
	    
	    
	    
	        @Override
	        public Assignment saveAssignment(Assignment assignment) {
	            return assignmentRepository.save(assignment);
	        }
}
