package payrollweb.itprofound.contractTimeLine;


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
import payrollweb.itprofound.models.ContractTimeLine;
import java.util.List;

@RestController
@RequestMapping("/contract-timeline")
public class ContractTimeLineController {

	    private final ContractTimeLineService contractTimeLineService;

	    @Autowired
	    public ContractTimeLineController(ContractTimeLineService contractTimeLineService) {
	        this.contractTimeLineService = contractTimeLineService;
	    }

	    @PostMapping
	    public ResponseEntity<ContractTimeLine> createContractTimeLine(@RequestBody ContractTimeLine contractTimeLine) {
	        ContractTimeLine createdContractTimeLine = contractTimeLineService.createContractTimeLine(contractTimeLine);
	        return new ResponseEntity<>(createdContractTimeLine, HttpStatus.CREATED);
	    }

	    @GetMapping("/{employeeId}")
	    public ResponseEntity<ContractTimeLine> getContractTimeLineById(@PathVariable("employeeId") Long employeeId) {
	        ContractTimeLine contractTimeLine = contractTimeLineService.getContractTimeLineById(employeeId);
	        return new ResponseEntity<>(contractTimeLine, HttpStatus.OK);
	    }

	    @GetMapping
	    public ResponseEntity<List<ContractTimeLine>> getAllContractTimeLines() {
	        List<ContractTimeLine> contractTimeLines = contractTimeLineService.getAllContractTimeLines();
	        return new ResponseEntity<>(contractTimeLines, HttpStatus.OK);
	    }

	    @PutMapping("/{employeeId}")
	    public ResponseEntity<ContractTimeLine> updateContractTimeLine(@PathVariable("employeeId") Long employeeId,
	                                                                   @RequestBody ContractTimeLine updatedContractTimeLine) {
	        ContractTimeLine contractTimeLine = contractTimeLineService.updateContractTimeLine(employeeId, updatedContractTimeLine);
	        return new ResponseEntity<>(contractTimeLine, HttpStatus.OK);
	    }

	    @DeleteMapping("/{employeeId}")
	    public ResponseEntity<Void> deleteContractTimeLine(@PathVariable("employeeId") Long employeeId) {
	        contractTimeLineService.deleteContractTimeLine(employeeId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    @PutMapping("/approve/{employeeId}")
	    public void approveContractTimeLine(@PathVariable Long employeeId) {
	        contractTimeLineService.approveContractTimeLine(employeeId);
	    }

	    @PutMapping("/reject/{employeeId}")
	    public void rejectContractTimeLine(@PathVariable Long employeeId) {
	        contractTimeLineService.rejectContractTimeLine(employeeId);
	    }
	}
