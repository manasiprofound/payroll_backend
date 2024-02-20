package payrollweb.itprofound.employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import payrollweb.itprofound.models.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

	

}
