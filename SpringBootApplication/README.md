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

5. Terminate the application by running the following in CMD for windows
> netstat -ano | findstr :8080
> taskkill /PID 47752 /F
Note: 47752 is the PID which can be identified from the netstat command