package Task;

import java.util.concurrent.atomic.AtomicLong;

/*************************
 * Name: 	Joseph Caron 
 * Description: This is the task class. It creates and stores task information.
 *************************/



public class Task {
	private final String taskId;
	private String name;
	private String description;
	private static AtomicLong newTaskId = new AtomicLong(0);
	private String tempId;
	
	public Task(String name, String description) {
		tempId = String.valueOf(newTaskId.getAndIncrement());
		if (tempId == null || tempId.isEmpty() || tempId.length() > 10) { // throwing exception for invalid task id
			throw new IllegalArgumentException("Invalid task ID");
		}
		this.taskId = tempId; // setting task id
		setName(name); // calls method to set name
		setDescription(description); // calls method to set description 
	}
	
	public String getTaskId() {
		return taskId; 
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty() || name.length() > 20) { // Throwing exception for invalid name
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if (description == null || description.isEmpty() || description.length() > 50) { // Throwing exception for invalid description
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = description;
	}

}
