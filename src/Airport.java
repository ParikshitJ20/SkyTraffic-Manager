import java.util.ArrayList;

public class Airport {
	private int airportSize = 10;
	private ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();

	public synchronized boolean permissionToLand(Aircraft aircraft) {
		if (aircrafts.size() >= airportSize) {
			return false;
		} else {
			aircrafts.add(aircraft);
			return true;
		}
	}

	public void addAircraft(Aircraft aircraft) {
		aircrafts.add(aircraft);
	}

	
}