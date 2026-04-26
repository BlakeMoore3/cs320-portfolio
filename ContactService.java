package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID must be unique");
		}
		
		contacts.put(contact.getContactId(), contact);
	}
	
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}
		
		contacts.remove(contactId);
	}
	
	public void updateFirstName(String contactId, String firstName) {
		Contact contact = findContact(contactId);
		contact.setFirstName(firstName);
	}
	
	public void updateLastName(String contactId, String lastName) {
		Contact contact = findContact(contactId);
		contact.setLastName(lastName);
	}
	
	public void updatePhone(String contactId, String phone) {
		Contact contact = findContact(contactId);
		contact.setPhone(phone);
	}
	
	public void updateAdress(String contactId, String address) {
		Contact contact = findContact(contactId);
		contact.setAddress(address);
	}
	
	private Contact findContact(String contactId) {
		if (!contacts.containsKey(contactId))  {
			throw new IllegalArgumentException("Contact not found");
		}
		return contacts.get(contactId);
	}
	
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}
