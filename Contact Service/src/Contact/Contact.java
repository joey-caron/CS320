package Contact;


import java.util.concurrent.atomic.AtomicLong;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the contact class. It creates and stores contact information.
 *************************/


public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private static AtomicLong newContactId = new AtomicLong(0);
	private String tempId;
	
	public Contact(String firstName, String lastName, String phone, String address) {
		tempId = String.valueOf(newContactId.getAndIncrement());
		if (tempId == null || tempId.isEmpty() || tempId.length() > 10) { // throwing exception for invalid contact id
			throw new IllegalArgumentException("Invalid contact ID");
		}
		this.contactId = tempId;
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
		
	}
	
	public String getContactId() { // method to return contact id
		return contactId;
	}
	
	public String getFirstName() { // method to return first name
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty() || firstName.length() > 10) { // throwing exception for invalid first name
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() { // method to return last name
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty() || lastName.length() > 10) { // throwing exception for invalid last name
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	
	public String getPhone() { //method to return phone number
		return phone;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.isEmpty() || phone.length() != 10) { // throwing exception for invalid phone number
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone;
	}
	
	public String getAddress() { //method to return address
		return address;
	}
	
	public void setAddress(String address) {
		if (address == null || address.isEmpty() || address.length() > 30) { // throwing exception for invalid address
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}

}
