package payrollweb.itprofound.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import payrollweb.itprofound.exception.ResourceNotFoundException;
import payrollweb.itprofound.models.BaseModel;

public abstract class BaseServiceImpl<E extends BaseModel, M, T> implements BaseService<M, T> {

	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	@Autowired
	protected BaseRepository<E, T> baseRepository;

	@Autowired
	protected BaseMapper<E, M> mapper;

	@Autowired
	protected BaseRule<E> baseRule;

	@Override
	public List<M> getAll() {
		logger.debug("GET_SERVICE_STARTED");
		List<E> entities = baseRepository.findByDeleted(false);
		List<M> models = mapper.mapEntityToModel(entities);
		logger.debug("GET_SERVICE_SUCCESS");
		return models;
	}

	@Override
	public Page<M> getAll(Pageable pageable) {
		logger.debug("GET_PAGEABLE_SERVICE_STARTED");
		Page<E> entities = baseRepository.findAll(pageable);
		List<M> models = mapper.mapEntityToModel(entities.getContent());
		Page<M> pagable = new PageImpl<M>(models, pageable, entities.getTotalElements());
		logger.debug("GET_PAGEABLE_SERVICE_SUCCESS");
		return pagable;
	}

	@Override
	public M getById(T id) {
		logger.debug("GET_BY_ID_SERVICE_STARTED");
		Optional<E> entity = baseRepository.findById(id);
		if (!entity.isPresent()) {
			throw new ResourceNotFoundException("Resource Not Found");
		}
		M model = mapper.mapEntityToModel(entity.get());
		logger.debug("GET_BY_ID_SERVICE_SUCCESS");
		return model;
	}

	@Override
	public M create(M model) {
		logger.debug("CREATE_SERVICE_STARTED");
		E entity = mapper.mapModelToEntity(model);
		entity = baseRepository.save(entity);
		model = mapper.mapEntityToModel(entity);
		logger.debug("CREATE_SERVICE_SUCCESS");
		return model;
	}

	@Override
	public M update(T t, M model) {
		logger.debug("UPDATE_SERVICE_STARTED");
		E entity = baseRepository.findById(t).get();
		if (entity == null) {
			throw new ResourceNotFoundException("Not found");
		}
		mapper.mapModelToEntity(entity, model);
		entity = baseRepository.save(entity);
		model = mapper.mapEntityToModel(entity);
		logger.debug("UPDATE_SERVICE_SUCCESS");
		return model;
	}

	@Override
	public M delete(T id) {
		logger.debug("DELETE_SERVICE_STARTED");
		E entity = baseRepository.findById(id).get();
		if (entity == null) {
			throw new ResourceNotFoundException("Not found");
		}
		entity.setDeleted(true);
		entity = baseRepository.save(entity);
		M model = mapper.mapEntityToModel(entity);
		logger.debug("DELETE_SERVICE_SUCCESS");
		return model;
	}

	@Override
	public List<M> delete(List<T> ids) {
		logger.debug("DELETE_MULTIPLE_SERVICE_STARTED");
		List<E> entities = baseRepository.findByIdIn(ids);
		//entities.stream().forEach(entity -> entity.setDeleted(true));
		entities = baseRepository.saveAll(entities);
		List<M> models = mapper.mapEntityToModel(entities);
		logger.debug("DELETE_MULTIPLE_SERVICE_SUCCESS");
		return models;
	}

	@Override
	public List<M> create(List<M> models) {
		logger.debug("CREATE_MULTIPLE_SERVICE_STARTED");
		List<E> entities = mapper.mapModelToEntity(models);
		entities = baseRepository.saveAll(entities);
		List<M> insertedModels = new ArrayList<>();
		models = mapper.mapEntityToModel(entities);
		logger.debug("CREATE_MULTIPLE_SERVICE_SUCCESS");
		return insertedModels;
	}
}
