import java.util.concurrent.PriorityBlockingQueue;

public class AirTrafficControl {
	PriorityBlockingQueue<Task> taskQueue = null;
	private AirTrafficControlIncoming ATCI;
	private Thread tATCI;

	public AirTrafficControl(PriorityBlockingQueue<Task> taskQueue, Clock clock, Airport airport) {
		this.taskQueue = taskQueue;

		ATCI = new AirTrafficControlIncoming(taskQueue, this, clock, airport);
		tATCI = new Thread(ATCI);
		tATCI.start();
	}

	public synchronized void taskRequeue(Task task) {
		task.requeue();
		taskQueue.add(task);
	}


	public AirTrafficControlIncoming getATCI() {
		return this.ATCI;
	}


}