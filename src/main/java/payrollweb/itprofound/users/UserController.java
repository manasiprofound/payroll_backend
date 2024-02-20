package payrollweb.itprofound.users;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import payrollweb.itprofound.core.BaseController;
import payrollweb.itprofound.core.BasePageResponse;
import payrollweb.itprofound.core.BaseResponse;
import payrollweb.itprofound.models.Address;

@RestController
@RequestMapping(path = "/v3/user")
public class UserController extends BaseController{
private static final Logger logger =LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserServiceImpl userService;
	

	@GetMapping(path = "/all")
    public ResponseEntity<BaseResponse<HttpStatus, List<UserDto> >> getAll() {
		logger.debug("GET_USER_STARTED");
		try {
			List<UserDto> user = userService.getAll();
			logger.debug("GET_USER_SUCCESS");
			return this.prepareResponse(true, "GET_USER_SUCCESS", user, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("GET_RESTAURANT_FAILED", ex);
			return this.prepareResponse(false, "GET_RUSER_FAILED", null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "")
    public ResponseEntity<BaseResponse<HttpStatus, BasePageResponse<UserDto>>> getPaginated(@PageableDefault(page = 0,
            size = 10) @SortDefault.SortDefaults({@SortDefault(sort = "createdAt",
                    direction = Sort.Direction.ASC)}) Pageable pageable) {
    	logger.debug("GET_PAGINATED_USER_STARTED");
		try {		
			Page<UserDto> users = userService.getAll(pageable);
			logger.debug("GET_PAGINATED_USER_SUCCESS");
			return this.preparePagedResponse(true, "GET_PAGINATED_USER_SUCCESS", users, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("GET_PAGINATED_USER_FAILED", ex);
			return this.prepareResponse(false, "GET_PAGINATED_USER_FAILED", null, HttpStatus.BAD_REQUEST);
		}
		
    }
    

    @PostMapping(path = "")
    public ResponseEntity<BaseResponse<HttpStatus, UserDto>> createUser(@RequestBody  @Valid  UserDto userDto) {
        logger.debug("CREATE_USER_STARTED");
		try {
			UserDto user = userService.create(userDto);
			logger.debug("CREATE_USER_SUCCESS");
			return this.prepareResponse(true, "CREATE_USER_SUCCESS", user, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("CREATE_USER_FAILED", ex);
			return this.prepareResponse(false, "CREATE_USER_FAILED", null, HttpStatus.BAD_REQUEST);
		}
    }
    
	@PatchMapping(path = "/{userId}/address")
	public ResponseEntity<BaseResponse<HttpStatus, UserDto>> updateUserAddress(
			@PathVariable(name = "userId") String userId,
			@RequestBody @Valid List<Address> address) {
		logger.debug("UPDATE_USER_ADDRESS_STARTED");
		try {
			UserDto user = userService.getById(userId);
			user.setAddress(address);
			user = userService.update(userId, user);
			logger.debug("UPDATE_USER_ADDRESS_SUCCESS");
			return this.prepareResponse(true, "UPDATE_USER_ADDRESS_SUCCESS", user,
					HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("UPDATE_USER_ADDRESS_FAILED", ex);
			return this.prepareResponse(false, "UPDATE_USER_ADDRESS_FAILED", null,
					HttpStatus.BAD_REQUEST);
		}
	}


}
