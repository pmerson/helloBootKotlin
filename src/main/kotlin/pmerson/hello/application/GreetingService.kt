package pmerson.hello.application

import org.springframework.stereotype.Service

@Service
class GreetingService {

    fun createGreeting(name: String?): GreetingDto {
        if (name == null || name.isBlank())
            return GreetingDto("Hello mysterious user. What's your name?")
        return GreetingDto("Hello $name!")
    }

}