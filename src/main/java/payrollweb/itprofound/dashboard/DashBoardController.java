package payrollweb.itprofound.dashboard;

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
import payrollweb.itprofound.models.DashBoard;
	   
@RestController
@RequestMapping("/dashboard")
public class DashBoardController {

	        @Autowired
	        private DashBoardService dashBoardService;

	        @PostMapping
	        public ResponseEntity<DashBoard> createDashBoard(@RequestBody DashBoard dashBoard) {
	            DashBoard createdDashBoard = dashBoardService.createDashBoard(dashBoard);
	            return new ResponseEntity<>(createdDashBoard, HttpStatus.CREATED);
	        }
	      
	        @GetMapping("/{id}")
	        public ResponseEntity<DashBoard> getDashBoardById(@PathVariable("id") long id) {
	            DashBoard dashBoard = dashBoardService.getDashBoardById(id);
	            return new ResponseEntity<>(dashBoard, HttpStatus.OK);
	        }

	        @GetMapping
	        public ResponseEntity<List<DashBoard>> getAllDashBoards() {
	            List<DashBoard> dashBoards = dashBoardService.getAllDashBoards();
	            return new ResponseEntity<>(dashBoards, HttpStatus.OK);
	        }

	        @PutMapping("/{id}")
	        public ResponseEntity<DashBoard> updateDashBoard(@PathVariable("id") long id, @RequestBody DashBoard updatedDashBoard) {
	            DashBoard dashBoard = dashBoardService.updateDashBoard(id, updatedDashBoard);
	            return new ResponseEntity<>(dashBoard, HttpStatus.OK);
	        }

	        @DeleteMapping("/{id}")
	        public ResponseEntity<Void> deleteDashBoard(@PathVariable("id") long id) {
	            dashBoardService.deleteDashBoard(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	    
}
