package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

	@Test
	public void testValidContactCreation() {
		Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");
		assertEquals("12345", contact.getContactId());
		assertEquals("Blake", contact.getFirstName());
		assertEquals("Moore", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("100 Random Rd", contact.getAddress());
	}
	
	@Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Blake", "Moore", "1234567890", "100 Random Rd");
        });
    }

    @Test
    public void testContactIdCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Blake", "Moore", "1234567890", "100 Random Rd");
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Moore", "1234567890", "100 Random Rd");
        });
    }

    @Test
    public void testFirstNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "VeryLongName", "Moore", "1234567890", "100 Random Rd");
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Blake", null, "1234567890", "100 Random Rd");
        });
    }

    @Test
    public void testLastNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Blake", "VeryLongName", "1234567890", "100 Random Rd");
        });
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Blake", "Moore", null, "100 Random Rd");
        });
    }

    @Test
    public void testPhoneMustBeExactly10Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Blake", "Moore", "12345", "100 Random Rd");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Blake", "Moore", "1234567890", null);
        });
    }

    @Test
    public void testAddressCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Blake", "Moore", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");
        contact.setFirstName("Bob");
        assertEquals("Bob", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("12345", "Blake", "Moore", "1234567890", "100 Random Rd");
        contact.setAddress("200 Rainbow Rd");
        assertEquals("200 Rainbow Rd", contact.getAddress());
    }

}
