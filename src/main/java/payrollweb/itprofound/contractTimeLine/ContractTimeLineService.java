package payrollweb.itprofound.contractTimeLine;

import java.util.List;
import payrollweb.itprofound.models.ContractTimeLine;

public interface ContractTimeLineService {
	
    ContractTimeLine createContractTimeLine(ContractTimeLine contractTimeLine);
    
    ContractTimeLine getContractTimeLineById(Long employeeId);
    
    List<ContractTimeLine> getAllContractTimeLines();
    
    ContractTimeLine updateContractTimeLine(Long employeeId, ContractTimeLine updatedContractTimeLine);
    
    void deleteContractTimeLine(Long employeeId);
    
    void approveContractTimeLine(Long employeeId);
    
    void rejectContractTimeLine(Long employeeId);
}
