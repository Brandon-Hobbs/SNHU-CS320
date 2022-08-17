/*
 * Brandon Hobbs
 * CS-320
 * July 26, 2022
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

import AppointmentClass.Appointment;

class AppointmentTest {


	@DisplayName("Test good constructor")
	@Test
	void testAppointment() {
        String id = "1";
        Calendar c = Calendar.getInstance();
        String description = "This is a good description";
        
      	c.set(Calendar.MONTH, 11);
      	c.set(Calendar.DATE, 05);
      	c.set(Calendar.YEAR, 2025);
      	
      	Date goodDate = c.getTime();
        
        Appointment tempAppt = new Appointment(id, goodDate, description);
        
        assertEquals(1, tempAppt.getUniqueID());
        assertEquals(goodDate, tempAppt.getDate());
        assertEquals(description, tempAppt.getDescription());       
        
	}
	

	@DisplayName("Test bad constructor id too long")
	@Test
	void testBadAppointment() {
        String id = "123456789101112";
      	Date date = new Date();
        String description = "This is a good description";
               
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, date, description);
        });
        
        assertEquals("Invalid ID", exception.getMessage());
        
	}
	
	@DisplayName("Test bad constructor id null")
	@Test
	void testBadIDNull() {
        String id = null;
      	Date date = new Date();
        String description = "This is a good description";
               
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, date, description);
        });
        
        assertEquals("Invalid ID", exception.getMessage());
        
	}
	
	@DisplayName("Test bad constructor past date")
	@Test
	void testBadDate() {
        String id = "1";
        Calendar c = Calendar.getInstance();
      	String description = "This is a good description";
      	
      	c.set(Calendar.MONTH, 11);
      	c.set(Calendar.DATE, 05);
      	c.set(Calendar.YEAR, 1996);
      	
      	Date badDate = c.getTime();
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, badDate, description);
        });
      	
      	assertEquals("Invalid date", exception.getMessage());
        
	}
	
	@DisplayName("Test bad constructor null date")
	@Test
	void testNullDate() {
        String id = "1";
      	String description = "This is a good description";    	
      	Date badDate = null;
      	
      	Calendar c = Calendar.getInstance();
      	
      	c.set(Calendar.MONTH, 11);
      	c.set(Calendar.DATE, 05);
      	c.set(Calendar.YEAR, 2025);
      	
      	Date goodDate = c.getTime();
      	
      	Appointment tempAppt = new Appointment(id, goodDate, description);      	
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, badDate, description);
        });
      	
      	assertEquals("Invalid date", exception.getMessage());
      	
      	exception = assertThrows(IllegalArgumentException.class, () -> {
        	tempAppt.setDate(null);
        });
      	
      	assertEquals("Invalid date", exception.getMessage());
	}
	
	@DisplayName("Test bad decription too long")
	@Test
	void testLongDesc() {
        String id = "1";
      	String description = "This description is way toooooooo long for it to be valid and should cause an error";    	
      	Calendar c = Calendar.getInstance();
      	
      	c.set(Calendar.MONTH, 11);
      	c.set(Calendar.DATE, 05);
      	c.set(Calendar.YEAR, 2025);
      	
      	Date goodDate = c.getTime();
      	
      	
      	Appointment tempAppt = new Appointment(id, goodDate, "test");
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, goodDate, description);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());
      	
      	exception = assertThrows(IllegalArgumentException.class, () -> {
        	tempAppt.setDescription(description);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());
	}
	
	@DisplayName("Test bad decription null")
	@Test
	void testNullDesc() {
        String id = "1";
      	String description = null;    	
      	Calendar c = Calendar.getInstance();
      	
      	c.set(Calendar.MONTH, 11);
      	c.set(Calendar.DATE, 05);
      	c.set(Calendar.YEAR, 2025);
      	
      	Date goodDate = c.getTime();
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, goodDate, description);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());
	}
	
	@DisplayName("Test bad decription empty")
	@Test
	void testEmptyDesc() {
        String id = "1";
      	String description = "";    	
      	Calendar c = Calendar.getInstance();
      	
      	c.set(Calendar.MONTH, 11);
      	c.set(Calendar.DATE, 05);
      	c.set(Calendar.YEAR, 2025);
      	
      	Date goodDate = c.getTime();
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, goodDate, description);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());
	}
	
}
