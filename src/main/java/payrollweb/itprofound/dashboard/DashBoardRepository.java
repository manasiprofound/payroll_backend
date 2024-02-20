package payrollweb.itprofound.dashboard;

import org.springframework.data.mongodb.repository.MongoRepository;
import payrollweb.itprofound.models.DashBoard;

public interface DashBoardRepository extends MongoRepository<DashBoard, Long> {
	
}


