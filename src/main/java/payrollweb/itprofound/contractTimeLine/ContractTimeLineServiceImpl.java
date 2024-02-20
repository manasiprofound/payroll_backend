package payrollweb.itprofound.contractTimeLine;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollweb.itprofound.exception.ResourceNotFoundException;
import payrollweb.itprofound.models.ContractTimeLine;

@Service
public class ContractTimeLineServiceImpl implements ContractTimeLineService {

	    private final ContractTimeLineRepository contractTimeLineRepository;

	    @Autowired
	    public ContractTimeLineServiceImpl(ContractTimeLineRepository contractTimeLineRepository) {
	        this.contractTimeLineRepository = contractTimeLineRepository;
	    }

	    @Override
	    public ContractTimeLine createContractTimeLine(ContractTimeLine contractTimeLine) {
	        return contractTimeLineRepository.save(contractTimeLine);
	    }

	    @Override
	    public ContractTimeLine getContractTimeLineById(Long employeeId) {
	        return contractTimeLineRepository.findById(employeeId)
	                .orElseThrow(() -> new ResourceNotFoundException("ContractTimeLine not found with employeeId " + employeeId));
	    }

	    @Override
	    public List<ContractTimeLine> getAllContractTimeLines() {
	        return contractTimeLineRepository.findAll();
	    }

	    @Override
	    public ContractTimeLine updateContractTimeLine(Long employeeId, ContractTimeLine updatedContractTimeLine) {
	        ContractTimeLine existingContractTimeLine = getContractTimeLineById(employeeId);
	        existingContractTimeLine.setAssignmentId(updatedContractTimeLine.getAssignmentId());
	        existingContractTimeLine.setTimelineContact(updatedContractTimeLine.getTimelineContact());
	        existingContractTimeLine.setCalendar(updatedContractTimeLine.getCalendar());
	        existingContractTimeLine.setMonthlyHoursWorked(updatedContractTimeLine.getMonthlyHoursWorked());
	        return contractTimeLineRepository.save(existingContractTimeLine);
	    }

	    @Override
	    public void deleteContractTimeLine(Long employeeId) {
	        contractTimeLineRepository.deleteById(employeeId);
	    }
	    @Override
	    public void approveContractTimeLine(Long employeeId) {
	        ContractTimeLine contractTimeLine = contractTimeLineRepository.findById(employeeId)
	                .orElseThrow(() -> new IllegalArgumentException("Contract timeline not found"));
	        
	    }
	    
	    @Override
	    public void rejectContractTimeLine(Long employeeId) {
	        ContractTimeLine contractTimeLine = contractTimeLineRepository.findById(employeeId)
	                .orElseThrow(() -> new IllegalArgumentException("Contract timeline not found"));
	        
	    }

}

