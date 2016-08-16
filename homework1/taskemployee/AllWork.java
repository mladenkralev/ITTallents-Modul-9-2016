package homework1.taskemployee;

import java.util.Arrays;

public class AllWork {
	private final int DEFAULT_NUMBER_OF_TASKS = 10;

	private Task[] tasksToDo;
	private int freePlacesForTasks;
	private int currentUnassignedTask;

	public AllWork() {
		this.tasksToDo = new Task[DEFAULT_NUMBER_OF_TASKS];
		this.freePlacesForTasks = DEFAULT_NUMBER_OF_TASKS;
		// not needed but it's fine
		this.currentUnassignedTask = 0;
	}

	void addTask(Task newTask) {
		for (int index = 0; index < tasksToDo.length; index++) {
			if (tasksToDo[index] == null) {
				tasksToDo[index] = newTask;
				freePlacesForTasks--;
				return;
			}
		}

		System.out.println("No space Left for this task");
		return;
	}

	Task getNextTask() {
		// end of the array of tasks => reset current Task;
		if (currentUnassignedTask == DEFAULT_NUMBER_OF_TASKS) {
			currentUnassignedTask = 0;
		}

		if (tasksToDo[currentUnassignedTask] == null) {
			System.out.println("emptry set");
			return null;
		} else {
			Task tempTask = tasksToDo[currentUnassignedTask];
			tasksToDo[currentUnassignedTask] = null;
			currentUnassignedTask++;
			freePlacesForTasks++;
			return tempTask;
		}
	}

	boolean isAllWorkDone() {
		return (freePlacesForTasks == 10) ? true : false;
	}
}
