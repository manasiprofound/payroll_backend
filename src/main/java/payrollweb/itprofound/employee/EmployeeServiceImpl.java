package payrollweb.itprofound.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import payrollweb.itprofound.models.Employee;

import java.util.List;
import java.util.Optional;


	@Service
	public class EmployeeServiceImpl implements EmployeeService {

	    private final EmployeeRepository employeeRepository;

	    @Autowired
	    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }

	    @Override
	    public Employee createEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    @Override
	    public Optional<Employee> getEmployeeById(long employeeId) {
	        return employeeRepository.findById(employeeId);
	 
	    }
	   
	    @Override
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    @Override
	    public Employee updateEmployee(long employeeId, Employee updatedEmployee) {
	        if (employeeRepository.existsById(employeeId)) {
	            updatedEmployee.setEmployeeId(employeeId);
	            return employeeRepository.save(updatedEmployee);
	        }
	        return null;
	    }

	    @Override
	    public void deleteEmployee(long employeeId) {
	        employeeRepository.deleteById(employeeId);
	    }
	

	

}
