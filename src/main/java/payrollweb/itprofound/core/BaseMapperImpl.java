package payrollweb.itprofound.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;


public abstract class BaseMapperImpl<E, M> implements BaseMapper<E, M> {

	@Override
	public void mapModelToEntity(E entity, M model) {
		BeanUtils.copyProperties(model, entity, "id", "code");
	}

	@Override
	public void mapEntityToModel(E entity, M model) {
		BeanUtils.copyProperties(entity, model);
	}

	@Override
	public List<M> mapEntityToModel(List<E> entities) {
		List<M> models = new ArrayList<M>();
		for (E entity : entities) {
			models.add(mapEntityToModel(entity));
		}
		return models;
	}

	@Override
	public List<E> mapModelToEntity(List<M> models) {
		List<E> entities = new ArrayList<E>();
		for (M model : models) {
			entities.add(mapModelToEntity(model));
		}
		return entities;
	}
}