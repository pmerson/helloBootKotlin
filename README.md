


hello-ms - Hello World microservice 
-------------------------------------------------------

Hello World microservice to give a simple example of the use of:
 
* Kotlin
* Spring Boot
* Gradle
* Docker



#### Build
`gradlew build`

#### Create docker image
`docker build -t pmerson/hello-boot-kotlin:latest .`

#### Run with docker
`docker run -d  -p 80:8080 -e "SPRING_PROFILES_ACTIVE=dev" pmerson/hello-boot-kotlin:latest`
    
#### Calling using curl
`curl --data "Paulo" --header "Content-Type: text/plain" --request POST http://localhost:80/api/greeting`

#### Stop the container
`docker ps`
`docker stop *containerId*`


