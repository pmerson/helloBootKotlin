package pmerson.hello.application

import java.time.LocalDateTime

class GreetingDto(var greeting: String) {
    var dateTime = LocalDateTime.now()
}

