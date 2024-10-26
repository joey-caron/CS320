package test;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the unit test for the appointment service class
 *************************/

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

import appointment.AppointmentService;


@TestMethodOrder(OrderAnnotation.class)
class AppointmentServiceTest {
	AppointmentService serviceTest = new AppointmentService();
	
	@Test
	@DisplayName("Test to ensure appointments can be added")
	@Order(1)
	void testAddAppointment() {
		Calendar calendar = Calendar.getInstance(); // Get current date
		calendar.add(Calendar.DAY_OF_MONTH, 20); // add 20 days to current date
		Date appointmentDate = calendar.getTime(); // change calendar class date to date class date
		serviceTest.addAppointment(appointmentDate, "Description");
		assertNotNull(serviceTest.appointmentMap.get("0"), "Appointment was not added correctly");
	}
	
	
	@Test
	@DisplayName("Test to ensure multiple appointments can be added")
	@Order(2)
	void testAddMultiple() { // tests adding multiple appointments
		serviceTest.addAppointment(new Date(), "Description");
		serviceTest.addAppointment(new Date(), "Second Description");
		serviceTest.addAppointment(new Date(), "Third Description");
		assertEquals(3, serviceTest.appointmentMap.size(), "Multiple appointments not added");
	}
	
	@Test
	@DisplayName("Test to ensure appointments can be deleted")
	@Order(3)
	void testDeleteAppointment() { // tests deleting appointments
		serviceTest.addAppointment(new Date(), "Description");
		serviceTest.addAppointment(new Date(), "Second Description");
		serviceTest.addAppointment(new Date(), "Third Description");
		serviceTest.deleteAppointment("5");
		assertNull(serviceTest.appointmentMap.get("5"), "Appointment not deleted");
	}
	
	@Test
	@DisplayName("Test to delete non-existant appointment")
	@Order(4)
	void testDeleteNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.deleteAppointment("12");
		});
	}

}
