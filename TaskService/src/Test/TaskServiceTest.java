package Test;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the unit test for the task service class
 *************************/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

import Task.TaskService;


@TestMethodOrder(OrderAnnotation.class)
class TaskServiceTest {
	TaskService serviceTest = new TaskService();

	@Test
	@DisplayName("Test to ensure tasks can be added")
	@Order(1)
	void testAddTask() { // tests adding a task 
		serviceTest.addTask("TaskName", "TaskDescription");
		assertNotNull(serviceTest.taskMap.get("0"), "Task was not added correctly");
	}
	
	@Test
	@DisplayName("Test to edit name.")
	@Order(2)
	void testEditName() { // tests editing the name of a task
		serviceTest.addTask("TaskName", "TaskDescription");
		serviceTest.editName("1", "NewTask");
		assertEquals("NewTask", serviceTest.taskMap.get("1").getName(), "Name not changed");
	}
	
	@Test
	@DisplayName("Test to edit description")
	@Order(3)
	void testEditDescription() { // tests editing the last name of the contact
		serviceTest.addTask("TaskName", "TaskDescription");
		serviceTest.editDescription("2", "NewDescription");
		assertEquals("NewDescription", serviceTest.taskMap.get("2").getDescription(), "Description not changed");
	}
	
	@Test
	@DisplayName("Test to add multiple tasks to hash map")
	@Order(4)
	void testAddMultiple() { // tests adding multiple tasks to the hash map
		serviceTest.addTask("TaskName", "TaskDescription");
		serviceTest.addTask("SecondName", "SecondDescription");
		assertEquals(2, serviceTest.taskMap.size(), "Multiple tasks not added");
	}
	
	@Test
	@DisplayName("Test to ensure task can be deleted")
	@Order(5)
	void testDeleteContact() { // tests deleting the task from the hash map
		serviceTest.addTask("TaskName", "TaskDescription");
		serviceTest.deleteTask("5");
		assertNull(serviceTest.taskMap.get("5"), "Task not deleted");
	}
	
	@Test
	@DisplayName("Test to attempt to edit name of non-existant task")
	@Order(6)
	void testEditNameNull() { // tests editing name of task that doesn't exist
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.editName("12", "Name");
		});
	}
	
	@Test
	@DisplayName("Test to attempt to edit description of non-existant task")
	@Order(7)
	void testEditDesciptionNull() { // tests editing description of task that doesn't exist
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.editDescription("12", "Description");
		});
	}
	
	@Test
	@DisplayName("Test to attempt to delete non-existant task")
	@Order(8)
	void testDeleteNull() { // tests deleting task that doesn't exist
		assertThrows(IllegalArgumentException.class, () -> {
			serviceTest.deleteTask("12");
		});
	}
}
