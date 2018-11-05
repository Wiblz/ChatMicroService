# ChatMicroService


## Build & Run

You can build and run the application use :
```
./mvnw spring-boot:run 
```
#### Build
Or you can build the JAR file with:

```
./mvnw clean package
```
#### Run
Then you can run the JAR file:
```
java -jar target/gs-accessing-data-mysql-0.1.0.jar
```


## Using REST service

###### To get chat messeges with specific service id and customer id:
```
GET http://localhost:8000/dialog/aquire/service/{servise_id}/customer/{customer_id}
```
###### To save chat messege:
```
POST http://localhost:8000/dialog/dialog/save
```
The request body should have this structure
```
{
	"serviceId" :  "666",
	"customerId" : "777",
  	"messegeBody" : "Hello, I would like to clean my shoes, mister. Do still you provide this service",
	"fromServiceProvider" : "true"
}
```
fromServiceProvider means that messege was sent from service owner, if true, and vice versa otherwise. 

###### To get all messeges:
```
GET http://localhost:8000/dialog/aquire/all
```