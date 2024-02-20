package payrollweb.itprofound.assignments;


import org.springframework.data.mongodb.repository.MongoRepository;
import payrollweb.itprofound.models.Assignment;

public interface AssignmentRepository extends MongoRepository<Assignment, Long> {
	
}
