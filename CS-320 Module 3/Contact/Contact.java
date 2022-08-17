/**Brandon Hobbs
*  CS-320
*  July 16, 2022
*/

package Contact;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;	
	
	/**
	 * validates the contactID
	 * @param contactID
	 * @return bool
	 */
	private final boolean validateID(String contactID) {
		if(contactID == null || contactID.length() > 10) {
			return false;			
		}		
		return true;
	}
	
	/**
	 * validates the Last Name
	 * @param lastName
	 * @return bool
	 */
	private final boolean validateLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			return false;			
		}
		return true;
	}
	/**
	 * validates the first Name
	 * @param firstName
	 * @return bool
	 */
	private final boolean validateFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {	
			return false;			
		}
		return true;
	}
	/**
	 * validates the phone number
	 * @param phoneNumber
	 * @return bool
	 */
	private final boolean validatePhone(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length() != 10) {
			return false;			
		}
		return true;
	}
	/**
	 * validates the address
	 * @param address
	 * @return bool
	 */
	private final boolean validateAddress(String address) {
		if(address == null || address.length() > 30) {
			return false;			
		}
		return true;
	}
	
	public Contact(String contactID, 
			String firstName, 
			String lastName, 
			String phoneNumber, 
			String address) {
		
		if(!this.validateID(contactID)) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		
		if(!this.validateFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		if(!this.validateLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		if(!this.validatePhone(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		if(!this.validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}		
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getContactID() {
		return Integer.valueOf(contactID);
	}

	/*
	 * //set to private since this non-updateable private void setContactID(String
	 * contactID) { this.contactID = contactID; }
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(!this.validateFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(!this.validateLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(!this.validatePhone(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(!this.validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}	
		this.address = address;
	}

}
