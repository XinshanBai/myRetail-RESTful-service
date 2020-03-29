# myRetail-RESTful-service
This is just a simple demo project to show that I can learn the basics about Spring Boot and create a simple API in a short period of time.

No test was written, I can run this and use postman to test on my local machine.

## Getting Started
Download and install the following software if you do not have them on your machine.

**JDK8**  
To install java, [download JDK8 installer](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) and add/update the `JAVA_HOME` variable to JDK install folder.  
Include `path_to_JDK8/bin` directory in `PATH` variable.

**Maven**  
[Download Maven](https://maven.apache.org/download.cgi) and add `MAVEN_HOME` Environment Variables.  
Include `path_to_maven/bin` directory in `PATH` variable.  

**MongoDB**  
[Download MongoDB](https://www.mongodb.com/download-center/community)
Include `path_to_mongodb\Server\version_number\bin` directory in `PATH` variable.  

**Postman**  
[Download Postman](https://www.postman.com)
Double click to install it, you can also use the Postman Chrome App if you prefer

Download or pull the code to your local machine.

## Running and Testing

### Start MongoDB
* Open windows shell, create a db direcotry, for example `md "C:\data\db"`
* Start mongodb by executing `mongod --dbpath="c:\data\db"`, wait for a few seconds, now your MongoDB should be running
* Also start MongoDB Compass Community, this is the UI tool for MongoDB, it should be already installed together with MongoDB, start it and connect to your MongoDB. (No configuration needed, just click on the connect button, by default, this will connect to your running MongoDB at localhost:27017

### Build the Project
* Go to project root direcotry(where the POM file is)
* Open windows shell here, execute `mvn clean package`
* Go to the newly generated target folder, verify the jar file is there
* Open windows shell here, execute `java -jar <newly built jar file name>`, you should see no error, now the API server is running

### Test
* Open your Postman, import the "myRetail-RESTful-service tests.postman_collection.json", this file can be found at the root folder of this project. Now you should have 4 requests in your Postman.
* Use **POST CreatePrice** to create new price entries for testing. Example request body is provided.
* Use **GET GetProductDetails** to test the API, this call will get the `productName` from the external API provided by Target and combine it with the `ProductPrice` values in the MongoDB, and return the product's detail as requested in the case study
* Use **PUT UpdatePrice** to update the `ProductPrice` entry in the MongoDB, this is the bouns request in the case study
* Use **DELETE Delete Price** to delete the `ProductPrice` entry in the MongoDB  
*To verify the changes in your MongoDB, go to MongoDB Compass Community, click on the refresh button to check the changes*
