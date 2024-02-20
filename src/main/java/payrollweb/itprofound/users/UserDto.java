package payrollweb.itprofound.users;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import payrollweb.itprofound.models.Address;
import payrollweb.itprofound.models.Phone;

public class UserDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String id;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private int code;

	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	private Phone phone;
	
	private List<Address> address;
	
	//private List<String> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	

}

