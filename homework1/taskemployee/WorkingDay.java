package homework1.taskemployee;

public abstract class WorkingDay {
	static int dayCounter = 0;

	private static void startDay(Employee[] workers) {
		for (int index = 0; index < workers.length; index++) {
			workers[index].startWorkingDay();
		}
	}

	private static void startWorking(Employee[] workers) {
		for (int index = 0; index < workers.length; index++) {
			workers[index].work();
		}
	}

	static void passADay(Employee[] workers) {
		System.out.println("Day: " + (dayCounter++));
		WorkingDay.startDay(workers);
		WorkingDay.startWorking(workers);
	}
}
