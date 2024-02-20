package payrollweb.itprofound.users;


import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import payrollweb.itprofound.models.User;


public class UserInfoDetails implements UserDetails{

	private static final long serialVersionUID = 1L;

	private String name; 
	
	private String password; 
	
	private List<GrantedAuthority> authorities; 

	public UserInfoDetails(User userInfo) { 
		name = userInfo.getUserName(); 
		password = userInfo.getPassword(); 
		//authorities = userInfo.getRoles()!=null ? userInfo.getRoles().stream() 
		//		.map(SimpleGrantedAuthority::new) 
			//	.collect(Collectors.toList()) : List.of(); 
	} 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		return authorities; 
	} 

	@Override
	public String getPassword() { 
		return password; 
	} 

	@Override
	public String getUsername() { 
		return name; 
	} 

	@Override
	public boolean isAccountNonExpired() { 
		return true; 
	} 

	@Override
	public boolean isAccountNonLocked() { 
		return true; 
	} 

	@Override
	public boolean isCredentialsNonExpired() { 
		return true; 
	} 

	@Override
	public boolean isEnabled() { 
		return true; 
	} 
}

