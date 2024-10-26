package appointment;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the appointment service class. It maintains a map of appointments 
 * and can add or delete appointments
 *************************/

import java.util.Map;
import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
	String appointmentId;
	
	public Map <String, Appointment> appointmentMap = new HashMap<>(); // create hash map to hold all appointments
	
	public void addAppointment(Date appointmentDate, String description) { // method to add appointment to map
		
		Appointment appointment = new Appointment(appointmentDate, description); // creates a new appointment object
		appointmentId = appointment.getAppointmentId();
		if (appointmentMap.get(appointmentId) != null) { // throwing exception if appointment id is not unique
			throw new IllegalArgumentException("Appointment ID already in use");
		}
		appointmentMap.put(appointmentId, appointment); // add appointment to map
		
	}
	
	public void deleteAppointment(String appointmentId) { // deletes appointments from map
		if (!appointmentMap.containsKey(appointmentId)) { // throwing exception if appointment is not found
			throw new IllegalArgumentException("Appointment not found");
		}
		appointmentMap.remove(appointmentId); // removes appointment from map
	}

}
