


hello-ms - Hello World microservice 
-------------------------------------------------------

Hello World microservice to give a simple example of the use of:
 
* Kotlin
* Spring Boot
* Gradle
* Docker



#### Build
`gradlew build`

#### Build with docker 
    docker run --rm -e "SPRING_PROFILES_ACTIVE=dev" -v c:/sti/repo_maven_local:/repository -v C:/sti/fontes-tcu/git/sofia-ms:/home/gradle/project -w /home/gradle/project gradle:4.8.1-jdk8-alpine gradle build

#### Build with docker 
    docker run --rm -e "SPRING_PROFILES_ACTIVE=dev" -v c:/sti/repo_maven_local:/repository -v C:/sti/fontes-tcu/git/sofia-ms:/home/gradle/project -w /home/gradle/project gradle:4.8.1-jdk8-alpine gradle build
    
#### Dependency hierarchy
Run `gradlew htmlDependencyReport` to generate an HTML report with the dependency hierarchy.

