# Project-3
Overview
This project is aimed at implementing a multi-threaded Key-Value Store using RPC (Remote Procedure Calls) in Java. The Key-Value Store server will be replicated across five distinct servers to increase bandwidth and ensure availability. A two-phase commit (2PC) protocol will be implemented for updates to ensure consistency across replicas. The client will be modified to communicate with any of the five KV replica servers and issue PUT, GET, and DELETE operations effectively.

Installation
Clone the repository to your local machine.
Ensure you have Java JDK installed.
Build the project using mvn clean install.
Run the server instances on five different machines or ports.
Run the client to test PUT, GET, and DELETE operations.
Usage
Start the server instances by running java -jar server.jar on each machine or port.
Run the client using java -jar client.jar to interact with the Key-Value Store servers.
Follow the prompts on the client to perform PUT, GET, and DELETE operations.
Project Structure
src/: Contains the Java source code for the client and server implementations.
target/: Contains the compiled JAR files after building the project.
Dependencies
Java JDK 11 or higher
Maven for building the project
