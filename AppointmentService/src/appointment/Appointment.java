package appointment;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the appointment class. It creates and stores appointment information.
 *************************/

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {
	
	private final String appointmentId;
	private Date appointmentDate;
	private String description;
	private static AtomicLong newAppointmentId = new AtomicLong(0);
	private String tempId;
	
	public Appointment(Date appointmentDate, String description) {
		tempId = String.valueOf(newAppointmentId.getAndIncrement());
		if (tempId == null || tempId.isEmpty() || tempId.length() > 10) { // throwing exception for invalid appointment id
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		this.appointmentId = tempId; // setting appointment id
		setDate(appointmentDate); // calls method to set date
		setDescription(description); // calls method to set description
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setDate(Date appointmentDate) {
		if (appointmentDate == null || appointmentDate.before(new Date())) { // throwing exception for invalid date
			throw new IllegalArgumentException("Invalid appointment date");
		}
		this.appointmentDate = appointmentDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if (description == null || description.isEmpty() || description.length() > 50) { // throwing exception for invalid description
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		this.description = description;
	}
}
