/**Brandon Hobbs
*  CS-320
*  July 16, 2022
*/

package Contact;


import java.util.List;
import java.util.ArrayList;


public class ContactService {
	
	int currentIDNum = 0; //pseudo GUID

	//create new arraylist to hold the objects
	public static List<Contact> contactList = new ArrayList<Contact>();
	
	/**
	 * adds a contact at the system controlled index id
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param address
	 */
	public void addContact(String firstName, String lastName,
			String phoneNumber, String address) {
		
		String stringID = Integer.toString(currentIDNum);
		
		Contact newContact = new Contact(stringID, firstName, lastName, phoneNumber, address);
		contactList.add(newContact.getContactID(),newContact);
		
		//increment the ID NUM
		++currentIDNum;

	}
	
	/**
	 * Deletes the contact as the index ID
	 * @param ID
	 */	
	public void deleteContact(String ID) {
		int intID = Integer.valueOf(ID);


		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == intID) {
				contactList.remove(i);
			}
		}
	}
	
	/**
	 * Edits the First Name of the Contact Object at contactID
	 * Uses the setFirstName method
	 * @param contactID
	 * @param firstName
	 */
	public void editFirstName(String contactID, String firstName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setFirstName(firstName);				
			}			
		}	
	}
	
	/**
	 * Edits the Lame Name of the Contact Object at contactID
	 * Uses the setLastName method
	 * @param contactID
	 * @param lastName
	 */
	public void editLastName(String contactID, String lastName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setLastName(lastName);				
			}			
		}	
	}
	public void editNumber(String contactID, String phoneNumber) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setPhoneNumber(phoneNumber);				
			}			
		}	
	}
	public void editAddress(String contactID, String address) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setAddress(address);				
			}			
		}	
	}

}
