/*
 * Brandon Hobbs
 * CS-320
 * July 26, 2022
 */

package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import AppointmentClass.AppointmentService;
import org.junit.jupiter.api.DisplayName;

class ApptServiceTests {

	@AfterEach
	void tearDown() throws Exception {
		AppointmentService.appointments.clear();
	}

	@DisplayName("Add an Appointment")
	@Test
	void testAddUniqueAppt() {
		String id = "0";
		String description = "This is a good description";
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);

		Date goodDate = c.getTime();

		AppointmentService tempAppt = new AppointmentService();

		assertEquals(0, AppointmentService.appointments.size());

		tempAppt.addUniqueAppointment(goodDate, description);

		assertTrue(AppointmentService.appointments.containsKey(id));
		assertEquals(goodDate, AppointmentService.appointments.get(id).getDate());
		assertEquals(description, AppointmentService.appointments.get(id).getDescription());

	}
	
	@DisplayName("Add a bad Appointment w/ empty desc")
	@Test
	void testAddEmptyDesc() {
		String id = "0";
		String description = ""; //bad description
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);

		Date goodDate = c.getTime();

      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      		AppointmentService tempAppt = new AppointmentService();
      		tempAppt.addUniqueAppointment(goodDate, description);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());

	}
	
	@DisplayName("Add a bad Appointment w/ null desc")
	@Test
	void testAddNullDesc() {
		String id = "0";
		String description = null; //bad description
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);

		Date goodDate = c.getTime();

      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      		AppointmentService tempAppt = new AppointmentService();
      		tempAppt.addUniqueAppointment(goodDate, description);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());

	}

	/*
	 * Add 3 contacts via addAppt delete object at id 1 check that there is no
	 * object there
	 */
	@DisplayName("Test deleteAppt")
	@Test
	void testDeleteAppt() {

		String id = "0";
		String description = "This is a good description";
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);

		Date goodDate = c.getTime();

		AppointmentService tempAppt = new AppointmentService();

		assertEquals(0, AppointmentService.appointments.size());

		tempAppt.addUniqueAppointment(goodDate, description); // obj 0
		tempAppt.addUniqueAppointment(goodDate, description); // obj 1
		tempAppt.addUniqueAppointment(goodDate, description); // obj 2

		assertEquals(3, AppointmentService.appointments.size());

		tempAppt.deleteAppointment("1");

		assertEquals(2, AppointmentService.appointments.size());
		assertFalse(AppointmentService.appointments.containsKey("1"));
		
		tempAppt.deleteAppointment("1");
		assertEquals(2, AppointmentService.appointments.size());

	}
	/*
	 * create an appt and then update with good id
	 * 
	 * @DisplayName("Test updateAppt with a good ID")
	 * 
	 * @Test void testUpdateappointments() { String id = "0"; String description =
	 * "This is a good description"; Calendar c = Calendar.getInstance();
	 * 
	 * c.set(Calendar.MONTH, 11); c.set(Calendar.DATE, 05); c.set(Calendar.YEAR,
	 * 2025);
	 * 
	 * Date goodDate = c.getTime();
	 * 
	 * AppointmentService tempAppt = new AppointmentService();
	 * 
	 * tempAppt.addUniqueAppointment(goodDate, description); //obj 0
	 * 
	 * tempAppt.updateAppointment("0", goodDate, "New description");
	 * assertEquals("New description",
	 * AppointmentService.appointments.get(id).getDescription());
	 * assertEquals(goodDate, AppointmentService.appointments.get(id).getDate());
	 * 
	 * }
	 */

	/*
	 * create an appt and then update with bad id
	 */
	/*
	 * @DisplayName("Test updateTask with a bad ID")
	 * 
	 * @Test void testBadUpdateappointments() { String id = "0"; String description
	 * = "This is a good description"; Calendar c = Calendar.getInstance();
	 * 
	 * c.set(Calendar.MONTH, 11); c.set(Calendar.DATE, 05); c.set(Calendar.YEAR,
	 * 2025);
	 * 
	 * Date goodDate = c.getTime();
	 * 
	 * AppointmentService tempAppt = new AppointmentService();
	 * 
	 * tempAppt.addUniqueAppointment(goodDate, description); // obj 0
	 * 
	 * tempAppt.updateAppointment("1", goodDate, "New description"); // bad ID
	 * assertNotEquals("New description",
	 * AppointmentService.appointments.get(id).getDescription());
	 * assertEquals(goodDate, AppointmentService.appointments.get(id).getDate());
	 * 
	 * }
	 */

}
