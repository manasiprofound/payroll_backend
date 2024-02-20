package payrollweb.itprofound.contractTimeLine;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import payrollweb.itprofound.models.ContractTimeLine;

@Repository
public interface ContractTimeLineRepository extends MongoRepository<ContractTimeLine, Long> {

}

