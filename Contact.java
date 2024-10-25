package grandstrand.contact;

public class Contact {
	// Contact attributes
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor to initialize the contact object with requirements
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if (!validateInput(contactID, 10)) {
			throw new IllegalArgumentException ("Invalid contact ID");
		}
		if (!validateInput(firstName, 10)) {
			throw new IllegalArgumentException ("Invalid First Name");
		}
		if (!validateInput(lastName, 10)) {
			throw new IllegalArgumentException ("Invalid Last Name");
		}
		if (!validatePhone(phone)) {
			throw new IllegalArgumentException ("Invalid Phone Number");
		}
		if (!validateInput(address, 30)) {
			throw new IllegalArgumentException ("Invalid Address");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Validates input for first name, last name, and address
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}
	
	// Validates phone number
	private boolean validatePhone(String phone) {
		return (phone != null && phone.matches("\\d{10}"));
	}
	
	// Getters and setters for attributes
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (!validateInput(firstName, 10)) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (!validateInput(lastName, 10)) {
			throw new IllegalArgumentException ("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		if (!validatePhone(phone)) {
			throw new IllegalArgumentException ("Invalid Phone Number");
		}
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if (!validateInput(address, 30)) {
			throw new IllegalArgumentException ("Invalid Address");
		}
		this.address = address;
	}
	
}
