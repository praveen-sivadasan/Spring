# Spring boot application

1. Clone the Spring boot project
> git clone https://github.com/praveen-sivadasan/Spring.git

2. Package the project using maven
> mvn clean install
Creates a gs-spring-boot-0.1.0.jar in the target folder

3. Run the application using maven
> mvn spring-boot:run

4. Open browser and run the URL
> http://localhost:8080/

5a. Terminate the application by running the following in CMD for windows
Identify the PID for port 8080
> netstat -ano | findstr :8080

5b. Kill the PID
> taskkill /PID 47752 /F
