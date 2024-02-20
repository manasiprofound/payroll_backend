package payrollweb.itprofound.authentication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import payrollweb.itprofound.core.BaseController;
import payrollweb.itprofound.core.BaseResponse;
import payrollweb.itprofound.exception.ResourceNotFoundException;
import payrollweb.itprofound.security.JwtService;
import payrollweb.itprofound.users.UserDto;
import payrollweb.itprofound.users.UserServiceImpl;

@RestController
@RequestMapping(path = "/v3/auth")
public class AuthenticationController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<BaseResponse<HttpStatus, String>> login(@RequestBody AuthRequest authRequest) {
		logger.debug("AUTHENTICATE_STARTED");
		try {
			if (authRequest.getUsername() == null) {
				if (authRequest.getEmail() == null) {
					throw new UsernameNotFoundException("Username or Email is required");
				} else {
					authRequest.setUsername(userService.getByEmail(authRequest.getEmail()).getUserName());
				}
			}

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

			if (authentication.isAuthenticated()) {
				logger.debug("AUTHENTICATE_SUCCESS");
				return this.prepareResponse(true, "AUTHENTICATE_SUCCESS",
						jwtService.generateToken(authRequest.getUsername()), HttpStatus.OK);
			} else {
				return this.prepareResponse(false, "AUTHENTICATE_FAILED", "Invalid username or password",
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception ex) {
			logger.error("AUTHENTICATE_FAILED", ex);
			return this.prepareResponse(false, "GET_AUTHENTICATE_FAILED", ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<BaseResponse<HttpStatus, UserDto>> register(@RequestBody UserDto userNewDto) {
		logger.debug("REGISTER_STARTED");
		try {
			UserDto user = userService.create(userNewDto);
			logger.debug("REGISTER_SUCCESS");
			return this.prepareResponse(true, "REGISTER_SUCCESS", user, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("REGISTER_FAILED", ex);
			return this.prepareResponse(false, "REGISTER_FAILED", null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/profile")
	public ResponseEntity<BaseResponse<HttpStatus, UserDto>> userProfile(
			@RequestHeader(name = HttpHeaders.AUTHORIZATION) String authorization) {
		logger.debug("PROFILE_STARTED");
		try {
			String token = authorization.substring(7);
			String userName = jwtService.extractUsername(token);
			UserDto data = userService.getByUserName(userName);
			return this.prepareResponse(true, "PROFILE_SUCCESS",data , HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("PROFILE_FAILED", ex);
			return this.prepareResponse(false, "PROFILE_FAILED", null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/user/validate")
	public ResponseEntity<BaseResponse<HttpStatus, UserDto>> getUser(@RequestBody UserDto userDto) {
		logger.debug("VALIDATE_USER_STARTED");
		try {
			UserDto user = userService.getByEmail(userDto.getEmail());
			logger.debug("VALIDATE_USER_SUCCESS");
			return this.prepareResponse(true, "VALIDATE_USER_SUCCESS", user, HttpStatus.OK);
		} catch (ResourceNotFoundException ex) {
			return this.prepareResponse(false, ex.getMessage(), null, HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			logger.error("VALIDATE_USER_FAILED", ex);
			return this.prepareResponse(false, "VALIDATE_USER_FAILED", null, HttpStatus.BAD_REQUEST);
		}
	}
}

