package payrollweb.itprofound.authentication;

import payrollweb.itprofound.models.Phone;

public class AuthRequest {

	    private String username; 

	    private String password;
		
	    private String email; 
	    
	    private Phone phone;
	    
	    private Phone pin;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Phone getPhone() {
			return phone;
		}

		public void setPhone(Phone phone) {
			this.phone = phone;
		}

		public Phone getPin() {
			return pin;
		}

		public void setPin(Phone pin) {
			this.pin = pin;
		}
		
}

