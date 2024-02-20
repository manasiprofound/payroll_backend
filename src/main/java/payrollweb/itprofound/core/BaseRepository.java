package payrollweb.itprofound.core;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <E, T> extends MongoRepository<E, T> {

	List<E> findByDeleted(boolean deleted);

	List<E> findByIdIn(List<T> ids);


}
