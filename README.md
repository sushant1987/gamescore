### 1. Required Software

**Docker Engine**<br />
**Apache Maven 3.9.4**

### 2. How to build & run the project


| **Purpose**                                | **Command**                                          |
|--------------------------------------------|-------------------------------------------------------|
| Build jar files                            | ```mvn clean package```                                    |
| Build docker images & start the containers | ```docker-compose up -d```                                  |
| Restart project           | ```docker-compose stop```
| Cleanup project (docker compose)           | ```docker-compose down --rmi all```

### 3. Logging

Actuator is added and logger URL

[Logger](http://localhost:8080/actuator/loggers)

### 4. Url
**Register High score**<br />
[http://localhost:8080/v1/highscores](http://localhost:8080/v1/highscores)<br />
For new User and New Title <br />
```json
{"score": "136" ,"title":{"name": "first title"}, "user": {"firstName": "First Name", "lastName": "Last"}}
```
<br />
<br />
For new User and Existing Title <br />
```json
{"score": "136" ,"title":{"id": "64f1fe3c053c0f580eb33f6d"}, "user": {"firstName": "First Name", "lastName": "Last"}}
```
<br />

For Existing User and New Title <br />
```json
{"score": "136" ,"title":{"name": "second title"}, "user": {"id": "64f1fdbd053c0f580eb33f65"}}
```

** Fetching a list of highscore for a title with rank of user**
<br />
[http://localhost:8080/v1/highscores/titles/{titleId}](http://localhost:8080/v1/highscores/titles/{titleId})<br />

**Fetch full list of high scores**<br />
[http://localhost:8080/v1/highscores/](http://localhost:8080/v1/highscores/)

### 5. Pending  Task

** Fetching of a user's highscore and rank per title in the system**<br />
**Swagger**<br />
**DTO at Controller**