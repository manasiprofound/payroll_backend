package payrollweb.itprofound.utils;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import payrollweb.itprofound.models.DatabaseSequence;

@Service
public class SequenceGeneratorService {


		private MongoOperations mongoOperations;

		@Autowired
		public SequenceGeneratorService(MongoOperations mongoOperations) {
			this.mongoOperations = mongoOperations;
		}

		public int generateSequence(String sequenceName) {
			DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(sequenceName)),
					new Update().inc("sequence", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
			return !Objects.isNull(counter) ? counter.getSequence() : 1;
		}
}

