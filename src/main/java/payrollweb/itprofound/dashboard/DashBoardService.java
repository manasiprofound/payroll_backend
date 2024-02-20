package payrollweb.itprofound.dashboard;

import java.util.List;
import payrollweb.itprofound.models.DashBoard;
public interface DashBoardService {
	
	
    DashBoard createDashBoard(DashBoard dashBoard);
    
    List<DashBoard> getAllDashBoards();
    
    DashBoard getDashBoardById(long id);
    
    DashBoard updateDashBoard(long id, DashBoard updatedDashBoard);
    
    void deleteDashBoard(long id);
}
