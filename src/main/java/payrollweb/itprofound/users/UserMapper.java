package payrollweb.itprofound.users;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import payrollweb.itprofound.core.BaseMapperImpl;
import payrollweb.itprofound.models.User;

@Component
public class UserMapper extends BaseMapperImpl<User, UserDto>{

	@Override
	public UserDto mapEntityToModel(User entity) {
		UserDto model = new UserDto();
		BeanUtils.copyProperties(entity, model);
		return model;
	}

	@Override
	public User mapModelToEntity(UserDto model) {
		User entity = new User();
		BeanUtils.copyProperties(model, entity);
		return entity;
	}
}
