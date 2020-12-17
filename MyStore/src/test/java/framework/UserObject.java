package framework;

import java.util.HashMap;

public class UserObject {
	String firstName;
	String lastName;
	String email;
	String password;
	String houseNumber;
	String street;
	String city;
	String state;
	String postalCode;
	String country;
	String mobilePhone;
	String homePhone;
	String addressAlias;
	
	public UserObject(HashMap<String, String> data) {
		this.firstName = data.get("firstName");
		this.lastName = data.get("lastName");
		this.email = data.get("email");
		this.password = data.get("password");
		this.houseNumber = data.get("houseNumber");
		this.street = data.get("street");
		this.city = data.get("city");
		this.state = data.get("state");
		this.postalCode = data.get("postalCode");
		this.country = data.get("country");
		this.mobilePhone = data.get("mobilePhone");
		this.homePhone = data.get("homePhone");
		this.addressAlias = data.get("addressAlias");
	}

}
