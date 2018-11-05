# ChatMicroService


## Build & Run

#### Build and Run
You can build and run the application using:
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
java -jar target/<Name of the jar file>.jar
```


## Using REST service

#### To get chat messeges with specific service id and customer id:
```
GET http://localhost:8000/dialog/aquire/service/{servise_id}/customer/{customer_id}
```

The response should have this structure:
```
[  
   {
        "id": 199802,
        "serviceId": 18,
        "customerId": 6,
        "time": "2013-11-05T02:16:35",
        "fromServiceProvider": true,
        "messegeBody": "Hello, I can do any dirty job for 5$, no more and no less"
    }, 
    {
        "id": 199801,
        "serviceId": 17,
        "customerId": 6,
        "time": "2015-11-05T02:17:00",
        "fromServiceProvider": false,
        "messegeBody": "Can you help me to clean my dirty cat, I`ve tried almost everything"
    }
]
```

#### To save chat messege:
```
POST http://localhost:8000/dialog/dialog/save
```
The request body should have this structure:
```
{
    "serviceId" :  "666",
    "customerId" : "777",
    "messegeBody" : "Hello, I would like to clean my shoes, mister. Do you still provide this service?",
    "fromServiceProvider" : "false"
}
```
fromServiceProvider means that messege was sent from service owner, if true, and vice versa otherwise. 

#### To get all messeges:
```
GET http://localhost:8000/dialog/aquire/all
```
