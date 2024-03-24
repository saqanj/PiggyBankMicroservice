# Piggy Bank Application
  * This application contains support for the four basic REST commands: GET, POST, PUT, and DELETE through the 
    vehicle of a basic PiggyBank Application on Java using Springboot for the Web Framework, Swagger for the UI, 
    and Gradle for building the application.
 * A pre-made Dockerfile is provided which allows you to download the source code onto your local machine, and 
    deploy it in the form of a container anywhere!
 * Please contact me if you have any questions/improvements at: sanjum@trincoll.edu

 # Build/Run/UI Directions:
  * Make sure to use my docker image sanjum1/piggybank as the image reference in the deployment.yaml file!
  * Then, have a kubernetes cluster running on your local machine and run "kubectl apply -f apply yamls" to run the microservice on Kubernetes!
  * You can then access http://localhost:31234/swagger-ui/index.html to see the SwaggerUI for the application.
  * Additionally, you can run "curl localhost:31234/(INSERT REST CALL HERE)" on your terminal to view the terminal output of each REST call.
  * For a call to the Fibonacci method, you must use the following terminal command: "curl localhost:31234/fib?length=(INSERT DESIRED FIBONACCI NUMBER HERE)". 
