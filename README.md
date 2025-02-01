AirTraffic Control Simulation
AirTraffic Control Simulation is a multi-threaded Java application designed to manage and coordinate aircraft landings and takeoffs efficiently. The simulation ensures optimal runway usage and minimizes delays while addressing challenges like deadlocks and thread starvation.

Features
Multi-threading: Simulates multiple aircraft operations concurrently.
Synchronization: Implements mutexes and semaphores for safe resource access.
Deadlock Prevention: Designed to prevent deadlock situations.
Starvation Avoidance: Ensures all aircraft receive attention without indefinite waiting.
Realistic Simulation: Emulates real-world air traffic control scenarios.
Getting Started
Prerequisites
Java JDK 8 or later
An IDE or text editor (e.g., IntelliJ IDEA, Eclipse)
Maven/Gradle (if used for dependency management)
Installation
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/AirTrafficControlSimulation.git
cd AirTrafficControlSimulation
Compile the project:

If using Maven:

bash
Copy
Edit
mvn compile
Or, compile manually with:

bash
Copy
Edit
javac -d bin src/*.java
Running the Simulation
Run the main class:

bash
Copy
Edit
java -cp bin com.yourpackage.Main
The simulation will start and display the status of aircraft operations on the console.

Code Structure
Main.java: Entry point for the simulation.
RunwayManager.java: Manages runway access using synchronization.
Aircraft.java: Represents individual aircraft threads.
Controller.java: Coordinates aircraft operations.
Contributing
Contributions are welcome! Please fork the repository and create a pull request with your improvements.
