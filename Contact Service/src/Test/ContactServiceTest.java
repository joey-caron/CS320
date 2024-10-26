package Test;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the unit test for the contact service class
 *************************/

import static org.junit.jupiter.api.Assertions.*;

import Contact.ContactService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;



@TestMethodOrder(OrderAnnotation.class)
class ContactServiceTest {
	ContactService serviceTest = new ContactService();
	@Test
	@DisplayName("Test to ensure contacts can be added")
	@Order(1)
	void testAddContact() { // tests adding a contact 
		serviceTest.addContact("Test", "McTestFace", "9080706050", "125 So Many Tests");
		assertNotNull(serviceTest.contactMap.get("0"), "Contact was not added correctly");
	}
	
	
	@Test
	@DisplayName("Test to edit First Name.")
	@Order(2)
	void testEditFirstName() { // tests editing the first name of a contact
		serviceTest.addContact("John", "Doe", "1234567890", "123 Fake Rd");
		serviceTest.editFirstName("1", "Jane");
		assertEquals("Jane", serviceTest.contactMap.get("1").getFirstName(), "First name not changed");
	}
	
	@Test
	@DisplayName("Test to edit Last Name.")
	@Order(3)
	void testEditLastName() { // tests editing the last name of the contact
		serviceTest.addContact("Frank", "Smith", "5555555555", "456 False Ln");
		serviceTest.editLastName("2", "Jones");
		assertEquals("Jones", serviceTest.contactMap.get("2").getLastName(), "Last name not changed");
	}
	
	@Test
	@DisplayName("Test to edit Phone number.")
	@Order(4)
	void testEditPhone() { // tests editing the phone number of the contact
		serviceTest.addContact("Jane", "Goodall", "9876543210", "789 Not Real Place");
		serviceTest.editPhone("3", "1020304050");
		assertEquals("1020304050", serviceTest.contactMap.get("3").getPhone(), "Phone number not changed");
	}
	
	@Test
	@DisplayName("Test to edit Address.")
	@Order(5)
	void testEditAddress() { // tests editing the address of the contact
		serviceTest.addContact("Juli", "Iacono", "1928374655", "753 Not Dr");
		serviceTest.editAddress("4", "98 Highway Rd");
		assertEquals("98 Highway Rd", serviceTest.contactMap.get("4").getAddress(), "Address not changed");
	}
	
	
	@Test
	@DisplayName("Test to ensure contact can be deleted")
	@Order(6)
	void testDeleteContact() { // tests deleting the contact from the list
		serviceTest.addContact("First", "Last", "PhoneNumbr", "Address");
		serviceTest.deleteContact("5");
		assertNull(serviceTest.contactMap.get("5"), "Contact not deleted");
	}
	
	@Test
	@DisplayName("Test to ensire multiple contacts can be added")
	@Order(7)
	void testAddMultiple() {
		serviceTest.addContact("Joseph", "Caron", "1234567890", "Address 123");
		serviceTest.addContact("Juli", "Iacono", "9876543210", "Address 7989");
		assertEquals(2, serviceTest.contactMap.size());
	}
	
	@Test
	@DisplayName("Test to attempt to delete non-existant contact")
	@Order(8)
	void testDeleteNull() {
		serviceTest.addContact("First", "Last", "1234567890", "Address");
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.deleteContact("12");
		});
	}
	
	@Test
	@DisplayName("Test to attempt to edit first name of non-existant contact")
	@Order(9)
	void testEditFirstNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.editFirstName("12", "FirstName");
		});
	}
	
	@Test
	@DisplayName("Test to attempt to edit last name of non-existant contact")
	@Order(10)
	void testEditLastNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.editLastName("12", "LastName");
		});
	}
	
	@Test
	@DisplayName("Test to attempt to edit phone of non-existant contact")
	@Order(11)
	void testEditPhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.editPhone("12", "9876543210");
		});
	}
	
	@Test
	@DisplayName("Test to attempt to edit address of non-existant contact")
	@Order(12)
	void testEditAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.editAddress("12", "New Address");
		});
	}

}
