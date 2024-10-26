package Contact;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the contact service class.  It maintains a list of contacts and has capabilities
 * for adding and deleting contacts, as well as updating first name, last name, phone number, and address.
 *************************/

import java.util.Map;
import java.util.HashMap;


public class ContactService {
	String contactId;
	
	public Map<String, Contact> contactMap = new HashMap<>(); // creating the map to hold the contacts
	
	public void addContact(String firstName, String lastName, String phone, String address) { // method to add contact to map

		Contact contact = new Contact(firstName, lastName, phone, address); //creates a contact
		
		contactId = contact.getContactId();
		if (contactMap.get(contactId) != null) { // throwing exception if contact id is not unique
			throw new IllegalArgumentException("Contact ID already in use");
		}
		contactMap.put(contactId, contact); // add contact to map
		
	}
	
	
	public void deleteContact(String contactId) { // method to delete contact from array
		if (!contactMap.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}
		contactMap.remove(contactId);
	}
		
	public void editFirstName(String contactId, String firstName) { //method to edit first name of contact
		if (!contactMap.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}
		contactMap.get(contactId).setFirstName(firstName);
	}
	
	public void editLastName(String contactId, String lastName) { // method to edit last name of contact
		if (!contactMap.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}	
		contactMap.get(contactId).setLastName(lastName);
	}
	
	public void editPhone(String contactId, String phone) { // method to edit phone number of contact
		if (!contactMap.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}	
		contactMap.get(contactId).setPhone(phone);
	}
	
	public void editAddress(String contactId, String address) { // method to edit address of contact
		if (!contactMap.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}
		contactMap.get(contactId).setAddress(address);
	}

}
