# CredibancoAPI
This is a Credibanco assessment wich consist in create an API for managing cards and implements an interface with AngularJS, it was constructed with Spring Boot and Maven with a MySql database.


This App is not complete, several details are missing, like exception implementation, handle of user errors and asure data integrity, that without mentioning the design.



For using this App you must clone the repository. If you use Eclipse as IDE just create a new project, go to File options and select "Import" then search Existing Maven Project, locate in the folder selector the CredibancoAPI directory, and click on "select". If you se a pom.xml loaded on the projects square then it's the right location, if not try again searching for the correct place. When you finish with this window it will start to download the maven dependecies. Meanwhile you can start the database, wich has to be a MySQL. In my case I used XAMPP for creating it, but feel free to start it as you prefer. When it is on create a database called "credibanco". 

Once you have this and eclipse has finished then you can excecute as a java application the CredibancoAssessmentApplication.java class, it should put on the server and create the tables needed, then you can go to your http://localhost:8080/ and play with the operations.
