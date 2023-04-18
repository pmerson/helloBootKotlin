package pmerson.hello.application

import org.springframework.stereotype.Service
import java.io.File
import java.time.LocalDateTime

@Service
class GreetingService {

    fun createGreeting(name: String?): GreetingDto {
        val quote = File("data/quotes.txt").readText(Charsets.UTF_8)
        val dateTime = LocalDateTime.now()
        if (name.isNullOrBlank()) {
            return GreetingDto("Hello mysterious user. What's your name?", dateTime, quote)
        }
        return GreetingDto("Hello $name!", dateTime, quote)
    }

}