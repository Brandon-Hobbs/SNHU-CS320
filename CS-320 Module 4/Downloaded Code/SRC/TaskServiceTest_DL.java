/*
 * Brandon Hobbs
 * CS-320
 * 7/20/2022
 */

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskServiceTest_DL {

	@AfterEach
	void tearDown() throws Exception {
		TaskService_DL.tasks.clear();
	}

	@DisplayName("Add a Task")
	@Test
	void testAddUniqueTask() {
        String id = "0";
      	String fullName = "Greg Tippton";
        String description = "This is a good description";
        
        TaskService_DL tempTask = new TaskService_DL();
        
        assertEquals(0, TaskService_DL.tasks.size());
        
        tempTask.addUniqueTask(fullName, description);
       
		assertTrue(TaskService_DL.tasks.containsKey(id));
		assertEquals(fullName, TaskService_DL.tasks.get(id).getName());
		assertEquals(description, TaskService_DL.tasks.get(id).getDescription());              
        
	}

	/**
	* Add 3 contacts via addTask delete object at id 1 check that there is no
	* object there
	*/
	@DisplayName("Test deleteContact")			  
	@Test void testDeleteTask() {
				  
      	String fullName = "Greg Tippton";
        String description = "This is a good description";
		  
        TaskService_DL tempTask = new TaskService_DL();
        
        assertEquals(0, TaskService_DL.tasks.size());

        tempTask.addUniqueTask(fullName, description); //obj 0
        tempTask.addUniqueTask(fullName, description); //obj 1
        tempTask.addUniqueTask(fullName, description); //obj 2
		  
		assertEquals(3,TaskService_DL.tasks.size());
		  
		tempTask.deleteTasks("1");
		  
		assertEquals(2,TaskService_DL.tasks.size());
		assertFalse(TaskService_DL.tasks.containsKey("1"));
			 
	}
	/*
	 * create a task and then update with good id
	 */
	@DisplayName("Test updateTask with a good ID")
	@Test
	void testUpdateTasks() {
		String id = "0";
		String fullName = "Greg Tippton";
        String description = "This is a good description";
		  
        TaskService_DL tempTask = new TaskService_DL();
        
        tempTask.addUniqueTask(fullName, description); //obj 0

        tempTask.updateTasks("0", fullName, "New description");
        assertEquals("New description", TaskService_DL.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService_DL.tasks.get(id).getName());
        
	}
	
	/*
	 * create a task and then update with bad id
	 */
	@DisplayName("Test updateTask with a bad ID")
	@Test
	void testBadUpdateTasks() {
		String id = "0";
		String fullName = "Greg Tippton";
        String description = "This is a good description";
		  
        TaskService_DL tempTask = new TaskService_DL();
        
        tempTask.addUniqueTask(fullName, description); //obj 0

        tempTask.updateTasks("1", fullName, "New description");
        assertNotEquals("New description", TaskService_DL.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService_DL.tasks.get(id).getName());
        
	}

}
