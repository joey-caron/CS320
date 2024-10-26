package Test;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the unit test for the contact class
 *************************/

import static org.junit.jupiter.api.Assertions.*;

import Contact.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	

	@Test
	@DisplayName("Test an invalid first name")
	void testContactFirstName() { // tests to ensure a first name of over 10 characters returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("TooLongFirstName");
		});
	}
	
	
	@Test
	@DisplayName("Test an invalid null first name")
	void testNullFirstName() { // tests to ensure a null first name returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}
	
	
	@Test
	@DisplayName("Test an invalid last name")
	void testContactLastName() { // tests to ensure a last name of over 10 characters returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("TooLongLastName");
		});
	}
	
	@Test
	@DisplayName("Test an invalid null last name")
	void testNullLastName() { // tests to ensure a null last name returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
        	contact.setLastName(null);
        });
	}
	
	@Test
	@DisplayName("Test an invalid short phone number")
	void testContactShortPhone() { // tests to ensure a phone number with less than 10 characters returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
        	contact.setPhone("Phone");
        });
	}
	
	@Test
	@DisplayName("Test an invalid long phone number")
	void testContactLongPhone() { // tests to ensure a phone number with more than 10 characters returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
        	contact.setPhone("PhoneNumber");
        });
	}
	
	@Test
	@DisplayName("Test an invalid null phone number")
	void testContactNullPhone() { // tests to ensure a null phone number returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
        	contact.setPhone(null);
        });
	}
	
	@Test
	@DisplayName("Test an invalid address")
	void testContactAddress() { // tests to ensure an address of over 30 characters returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
        	contact.setAddress("ThisAddressIsWayTooLongBecauseThisIsATest");
        });
	}
	
	@Test
	@DisplayName("Test an invalid null address")
	void testContactNullAddress() { // tests to ensure a null address returns as invalid
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
        	contact.setAddress(null);
        });
	}

	@Test
	@DisplayName("Test contact ID getter")
	void testContactIdGetter() {
		Contact contact = new Contact("First", "Last", "1234567890", "Address");
		assertNotNull(contact.getContactId());
	}
	
	@Test
	@DisplayName("Test first name getter")
	void testFirstNameGetter() {
		Contact contact = new Contact("First", "Last", "1234567890", "Address");
		assertNotNull(contact.getFirstName());
	}
	
	@Test
	@DisplayName("Test last name getter")
	void testLastNameGetter() {
		Contact contact = new Contact("First", "Last", "1234567890", "Address");
		assertNotNull(contact.getLastName());
	}
	
	@Test
	@DisplayName("Test phone getter")
	void testPhoneGetter() {
		Contact contact = new Contact("First", "Last", "1234567890", "Address");
		assertNotNull(contact.getPhone());
	}
	
	@Test
	@DisplayName("Test address getter")
	void testAddressGetter() {
		Contact contact = new Contact("First", "Last", "1234567890", "Address");
		assertNotNull(contact.getAddress());
	}
	
}
