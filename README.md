SkyTraffic-Manager
SkyTraffic-Manager is a multi-threaded Java application designed to simulate air traffic control operations. It efficiently manages and coordinates aircraft landings and takeoffs while addressing synchronization challenges such as deadlock prevention and starvation avoidance.

Features
Multi-threading: Simulates concurrent aircraft operations.
Synchronization: Uses mutexes and semaphores for safe runway access.
Deadlock Prevention & Starvation Avoidance: Ensures smooth operation without indefinite waiting.
Realistic Simulation: Models real-world air traffic control scenarios for optimal runway utilization.
Getting Started
Prerequisites
Java JDK 8 or later
An IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor
Maven or Gradle (optional, if you use dependency management)
Installation
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/SkyTraffic-Manager.git
cd SkyTraffic-Manager
Compile the project:

If using Maven:

bash
Copy
Edit
mvn compile
Or compile manually:

bash
Copy
Edit
javac -d bin src/*.java
Running the Simulation
Run the main class to start the simulation:

bash
Copy
Edit
java -cp bin com.yourpackage.Main
The simulation will launch, displaying aircraft operations and runway statuses on the console.

Code Structure
Main.java: The entry point of the simulation.
RunwayManager.java: Manages runway access using synchronization techniques.
Aircraft.java: Represents individual aircraft as threads.
Controller.java: Coordinates overall air traffic operations.
Contributing
Contributions are welcome! Fork the repository and submit a pull request with your improvements or bug fixes.
