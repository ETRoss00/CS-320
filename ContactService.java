package grandstrand.contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	// Hash map to store contacts
	private Map<String, Contact> contacts;
	
	// Constructor to initialize service
	public ContactService() {
		contacts = new HashMap<>();
	}
	
	// Add a new contact
	public boolean addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact ID Already Exists");
		}
		contacts.put(contact.getContactID(), contact);
		return true;
	}
	
	// Delete a contact 
	public void deleteContact(String contactID) {
		if(!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID Not Found");
		}
		contacts.remove(contactID);
	}
	
	// Retrieve contact by ID
		public Contact getContact(String contactID) {
			return contacts.get(contactID);
		}
	
	// Update first name
	public void updateContactFirstName(String contactID, String newFirstName) {
		Contact contact = getContact(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Contact ID Not Found");
		}
		contact.setFirstName(newFirstName);
	}
	
	// Update last name
		public void updateContactLastName(String contactID, String newLastName) {
			Contact contact = getContact(contactID);
			if (contact == null) {
				throw new IllegalArgumentException("Contact ID Not Found");
			}
			contact.setLastName(newLastName);
		}
		
	// Update phone number
		public void updateContactPhoneNumber(String contactID, String newPhone) {
			Contact contact = getContact(contactID);
			if (contact == null) {
				throw new IllegalArgumentException("Contact ID Not Found");
			}
			contact.setPhone(newPhone);
		}
		
	// Update address
		public void updateContactAddress(String contactID, String newAddress) {
			Contact contact = getContact(contactID);
			if (contact == null) {
				throw new IllegalArgumentException("Contact ID Not Found");
			}
			contact.setAddress(newAddress);
		}
}
