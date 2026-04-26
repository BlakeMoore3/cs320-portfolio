package contact;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	@Test
	public void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");
		
		service.addContact(contact);
		
		assertEquals(contact, service.getContact("12345"));
	}
	
	 @Test
	    public void testAddDuplicateContact() {
	        ContactService service = new ContactService();

	        Contact c1 = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");
	        Contact c2 = new Contact("12345", "Bob", "Smith", "0987654321", "456 Oak Street");

	        service.addContact(c1);

	        assertThrows(IllegalArgumentException.class, () -> {
	            service.addContact(c2);
	        });
	    }

	    @Test
	    public void testDeleteContact() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");

	        service.addContact(contact);
	        service.deleteContact("12345");

	        assertNull(service.getContact("12345"));
	    }

	    @Test
	    public void testUpdateFirstName() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");

	        service.addContact(contact);
	        service.updateFirstName("12345", "Bob");

	        assertEquals("Bob", service.getContact("12345").getFirstName());
	    }

	    @Test
	    public void testUpdatePhone() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");

	        service.addContact(contact);
	        service.updatePhone("12345", "0987654321");

	        assertEquals("0987654321", service.getContact("12345").getPhone());
	    }

}
