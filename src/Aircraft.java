import java.util.Random;

// Status
// 1  Land Queue
// 2  Landing
// 3  Landed
// 4  Deboarding
// 5  Boarding
// 6  Depart Queue
// 7  Departing
// 8  Departed



public class Aircraft implements Runnable {

	private String flightNumber;
	private Random r = new Random();
	private String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String status;
	private String[] aircraftModels = { "Airbus A330", "Airbus A380", "Boeing 747", "Boeing 777" };
	private String model;
	private Runway runway;
	private AirTrafficControl ATC;
	private Clock clock;
	private Airport airport;

	public Aircraft(String status, Clock clock) {
		this.status = status;
		flightNumber = generateName();
		model = aircraftModels[r.nextInt(aircraftModels.length)];
		this.clock = clock;
	}

	public Aircraft(String status, Clock clock, Airport airport) {
		this.status = status;
		flightNumber = generateName();
		model = aircraftModels[r.nextInt(aircraftModels.length)];
		this.clock = clock;
		this.airport = airport;
	}

	public void landingOnAirport(Airport airport) {
		this.airport = airport;
	}

	public void connectATC(AirTrafficControl ATC) {
		this.ATC = ATC;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getAircraftModel() {
		return model;
	}

	private String generateName() {
		// Generate a flight number with 2 random alphabets and 4 numbers
		String flightNumber;
		StringBuilder sb = new StringBuilder(2);
		for (int i = 0; i < 2; i++) {
			sb.append(upperCase.charAt(r.nextInt(upperCase.length())));
		}
		flightNumber = sb.toString() + " ";
		for (int i = 0; i < 4; i++) {
			flightNumber += r.nextInt(10);
		}
		return flightNumber;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	public void setRunway(Runway runway) {
		this.runway = runway;
	}

	public void run() {
		loop: while (status != "Others") {
			switch (status) {
				case "Land Queue":
					synchronized (this) {
						// Waiitng in queue for runway to land
						try {
							this.wait();
						} catch (InterruptedException e) {
						}
					}
					status = "Landing";
					break;

				case "Landing":
					System.out.println(clock.getTime() + " || Flight " + flightNumber + "   >>>>>  " + "Aircraft is landing on "
							+ runway.getName() + ".");
					try {
						// Landing on runway
						Thread.sleep(10000);
					} catch (InterruptedException e) {
					}
					status = "Landed";
					break;

				case "Landed":
					System.out.println(clock.getTime() + " || Flight " + flightNumber + "   >>>>>  "
							+ "Aircraft has successfully landed on " + runway.getName() + ".");
					// Aircraft left runway, notify runway for next task
					synchronized (runway) {
						runway.notify();
					}
					// Remove runway instance from aircraft
					runway = null;
					status = "Deboarding";
					break;

				
			}
		}
	}
}