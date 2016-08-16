package homework1.taskemployee;

public class Employee {
	private static final int DEFAULT_WORKING_HOURS = 8;
	private String name;
	private Task currentTask;
	private int hoursLeftInForWorking;
	private AllWork allWork;

	Employee(String name) {
		if ((name == null) || (name.equals(""))) {
			System.out.println("Name must be non-empty parameter");
			this.name = "Unknowned";
			return;
		}
		this.name = name;
	}

	void work() {
		if (this.hoursLeftInForWorking == 0) {
			System.out.println("I cant work anymore");
			return;
		}

		if (this.hoursLeftInForWorking < 0) {
			System.out.println("Hours must be positive");
			return;
		}

		if (this.allWork == null) {
			System.out.println("Tasks must be set to non null value");
			return;
		}

		giveMeMoreTasks();

		// dokato chasovete sa mi poveche ot 0 => raboti
		while (this.hoursLeftInForWorking > 0) {

			if (this.currentTask == null) {
				System.out.println(this.name + " has no more work");
				return;
			}

			if (this.hoursLeftInForWorking > currentTask.getWorkingHours()) {
				this.hoursLeftInForWorking -= currentTask.getWorkingHours();
				this.currentTask.setWorkingHours(0);
				System.out.println(this.name + " ended " + this.currentTask);
				giveMeMoreTasks();

				// No More work in the queue
				if (this.currentTask == null) {
					return;
				}

			} else {
				if (this.hoursLeftInForWorking < currentTask.getWorkingHours()) {
					currentTask.setWorkingHours(currentTask.getWorkingHours() - this.hoursLeftInForWorking);
					this.hoursLeftInForWorking = 0;
				} else {
					this.hoursLeftInForWorking = 0;
					this.currentTask.setWorkingHours(0);
					giveMeMoreTasks();
				}
			}
		}
		showReport();

	}

	private void giveMeMoreTasks() {
		if (this.currentTask == null) {
			this.currentTask = this.allWork.getNextTask();
			//ima oshte rabota
			if (this.currentTask != null) {
				System.out.println("First task of " + this.name + " is " + this.currentTask);
				return;
			}
			
			System.out.println(this.name+ " is relaxing");
			return;
		}

		if ((this.currentTask.getWorkingHours() == 0) && (this.allWork.isAllWorkDone() == false)) {
			this.currentTask = this.allWork.getNextTask();
			System.out.println(this.name + " got his next task" + this.currentTask);
		} else {
			if (this.currentTask.getWorkingHours() != 0) {
				System.out.println(this.currentTask + " will be continued next day by" + this.name);
			} else {
				System.out.println("No work anymore for " + this.name);
				this.currentTask = null;
				return;
			}
		}
	}

	private void showReport() {
		if (currentTask.getName() == null) {
			System.out.println("Must set name of the Task! Probabbly invalid data is inserted in Task!");
			return;
		}

		System.out
				.println("After working " + this.getName() + " has " + this.getHoursLeftInForWorking() + " hours left");
		System.out.println(this.currentTask.getName() + " needs only " + this.currentTask.getWorkingHours()
				+ " more from " + this.name);
	}

	void startWorkingDay() {
		setHoursLeftInForWorking(8);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if ((name == null) || (name.equals(""))) {
			System.out.println("Name must be non-empty parameter");
			this.name = "Unknowned";
			return;
		}
		this.name = name;
	}

	public int getHoursLeftInForWorking() {
		return hoursLeftInForWorking;
	}

	public void setHoursLeftInForWorking(int hoursLeftInForWorking) {
		if (hoursLeftInForWorking <= 0) {
			System.out.println("Hour must be postive ");
			this.hoursLeftInForWorking = DEFAULT_WORKING_HOURS;
			return;
		}
		this.hoursLeftInForWorking = hoursLeftInForWorking;
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		if (currentTask != null) {
			this.currentTask = currentTask;
		} else {
			System.out.println("Please add me a normal task, not a null reference");
		}
	}

	public AllWork getAllWork() {
		return allWork;
	}

	public void setAllWork(AllWork allWork) {
		this.allWork = allWork;
	}
}
