import java.util.concurrent.PriorityBlockingQueue;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {

		Comparator<Task> priorityComparator = Comparator.comparing(Task::getPriority);
		PriorityBlockingQueue<Task> taskQueue = new PriorityBlockingQueue<Task>(10, priorityComparator);

		Airport airport = new Airport();
		Clock clock = new Clock();
		AirTrafficControl ATC = new AirTrafficControl(taskQueue, clock, airport);
		Runway runway1 = new Runway(taskQueue, "Runway 1", clock, ATC);
	

		Thread tRunway1 = new Thread(runway1);
		

		for (int i = 0; i < 2; i++) {
			Aircraft aircraft = new Aircraft("Land Queue", clock);
			aircraft.connectATC(ATC);
			Thread t = new Thread(aircraft);
			t.start();
			Task task = new Task(aircraft, 'L', 'N', airport);
			taskQueue.put(task);
			System.out.println(clock.getTime() + " || ATC              >>>>>  Flight "
					+ task.getTaskAircraft().getFlightNumber() + " is waiting in queue to	land.");
		}
		

		tRunway1.start();
		
	}
}
