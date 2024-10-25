package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import grandstrand.contact.Contact;

class ContactTest {
	// Test creation of a valid contact
	@Test
	public void testValidContactCreation() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		assertEquals("1234567890", contact.getContactID());
		assertEquals("Eric", contact.getFirstName());
		assertEquals("Ross", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 My Street", contact.getAddress());
	}
	
	// Test invalid contact ID length
	@Test
	public void testInvalidContactIDLength() {
		assertThrows(IllegalArgumentException.class, () ->
		new Contact("12345678901", "Eric", "Ross", "1234567890", "123 My Street"));
	}
	
	// Test invalid first name length
	@Test
	public void testInvalidFirstNameLength() {
		assertThrows(IllegalArgumentException.class, () ->
		new Contact("1234567890", "First Name is too long", "Ross", "1234567890", "123 My Street"));
	}
	
	// Test invalid last name length
	@Test
	public void testInvalidLastNameLength() {
		assertThrows(IllegalArgumentException.class, () ->
		new Contact("1234567890", "Eric", "Last Name is too long", "1234567890", "123 My Street"));
	}
	
	// Test invalid phone number with letters
    @Test
    public void testInvalidPhoneNumberWithLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Eric", "Ross", "12345abcde", "123 My Street");
        });
    }
    
    // Test invalid phone number with special characters
    @Test
    public void testInvalidPhoneNumberWithSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Eric", "Ross", "12345-6789", "123 My Street");
        });
    }
    
    // Test invalid phone number with less than 10 digits
    @Test
    public void testInvalidPhoneNumberTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Eric", "Ross", "12345", "123 My Street");
        });
    }
    
    // Test invalid phone number with more than 10 digits
    @Test
    public void testInvalidPhoneNumberTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Eric", "Ross", "12345678901", "123 My Street");
        });
    }
	
	// Test invalid address length
	@Test
	public void testInvalidAddressLength() {
		assertThrows(IllegalArgumentException.class, () ->
		new Contact("1234567890", "Eric", "Ross", "1234567890", "No way this can be a valid address"));
	}

	// Test to update valid first name
	@Test
	public void testSetValidFirstName() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contact.setFirstName("Travis");
		assertEquals("Travis", contact.getFirstName());
	}
	
	// Test setting an invalid first name
	@Test
	public void testSetInvalidFirstName() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		assertThrows(IllegalArgumentException.class, () -> {
		contact.setFirstName("First Name is Too Long");
		});
	}
	
	// Test to update valid last name
	@Test
	public void testSetValidLastName() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contact.setLastName("McKee");
		assertEquals("McKee", contact.getLastName());
	}
	
	// Test setting an invalid last name
	@Test
	public void testSetInvalidLastName() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		assertThrows(IllegalArgumentException.class, () -> {
		contact.setLastName("Last Name is Too Long");
		});
	}
	
	// Test to update valid phone number
	@Test
	public void testSetValidPhoneNumber() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contact.setPhone("0987654321");
		assertEquals("0987654321", contact.getPhone());
		}
	
	// Test setting an invalid phone number with letters
	@Test
    public void testSetInvalidPhoneNumberWithLetters() {
        Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345abcde");
        });
    }
	
    // Test setting an invalid phone number with special characters
    @Test
    public void testSetInvalidPhoneNumberWithSpecialCharacters() {
        Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345-6789");
        });
    }
	
	// Test to update valid address
	@Test
	public void testSetValidAddress() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		contact.setAddress("456 New Street");
		assertEquals("456 New Street", contact.getAddress());
	}
	
	// Test setting an invalid address
	@Test
	public void testSetInvalidAddress() {
		Contact contact = new Contact("1234567890", "Eric", "Ross", "1234567890", "123 My Street");
		assertThrows(IllegalArgumentException.class, () -> { 
		contact.setAddress("This has to be the longest address ever");
		});
	}
	
}
