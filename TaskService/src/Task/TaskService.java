package Task;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the task service class. It maintains a map of tasks 
 * and can add or delete tasks, or edit the name or description of existing tasks
 *************************/

import java.util.Map;
import java.util.HashMap;

public class TaskService {
	String taskId;
	
	public Map <String, Task> taskMap = new HashMap<>(); // create hash map to hold all tasks
	
	public void addTask(String name, String description) { // method to add task to map
		
		Task task = new Task(name, description); // creates task object with string task id, name and description
		taskId = task.getTaskId();
		if (taskMap.get(taskId) != null) { // throwing exception if task id is not unique
			throw new IllegalArgumentException("Contact ID already in use");
		}
		taskMap.put(taskId, task); // add task to map
		
	}
	
	public void deleteTask(String taskId) { // method to delete task from map
		if (!taskMap.containsKey(taskId)) { // Throwing exception if task isn't found
			throw new IllegalArgumentException("Task not found");
		}
		taskMap.remove(taskId);
	}
	
	public void editName(String taskId, String name) { // method to edit task name
		if (!taskMap.containsKey(taskId)) { // Throwing exception if task isn't found
			throw new IllegalArgumentException("Task not found");
		}
		taskMap.get(taskId).setName(name);
	}
	
	public void editDescription(String taskId, String description) { // method to edit task description
		if (!taskMap.containsKey(taskId)) { // Throwing exception if task isn't found
			throw new IllegalArgumentException("Task not found");
		}
		taskMap.get(taskId).setDescription(description);
	}

}
