package homework1.taskemployee;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		Employee[] allEmployees = new Employee[4];
		allEmployees[0] = new Employee("Krasimir");
		allEmployees[1] = new Employee("Mladen");
		allEmployees[2] = new Employee("Gosho Turboto");
		allEmployees[3] = new Employee("Nekromir");

		AllWork testWork = new AllWork();
		testWork.addTask(new Task("Testing software", 3));
		testWork.addTask(new Task("Borba s godzili", 2));
		testWork.addTask(new Task("Piene na greena Rakia", 11));
		testWork.addTask(new Task("strelqne na ptici s chinii", 19));
		testWork.addTask(new Task("Pisane na ese za deteto na prezidenta", 11));
		testWork.addTask(new Task("Osvobojdavane na bulgaria", 1));
		testWork.addTask(new Task("kupuvane na chai za ofisa", 5));
		testWork.addTask(new Task("hodene po ogun", 6));
		testWork.addTask(new Task("karane s shefa", 4));
		testWork.addTask(new Task("chupene na stuklata na kolata na shefa", 1));

		for (int index = 0; index < allEmployees.length; index++) {
			showAllTaskToCurrentEmployee(allEmployees[index], testWork);
		}

		while ((!testWork.isAllWorkDone()) || (checkIfAnyEmployeesHaveTasks(allEmployees))) {
			System.out.println();
			WorkingDay.passADay(allEmployees);
		}

	}

	static void showAllTaskToCurrentEmployee(Employee currentEmployee, AllWork currentTasks) {
		currentEmployee.setAllWork(currentTasks);
	}

	static boolean checkIfAnyEmployeesHaveTasks(Employee[] allEmployees) {
		for (int index = 0; index < allEmployees.length; index++) {
			if (allEmployees[index].getCurrentTask() != null){
				return true;
			}
		}
		return false;
	}
}
