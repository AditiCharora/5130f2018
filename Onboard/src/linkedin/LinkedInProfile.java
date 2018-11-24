package linkedin;

public class LinkedInProfile {
	 private String firstName;

	 private String lastName;

	 private String token;
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

	public String getAccessToken() {
		return token;
	}
	public void setAccessToken(String token) {
		this.token=token;
	}


}
