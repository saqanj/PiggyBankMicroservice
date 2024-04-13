# Piggy Bank Application Overview
This application contains support for the four basic REST commands: GET, POST, PUT, and DELETE through the vehicle of a basic PiggyBank Application on Java using Springboot for the Web Framework, Swagger for the UI, and Gradle for building the application. A pre-made Dockerfile and several YAML files for the deployment, configmap, and service specifications are provided so the application can run on a Kubernetes Cluster! Additionally, the application provides CI/CD support through a verify.yaml file located under the .github/workflow directory for managing a github workflow which builds and tests get/request mappings after each commit. 

Please contact me if you have any questions/improvements at: sanjum@trincoll.edu

## Dependencies
JDK 20+
Gradle
Docker with K8's

## Building the Application
Before running the application locally, on Docker, and/or Kubernetes, you should execute a Gradle build to ensure the latest code version and jar file is being used. This can be done by running the following on your terminal:
```bash
./gradlew build
```

## Running Locally
### After executing the build, simply run this command on a terminal in your application's directory:
```bash
java -jar target/PiggyBankMicroservice-0.0.1-SNAPSHOT.jar
```

## Running on Docker
### 1. In order to run the application on Docker, go to the application's root directory and run the following command to build the docker image
```bash
docker build -t pbank .
```
### 2. Run the docker container after the image has successfully built. You can pick between the two provided commands to run with logs or detached:
```bash
docker run -p 8080:8080 pbank
```
```bash
docker run -d -p 8080:8080 pbank
```
### 3. Access the application's SwaggerUI on the following localhost URL:
### http://localhost:8080/swagger-ui/index.html


 # Run/UI Directions:
  * Make sure to use my docker image sanjum1/piggybank as the image reference in the deployment.yaml file!
  * Then, have a kubernetes cluster running on your local machine and run "kubectl apply -f apply yamls" to run the
    microservice on Kubernetes!
  * You can then access http://localhost:31234/swagger-ui/index.html to see the SwaggerUI for the application.
  * Additionally, you can run "curl localhost:31234/(INSERT REST CALL HERE)" on your terminal to view the
    terminal output of each REST call.
  * For a call to the Fibonacci method, you must use the following terminal command:
    "curl localhost:31234/fib?length=(INSERT DESIRED FIBONACCI NUMBER HERE)". 
