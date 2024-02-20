package payrollweb.itprofound.employee;

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
import payrollweb.itprofound.models.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	
	
	    private final EmployeeService employeeService;

	    @Autowired
	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	    @PostMapping
	    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	        Employee createdEmployee = employeeService.createEmployee(employee);
	        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	    }

	    @GetMapping("/{employeeId}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") long employeeId) {
	        return employeeService.getEmployeeById(employeeId)
	                .map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @GetMapping
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        List<Employee> employees = employeeService.getAllEmployees();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }

	    @PutMapping("/{employeeId}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") long employeeId,
	                                                    @RequestBody Employee updatedEmployee) {
	        Employee updated = employeeService.updateEmployee(employeeId, updatedEmployee);
	        if (updated != null) {
	            return new ResponseEntity<>(updated, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{employeeId}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") long employeeId) {
	        employeeService.deleteEmployee(employeeId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		

}
