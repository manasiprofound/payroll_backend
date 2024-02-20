package payrollweb.itprofound.dashboard;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import payrollweb.itprofound.exception.ResourceNotFoundException;
import payrollweb.itprofound.models.DashBoard;

 @Service
 public class DashBoardServiceImpl implements DashBoardService {

     @Autowired
     private DashBoardRepository dashBoardRepository;

     @Override
     public DashBoard createDashBoard(DashBoard dashBoard) {
         return dashBoardRepository.save(dashBoard);
     }

     @Override
     public DashBoard getDashBoardById(long id) {
         return dashBoardRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("DashBoard not found with id " + id));
     }

     @Override
     public List<DashBoard> getAllDashBoards() {
         return dashBoardRepository.findAll();
     }

     @Override
     public DashBoard updateDashBoard(long id, DashBoard updatedDashBoard) {
         DashBoard existingDashBoard = getDashBoardById(id);
         existingDashBoard.setPeriod(updatedDashBoard.getPeriod());
         existingDashBoard.setStatus(updatedDashBoard.getStatus());
         existingDashBoard.setAction(updatedDashBoard.getAction());
         existingDashBoard.setEmployeeId(updatedDashBoard.getEmployeeId());
         return dashBoardRepository.save(existingDashBoard);
     }

     @Override
     public void deleteDashBoard(long id) {
         dashBoardRepository.deleteById(id);
     }
 }
