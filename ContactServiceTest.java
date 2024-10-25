package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import grandstrand.contact.Contact;
import grandstrand.contact.ContactService;

class ContactServiceTest {
	private ContactService contactService;
	
	@BeforeEach
	public void setup() {
		contactService = new ContactService();
	}
	
	// Test adding a contact
	@Test
	public void testAddContact() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		assertTrue(contactService.addContact(contact));
		assertNotNull(contactService.getContact("1234567890"));
	}
	
	// Test adding a duplicate contact ID
	@Test
	public void testAddDuplicateID() {
		Contact contact1 = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		Contact contact2 = new Contact("1234567890", "Jason", "Ross", "0987654321", "456 Their Street");
		contactService.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
	}
	
	// Test deleting a contact
	@Test
	public void testDeleteContact() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contactService.addContact(contact);
		contactService.deleteContact("1234567890");
		assertNull(contactService.getContact("1234567890"));
	}
	
	// Test deleting a contact that doesn't exist
	@Test
	public void testDeleteNonExistentContact() {
		assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("0000000000"));
	}
	
	// Test updating first name
	@Test
	public void testUpdateFirstName() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contactService.addContact(contact);
		contactService.updateContactFirstName("1234567890", "Jason");
		assertEquals("Jason", contactService.getContact("1234567890").getFirstName());
	}
	
	// Test updating last name
	@Test
	public void testUpdateLastName() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contactService.addContact(contact);
		contactService.updateContactLastName("1234567890", "McKee");	
		assertEquals("McKee", contactService.getContact("1234567890").getLastName());
	}
	
	// Test updating phone number
	@Test
	public void testUpdatePhone() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contactService.addContact(contact);
		contactService.updateContactPhoneNumber("1234567890", "0987654321");
		assertEquals("0987654321", contactService.getContact("1234567890").getPhone());
	}
	
	// Test updating phone number with an invalid number less than 10 digits
    @Test
    public void testUpdateInvalidPhoneNumberTooShort() {
        Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactPhoneNumber("1234567890", "12345"));
    }
    
	// Test updating phone number with an invalid number more than 10 digits
    @Test
    public void testUpdateInvalidPhoneNumberTooLong() {
        Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactPhoneNumber("1234567890", "12345678901"));
    }
    
    // Test updating phone number with an invalid number with letters
    @Test
    public void testUpdateInvalidPhoneNumberWithLetters() {
        Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactPhoneNumber("1234567890", "12345abcde"));
    }
    
    // Test updating the phone number with an invalid number with special characters
    @Test
    public void testUpdateInvalidPhoneNumberWithSpecialCharacters() {
        Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactPhoneNumber("1234567890", "12345-6789"));
    }
	
	// Test updating address
	@Test
	public void testUpdateAddress() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contactService.addContact(contact);
		contactService.updateContactAddress("1234567890", "456 Their Street");
		assertEquals("456 Their Street", contactService.getContact("1234567890").getAddress());
	}
    
    // Test updating a non-existent contact
    @Test
    public void testUpdateNonExistentContact() {
    	assertThrows(IllegalArgumentException.class, () -> contactService.updateContactFirstName("0000000000", "Jason"));
    }
	
}
