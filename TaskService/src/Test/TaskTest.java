package Test;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the unit test for the task class
 *************************/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {
	
	Task task = new Task("Name", "Description"); 

	@Test
	@DisplayName("Test an invalid name")
	void testTaskName() { // tests to ensure a name of over 20 characters returns as invalid
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName("ThisIsATestNameForTheTest");
		});
	}
	
	@Test
	@DisplayName("Test an invalid null name")
	void testNullName() { // tests to ensure a null name returns as invalid
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}
	
	
	@Test
	@DisplayName("Test an invalid description")
	void testTaskDescription() { // tests to ensure a description of over 50 characters returns as invalid
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription("HolyMolyThisDescriptionIsWayTooLongWowICannotBelieveIt");
		});
	}
	
	@Test
	@DisplayName("Test an invalid null description")
	void testNullDescription() { // tests to ensure a null description returns as invalid
		assertThrows(IllegalArgumentException.class, () -> {
        	task.setDescription(null);
        });
	}
	
	@Test
	@DisplayName("Test task ID getter")
	void testTaskIdGetter() { // tests that getting task id works
		assertNotNull(task.getTaskId());
	}
	
	@Test
	@DisplayName("Test name getter")
	void testNameGetter() { // tests that getting task name works
		assertNotNull(task.getName());
	}
	
	@Test
	@DisplayName("Test description getter")
	void testDescriptionGetter() { // tests that getting task description works
		assertNotNull(task.getDescription());
	}
}
	