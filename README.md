


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
`docker run -d -p 80:8080 -e "SPRING_PROFILES_ACTIVE=dev" pmerson/hello-boot-kotlin:latest`
    
#### Calling using curl
`curl --data "Paulo" --header "Content-Type: text/plain" --request POST http://localhost:80/api/greeting`

#### Stop the container
```
docker ps
docker stop <containerId>
```

#### Run with docker mounting a volume
`docker run -d -p 80:8080 -e "SPRING_PROFILES_ACTIVE=dev" --rm -v c:/TEMP:/data pmerson/hello-boot-kotlin:latest`
    

#### Push to docker hub
`docker push pmerson/hello-boot-kotlin`
It's the same as:
`docker push docker.io/pmerson/hello-boot-kotlin:latest`

#### Pull from docker hub
`docker pull pmerson/hello-boot-kotlin:v2`

#### List stopped containers
`docker ps -a`

#### Kill stopped containers
`docker rm <containerId>`

#### Remove image
`docker image <rm imageId>`

