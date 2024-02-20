package payrollweb.itprofound.core;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<M, T> {
	M create(M model);
	M update(T t, M model);
	M delete(T id);
	M getById(T id);
	List<M> getAll();
	Page<M> getAll(Pageable pageable);
	List<M> create(List<M> models);
	List<M> delete(List<T> ids);
}