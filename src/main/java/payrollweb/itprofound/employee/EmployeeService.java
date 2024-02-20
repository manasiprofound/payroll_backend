package payrollweb.itprofound.employee;

import java.util.List;
import java.util.Optional;
import payrollweb.itprofound.models.Employee;

public interface EmployeeService {

	    Employee createEmployee(Employee employee);
	    
	    List<Employee> getAllEmployees();
	    
	    Optional<Employee> getEmployeeById(long employeeId);
	    
	    Employee updateEmployee(long employeeId, Employee updatedEmployee);
	    
	    void deleteEmployee(long employeeId);
	    


}
