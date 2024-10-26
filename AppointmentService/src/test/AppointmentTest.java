package test;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the unit test for the appointment class
 *************************/

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

public class AppointmentTest {

	Appointment appointment = new Appointment(new Date(), "Description");
	
	@Test
	@DisplayName("Test an invalid date")
	void testAppointmentDate() { // tests to ensure a date earlier than current date returns as invalid
		
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDate(new Date(25L));
		});
	}
	
	@Test
	@DisplayName("Test an invalid null date")
	void testNullDate() { // tests to ensure a null date returns as invalid
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDate(null);
		});
	}
	
	
	@Test
	@DisplayName("Test an invalid description")
	void testTaskDescription() { // tests to ensure a description of over 50 characters returns as invalid
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription("HolyMolyThisDescriptionIsWayTooLongWowICannotBelieveIt");
		});
	}
	
	@Test
	@DisplayName("Test an invalid null description")
	void testNullDescription() { // tests to ensure a null description returns as invalid
		assertThrows(IllegalArgumentException.class, () -> {
        	appointment.setDescription(null);
        });
	}
	
	@Test
	@DisplayName("Test appointment ID getter")
	void testIdGetter() { // tests that getting appointment id works
		assertNotNull(appointment.getAppointmentId());
	}
	
	@Test
	@DisplayName("Test date getter")
	void testNameGetter() { // tests that getting date works
		assertNotNull(appointment.getAppointmentDate());
	}
	
	@Test
	@DisplayName("Test description getter")
	void testDescriptionGetter() { // tests that getting description works
		assertNotNull(appointment.getDescription());
	}
	
}
