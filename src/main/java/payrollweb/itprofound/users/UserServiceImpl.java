package payrollweb.itprofound.users;


import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import payrollweb.itprofound.core.BaseServiceImpl;
import payrollweb.itprofound.exception.ResourceNotFoundException;
import payrollweb.itprofound.models.User;
import payrollweb.itprofound.utils.RandomString;
import payrollweb.itprofound.utils.SequenceGeneratorService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDto, String> implements UserService, UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
    public static final String USER_SEQUENCE = "USER_SEQUENCE";
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private UserRepository repository; 

	@Autowired
	private PasswordEncoder encoder; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 

		Optional<User> userDetail = repository.findByUserName(username); 

		// Converting userDetail to UserDetails 
		return userDetail.map(UserInfoDetails::new) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	} 
	
	@Override
	public UserDto getByEmail(String email){ 
		logger.debug("GET_BY_EMAIL_SERVICE_STARTED");
        Optional<User> entity = repository.findByEmail(email);
        if (!entity.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found");
        }
        UserDto model = mapper.mapEntityToModel(entity.get());
        logger.debug("GET_BY_EMAIL_SERVICE_SUCCESS");
        return model;
		
	}
	
	@Override
	public UserDto getByUserName(String userName){ 
		logger.debug("GET_BY_USER_NAME_SERVICE_STARTED");
        Optional<User> entity = repository.findByUserName(userName);
        if (!entity.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found");
        }
        UserDto model = mapper.mapEntityToModel(entity.get());
        logger.debug("GET_BY_USER_NAME_SERVICE_SUCCESS");
        return model;
		
	}
	
	@Override
    public UserDto create(UserDto newDto) {
		newDto.setCode(sequenceGeneratorService.generateSequence(USER_SEQUENCE));
		newDto.setPassword(encoder.encode(newDto.getPassword())); 
		newDto.setUserName(RandomString.randomString(RandomString.CHARSET_AZ_09, 10)); 
		//newDto.setRoles(List.of("ROLE_USER")); 
		return super.create(newDto);
	}
}


