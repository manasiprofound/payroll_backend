package payrollweb.itprofound.users;


public interface UserService {

	UserDto getByEmail(String email);

	UserDto getByUserName(String userName);

} 
