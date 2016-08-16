package homework1.taskemployee;

/*
 * I dont know if workingHours should be between 0 and 23 or it can be 
 * above 23. For example i don't know if "this task has to be done for 48 hours"
 * is a valid statement 
 */

public class Task {
	private String name;
	private int workingHours;

	public Task(String name, int workingHours) {
		if ((name == null) || (name.equals(""))) {
			System.out.println("Non- empty name please");
			this.name = "";
			return;
		}

		if ((workingHours <= 0)) {
			System.out.println("In what kind of world  you are living. Hours must be positive");
			return;
		}

		this.workingHours = workingHours;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if ((name == null) || (name.equals(""))) {
			System.out.println("Non- empty name please");
			this.name = "";
			return;
		}
		this.name = name;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		if ((workingHours < 0)) {
			System.out.println("In what kind of world  you are living. Hours must be positive");
			return;
		}

		this.workingHours = workingHours;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", workingHours=" + workingHours + "]";
	}
	
}
