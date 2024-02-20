package payrollweb.itprofound.assignments;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payrollweb.itprofound.models.Assignment;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

	        @Autowired
	        private AssignmentService assignmentService;

	        @PostMapping
	        public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
	            Assignment createdAssignment = assignmentService.createAssignment(assignment);
	            return new ResponseEntity<>(createdAssignment, HttpStatus.CREATED);
	        }
	        @GetMapping("/{id}")
	        public ResponseEntity<Assignment> getAssignmentById(@PathVariable("id") long id) {
	            Assignment assignment = assignmentService.getAssignmentById(id);
	            return new ResponseEntity<>(assignment, HttpStatus.OK);
	        }

	        @GetMapping
	        public ResponseEntity<List<Assignment>> getAllAssignments() {
	            List<Assignment> assignments = assignmentService.getAllAssignments();
	            return new ResponseEntity<>(assignments, HttpStatus.OK);
	        }

	        @PutMapping("/{id}")
	        public ResponseEntity<Assignment> updateAssignment(@PathVariable("id") long id, @RequestBody Assignment updatedAssignment) {
	            Assignment assignment = assignmentService.updateAssignment(id, updatedAssignment);
	            return new ResponseEntity<>(assignment, HttpStatus.OK);
	        }

	        @DeleteMapping("/{id}")
	        public ResponseEntity<Void> deleteAssignment(@PathVariable("id") long id) {
	            assignmentService.deleteAssignment(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        @PostMapping("/save")
	        public Assignment saveAssignment(@RequestBody Assignment assignment) {
	            return assignmentService.saveAssignment(assignment);
	        }
}
